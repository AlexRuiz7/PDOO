
package napakalaki;

import GUI.Dice;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author alex
 */
public class Player {
    
    // DECLARACIÓN DE VARIABLES
    
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    static int MAXLEVEL = 10;
    
    protected Player enemy;
    private ArrayList<Treasure> visibleTreasures;
    private ArrayList<Treasure> hiddenTreasures;
    private BadConsequence pendingBadConsequence;
    
    
    // CONSTRUCTOR
    
     public Player(String name) {
        this.name = name;
        level = 1;
        dead = true;
        canISteal = true;
        enemy = null;
        visibleTreasures = new ArrayList();
        hiddenTreasures = new ArrayList();
        pendingBadConsequence = new BadConsequence("", false);
    }
     
     
    // CONSTRUCTOR DE COPIA
     
    public Player(Player p){
        name = p.name;
        level = p.level;
        dead = p.dead;
        canISteal = p.canISteal;
        enemy = p.enemy;
        pendingBadConsequence = p.pendingBadConsequence;
        visibleTreasures = new ArrayList(p.visibleTreasures);
        hiddenTreasures = new ArrayList(p.hiddenTreasures);
    }
    
    
    // MÉTODOS

    public Player getEnemy() {
        return enemy;
    }

    public BadConsequence getPendingBadConsequence() {
        return pendingBadConsequence;
    }
    
    public String getName() {
        return name;
    }
    
    
    // Revive al jugador.
    
    private void bringToLife(){
        dead = false;
    }
    
    
    // Calcula el nivel de combate del jugador según las normas del juego.
    
    public int getCombatLevel(){
        int lvl = 0;
        
        for(Treasure t:visibleTreasures)
            lvl += t.getBonus();

        return level + lvl;
    }
    
    
    // Aumenta el nivel del jugador en l niveles.
    
    private void incrementLevels(int l){
        level += l;
        
        if(level > 10)
            level = 10;
    }
    
    
    // Decrementa el nivel del jugador en l niveles.
    
    private void decrementLevels(int l){
        level -= l;
        
        if(level < 1)
            level = 1;
    }
    
    
    // Actualiza el mal rollo por cumplir del jugador.
    
    private void setPendingBadConsequence(BadConsequence b) {
        pendingBadConsequence = b;
    }
    
    
    // Aplica el buen rollo del monstruo m.
    
    private void applyPrize(Monster m){
        incrementLevels(m.getLevelsGained());
        
        if(m.getTreasuresGained() > 0){
            CardDealer dealer = CardDealer.getInstance();
            
            for(int i=0; i<m.getTreasuresGained(); i++)
                hiddenTreasures.add(dealer.nextTreasure());
        }
    }
    
    
    // Aplica el mal rollo del monstruo m.
    
    private void applyBadConsequence(Monster m){
        if(m.getBadConsequence().isDeath())
            discardAllTreasures();
        else{
            decrementLevels(m.getBadConsequence().getLevels());
            BadConsequence pbc = m.getBadConsequence().adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
            setPendingBadConsequence(pbc);
        }
        
    }
    
    
    // Comprueba si se puede equipar el tesoro t según las reglas del juego.
    
    private boolean canMakeTreasureVisible(Treasure t){
        boolean canMake = true;
        
        // Sólo se puede tener un tesoro de cada tipo, excepto ONEHAND que se 
        // permite tener 2.
        
        // 5 tesoros equipados(como máximo) en caso de tener 2 ONEHAND
        // 4 tesoros equipados(como máximo) en caso de tener BOTHHANDS
        
        
        // Recuento de ONEHAND/BOTHHANDS equipados.
        
        int oneHand = 0;
        boolean bothHands = false;
        
        for(Treasure x:visibleTreasures){
            if(x.getType()==TreasureKind.ONEHAND)
                oneHand++;
            if(x.getType()==TreasureKind.BOTHHANDS)
                bothHands=true;
        }
        
        if( (oneHand>0 && t.getType()==TreasureKind.BOTHHANDS) ||
            (bothHands && t.getType()==TreasureKind.ONEHAND) )
                    canMake = false; 
        else
            for(Treasure x:visibleTreasures){
                if( (x.getType()==t.getType() && x.getType() != TreasureKind.ONEHAND)||
                    (t.getType() == TreasureKind.ONEHAND && oneHand>1) )
                        canMake = false;
        }
        
        return canMake;
    }
    
    
    // Devuelve el número de tesoros visibles de tipo tKind que tiene el jugador.
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int total = 0;
        
        for(Treasure t:visibleTreasures)
            if(t.getType()==tKind)
                total++;
            
        return total;
    }
    
    
    // Mata al jugador si no tiene tesoros. Implica reiniciar su nivel.
    
    private void dieIfNoTreasures(){
        
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty()){
            dead = true;
            level = 1;
        }
            
    }
    
    
    // Devuelve true si el jugador está muerto.
    
    public boolean isDead() {
        return dead;
    }
    
    
    // Devuelve los tesoros visibles del jugador.
    
    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    
    
    // Devuelve los tesoros ocultos del jugador.

    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }
    
    
    // Desarrolla la lucha del jugador con el monstruo dado. Si el nivel de
    // combate del jugador es mayor que el del monstruo, el jugador gana.
    // Se comprueba si el jugador ha ganado la partida.
    // Devuelve un objeto del tipo CombatResult.
    
    public CombatResult combat(Monster m){
        CombatResult combatResult;
        
        if(getCombatLevel() >= getOponentLevel(m)){
            applyPrize(m);
            
            if(level >= MAXLEVEL)
                combatResult = CombatResult.WINGAME;
            else
                combatResult = CombatResult.WIN;
        }   
        else{
            applyBadConsequence(m);
            if(shouldConvert())
                combatResult = CombatResult.LOSEANDCONVERT;
            else
                combatResult = CombatResult.LOSE;
        }
        
        return combatResult;
    }
    
    
    // Equipa el tesoro dado siempre que el jugador pueda hacerlo.
    // Pasa el tesoro t de los tesoros ocultos a los visibles.
    
    public void makeTreasureVisible(Treasure t){
        if(canMakeTreasureVisible(t)){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }       
    }
    
    
    // Elimina el tesoro t del los tesoros visibles del jugador. Se elimina 
    // también de su mal rollo pendiente. Por último se comprueba si el jugador
    // se ha quedado sin tesoros, en cuyo caso muere.
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        
        if(pendingBadConsequence != null && !pendingBadConsequence.isEmpty() )
            pendingBadConsequence.substractVisibleTreasure(t);
        
        dieIfNoTreasures();
    }
    
    
    // Elimina el tesoro t del los tesoros ocultos del jugador. Se elimina 
    // también de su mal rollo pendiente. Por último se comprueba si el jugador
    // se ha quedado sin tesoros, en cuyo caso muere.

    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        
        if(pendingBadConsequence != null && !pendingBadConsequence.isEmpty() )
            pendingBadConsequence.substractHiddenTreasure(t);
        
        dieIfNoTreasures();
    }
    
    
    // Devuelve true si el jugador no tiene BC que cumplir ni más de 4 tesoros
    // ocultos.
    
    public boolean validState(){
        return (pendingBadConsequence.isEmpty() && hiddenTreasures.size() <= 4);
    }
    
    
    // Reparte tesoros al jugador en caso de que sea su primer turno o que se
    // haya quedado sin ellos.
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        bringToLife();
        
        hiddenTreasures.add(dealer.nextTreasure());
        
        Dice dice = Dice.getInstance();
        int number = dice.nextNumber();
        
        if(number > 1)
            hiddenTreasures.add(dealer.nextTreasure());
        if(number == 6)
            hiddenTreasures.add(dealer.nextTreasure());
    }
    
    
    // Devuelve el nivel del jugador.
    
    public int getLevel() {
        return level;
    }
    
    
    // Roba un tesoro oculto al azar a su enemigo y lo almacena en sus tesoros
    // ocultos. Comprueba que puede robar y que el enemigo tiene tesoros ocultos.
    
    public Treasure stealTreasure(){
        Treasure t = null;
        
        if(canISteal())
            if(enemy.canYouGiveMeATreasure()){
                t = enemy.giveMeATreasure();
                hiddenTreasures.add(t);
                haveStolen();
            }
                
        return t;
    }
    
    
    // Asigna un enemigo al jugador.
    
    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
    
    
    // Devuelve un tesoro elegido al azar de entre los tesoros ocultos del jugador.
    
    protected Treasure giveMeATreasure(){
        Random rnd = new Random();
        int n = rnd.nextInt(hiddenTreasures.size());
        
        return hiddenTreasures.remove(n);
    }
    
    
    // Devuelve true si el jugador puede robar un tesoro.
    
    public boolean canISteal() {
        return canISteal;
    }
    
    
    // Devuelve true si tiene tesoros(ocultos) que pueden ser robados por otro
    // jugador, falso en caso contrario.
    
    protected boolean canYouGiveMeATreasure(){
        return !hiddenTreasures.isEmpty();
    }
    
    
    // Cambia el atributo canISteal a false cuando el jugador roba un tesoro.
    
    private void haveStolen(){
        canISteal = false;
    }
    
    
    // Descarta todos los tesoros del jugador.
    
    public void discardAllTreasures(){
        ArrayList<Treasure> visibleTreasurescpy = new ArrayList(visibleTreasures);
        ArrayList<Treasure> hiddenTreasurescpy = new ArrayList(hiddenTreasures);
        
        for(Treasure t:visibleTreasurescpy)
            discardVisibleTreasure(t);
        for(Treasure t:hiddenTreasurescpy)
            discardHiddenTreasure(t);
    }
    
    
    // Devuelve el nivel del combate del monstruo a combatir.
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    
    // Devuelve true si cumple las condiciones para convetirse a sectario.
    // Para ello debe perder un combate y sacar un 1 tras lanzar el dado.
    
    protected boolean shouldConvert(){
        Dice dice = Dice.getInstance();
        
        return dice.nextNumber() == 1;
    }
    
    // Método toString

    @Override
    public String toString() {
        if(pendingBadConsequence.isEmpty())
            return name + ", Nivel: " + level + ", Nivel de combate: " + getCombatLevel();
        else
            return name + " \nMAL ROLLO PENDIENTE: " + pendingBadConsequence.toString();            
    }
    
}