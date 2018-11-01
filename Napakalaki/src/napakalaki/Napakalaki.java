
package napakalaki;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author alex
 */
public class Napakalaki {
    
    // DECLARACIÓN DE VARIABLES
    
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer;
    
    // CONSTRUCTOR
    
    private Napakalaki() {
        currentMonster = null;
        currentPlayer = null;
        players = new ArrayList();
        dealer = CardDealer.getInstance();
    }
    
    public static Napakalaki getInstance() {
        return NapakalakiHolder.INSTANCE;
    }
    
    private static class NapakalakiHolder {

        private static final Napakalaki INSTANCE = new Napakalaki();
    }
    
    //  MÉTODOS
    
    
    // Inicializa el array de jugadores con los nombres dados.
    
    private void initPlayers(ArrayList<String> names){
        for(String n:names)
            players.add(new Player(n));
    }
    
    
    // Decide qué jugador es el siguiente en jugar.
    
    private Player nextPlayer(){
        int next;
        
        if(currentPlayer == null){
            Random generator = new Random();
            next = generator.nextInt(players.size());
        }
        else{
            if(players.indexOf(currentPlayer) == (players.size()-1))
                next = 0;
            else
                next = players.indexOf(currentPlayer) + 1;
        }
        
        currentPlayer = players.get(next);
        
        return currentPlayer;
    }
    
    
    // Devuelve si el jugador activo puede terminar su turno.
    
    public boolean nextTurnAllowed(){
        return (currentPlayer==null || currentPlayer.validState());
    }
    
    
    // Asigna un enemigo a cada jugador de manera aleatorio y evitando que un
    // jugador sea enemigo de sí mismo.
    
    private void setEnemies(){
        int enemy;
        Random ran = new Random();
        
        for(Player p:players){
            do{
                enemy = ran.nextInt(players.size());
            }while(enemy == players.indexOf(p));
            
            p.setEnemy(players.get(enemy));
        }

    }
    
    
    // Desarrolla la lucha entre el jugador actual y el monstruo actual.
    // Devuelve un objeto de tipo CombatResult.
    
    public CombatResult developCombat(){
        CombatResult combatResult = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        
        // Código para convertir a Sectario
        
        if(combatResult == CombatResult.LOSEANDCONVERT){
            CultistPlayer p = new CultistPlayer(currentPlayer, dealer.nextCultist());
            int pos = players.indexOf(currentPlayer);
            players.set(pos, p);
            currentPlayer = p;
            
            System.out.println("Ahora eres un jugador sectario.\n");
        }     
        
        return combatResult;
    }
    
    
    // Elimina los tesoros visibles indicados de la lista de tesoros visibles 
    // del jugador. Los tesoros descartados se devuelven al CardDealer.
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        
        for(Treasure t:treasures){
            currentPlayer.discardVisibleTreasure(t);
            dealer.giveTreasureBack(t);
        }
        
    }
    
    
    // Elimina los tesoros ocultos indicados de la lista de tesoros ocultos 
    // del jugador. Los tesoros descartados se devuelven al CardDealer.
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        
        for(Treasure t:treasures){
            currentPlayer.discardHiddenTreasure(t);
            dealer.giveTreasureBack(t);
        }
    
    }
    
    
    // Pasa los tesoros dados a visibles.
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        for(Treasure t:treasures)
            currentPlayer.makeTreasureVisible(t);
    }
    
    
    // Inicializa el juego pidiendo a CardDealer la inicialización de los mazos
    // de cartas, inicializa los jugadores y les asigna sus enemigos. Empieza
    // la ronda asignando el turno.
    
    public void initGame(ArrayList<String> names){
        dealer.initCards();
        initPlayers(names);
        setEnemies();
        nextTurn();
    }
    
    
    // Getter de currentMonster

    public Monster getCurrentMonster() {
        return currentMonster;
    }
    

    // Getter de currentPlayer
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    
    // Verifica si el jugador actual está en condiciones de acabar de turno.
    // Si se puede cambiar de turno, se actualiza currentMonster y currentPlayer.
    // En caso de que sea la primera jugada o que el jugador haya muerto se 
    // le reparte tesoros para que pueda jugar.
    
    public boolean nextTurn(){
       boolean stateOK = nextTurnAllowed();
        
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            
            if(currentPlayer.isDead())
                currentPlayer.initTreasures();
        }
        
        return stateOK;
    }
    
    
    // Devuelve true si el parámetro result es WINGAME
    
    public boolean endOfgame(CombatResult result){
        return (result == CombatResult.WINGAME);
    }
    
}   