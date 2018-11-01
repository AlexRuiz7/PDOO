
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author alex
 */
public class CardDealer {
    
    // DECLARACIÓN DE VARIABLES
    
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Cultist> unusedCultists;
    
    // CONSTRUCTOR
    
    
    private CardDealer() {
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        unusedCultists = new ArrayList();
    }
    
    public static CardDealer getInstance() {
        return CardDealerHolder.INSTANCE;
    }
    
    private static class CardDealerHolder {

        private static final CardDealer INSTANCE = new CardDealer();
    }
    
    // MÉTODOS
    
    
    // Inicializa el mazo de cartas de tesoros.
    
    private void initTreasuresCardDeck(){
        
        System.out.println("Cargando tesoros.\n");
        
        // Tesoro: ¡Sí, mi amo!
        
        unusedTreasures.add(new Treasure("¡Sí, mi amo!", 4, TreasureKind.HELMET));
        
        // Tesoro: Botas de investigación
        
        unusedTreasures.add(new Treasure("Botas de investigación", 3, TreasureKind.SHOES));
        
        // Tesoro: Capucha de Cthulhu
        
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
        
        // Tesoro: A prueba de babas
        
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        
        // Tesoro: Botas de lluvia ácida
        
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS));
        
        // Tesoro: Cascco minero
        
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        
        // Tesoro: Ametralladora Thompson
        
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS));
        
        // Tesoro: Camiseta de la UGR
        
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR));
        
        // Tesoro: Clavo de raíl ferroviario
        
        unusedTreasures.add(new Treasure("Clavo de raíl ferroviario", 3, TreasureKind.ONEHAND));
        
        // Tesoro: Cuchillo de sushi arcano
        
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        
        // Tesoro: Fez alópado
        
        unusedTreasures.add(new Treasure("Fez alópado", 3, TreasureKind.HELMET));
        
        // Tesoro: Hacha prehistórica
        
        unusedTreasures.add(new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND));
        
        // Tesoro: El aparato del Pr. Tesla
        
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
        
        // Tesoro: Gaita
        
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        
        // Tesoro: Insecticida
        
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        
        // Tesoro: Escopeta de 3 cañones
        
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        
        // Tesoro: Garabato místico
        
        unusedTreasures.add(new Treasure("Garabato místico", 2, TreasureKind.ONEHAND));
        
        // Tesoro: La rebeca metálica
        
        unusedTreasures.add(new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR));
        
        // Tesoro: Lanzallamas
        
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        
        // Tesoro: Necro-comicón
        
        unusedTreasures.add(new Treasure("Necro-comicón", 1, TreasureKind.ONEHAND));
        
        // Tesoro: Necronomicón
        
        unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
        
        // Tesoro: Linterna a 2 manos
        
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        
        // Tesoro: Necro-gnomicón
        
        unusedTreasures.add(new Treasure("Necro-gnomicón", 2, TreasureKind.ONEHAND));
        
        // Tesoro: Necrotelecom
        
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        
        // Tesoro: Mazo de los antiguos
        
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
        
        // Tesoro: Necro-playboycón
        
        unusedTreasures.add(new Treasure("Necro-playboycón", 3, TreasureKind.ONEHAND));
        
        // Tesoro: Porra preternatural
        
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        
        // Tesoro: Shogulador
        
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        
        // Tesoro: Varita de atizamiento
        
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
        
        // Tesoro: Tentáculo de pega
        
        unusedTreasures.add(new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET));
        
        // Tesoro: Zapato deja-amigos
        
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));
    }
    
    
    // Inicializa el mazo de cartas de monstruos.
    
    private void initMonstersCardDeck(){
        
        System.out.println("Cargando monstruos.\n");
        
        Prize prize;
        BadConsequence badconsequence;
        
        // Array vacío
        ArrayList n = new ArrayList();
        
        // Monstruo: Byakhees de bonanza
        
        badconsequence = new BadConsequence("Pierdes tu armadura"
                + " visible y otra oculta.", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)) );
        
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Byakhees de bonanza", 8, badconsequence, prize));
        
        // Monstruo: Chibithulhu
        
        badconsequence = new BadConsequence("Embobados con el lindo"
                + " primigenio te descartas de tu casco visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), n);
        
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badconsequence, prize));
        
        // Monstruo: El Sopor de Dunwich
        
        badconsequence = new BadConsequence("El primordial bostezo"
                + " contagioso. Pierdes el calzado visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.SHOES)), n);
        
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El Sopor de Dunwich", 2, badconsequence, prize));
        
        
        // Monstruo: Ángeles de la noche ibicenca
        
        badconsequence  = new BadConsequence("Te atrapan para "
               + "llevarte de fiesta y te dejan caer en mitad del vuelo. Descartas"
               + " 1 mano visble y 1 oculta.", 0, 
               new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
               new ArrayList(Arrays.asList(TreasureKind.ONEHAND)) );
       
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, badconsequence,
        prize));
       
        // Monstruo: El gorrón en el umbral
       
        badconsequence  = new BadConsequence("Pierdes todos tus"
                + " tesoros visibles.", 0, BadConsequence.MAXTREASURES, 0);
       
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 10, badconsequence,
        prize));
       
        // Monstruo: H.P Munchcraft
        
        badconsequence  = new BadConsequence("Pierdes la armadura"
               + " visible.", 0, 
               new ArrayList(Arrays.asList(TreasureKind.ARMOR)), n);
       
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("H.P Munchcraft", 6, badconsequence, prize));
       
        // Monstruo: Bichgooth
        
        badconsequence  = new BadConsequence("Sientes bichos bajo"
               + " la ropa. Descarta la armadura visible.", 0, 
               new ArrayList(Arrays.asList(TreasureKind.ARMOR)), n);
       
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badconsequence, prize));
       
        // Monstruo: El rey de rosa
        
        badconsequence  = new BadConsequence("Pierdes 5 niveles"
               + " y 3 tesoros visibles.", 5, 3, 0);
       
        prize = new Prize(4, 2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badconsequence, prize));
       
        // Monstruo: La que redacta en las tinieblas
        
        badconsequence  = new BadConsequence("Toses los pulmones."
               + " Pierdes 2 niveles.", 2, 0, 0);
       
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, 
                badconsequence, prize));
        
        // Monstruo: Los hondos
        
        badconsequence  = new BadConsequence("Estos monstruos "
               + "resultan bastante superficiales y te aburren mortalmente. "
                + "Estás muerto.", true);
       
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Los hondos", 8, badconsequence, prize));
    
        // Monstruo: Semillas Cthulhu
        
        badconsequence  = new BadConsequence("Pierdes 2 niveles"
               + " y 2 tesoros ocultos.", 2, 0, 2);
       
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badconsequence, prize));
       
        // Monstruo: Dameargo
        
        badconsequence  = new BadConsequence("Te intentas escaquear."
               + " Pierdes una mano visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), n);
       
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, badconsequence, prize));
        
        // Monstruo: Pollipólipo volante
        
        badconsequence  = new BadConsequence("Da mucho asquito. "
               + " Pierdes 3 niveles.", 3, 0, 0);
       
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badconsequence, prize));
        
        // Monstruo: Yskhtihyssg-Goth
        
        badconsequence  = new BadConsequence("No le hace gracia "
               + "que pronuncien mal su nombre. Estás muerto.", true);
       
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badconsequence, prize));
        
        // Monstruo: Familia feliz
        
        badconsequence  = new BadConsequence("La familia te atrapa"
               + ". Estás muerto.", true);
       
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badconsequence, prize));
        
        // Monstruo: Roboggoth
        
        badconsequence  = new BadConsequence("La quinta directiva "
               + "primaria te obliga a perder 2 niveles y un tesoro "
               + "'2 manos' visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), n);
       
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badconsequence, prize));
        
        // Monstruo: El espía
        
        badconsequence  = new BadConsequence("Te asusta en la noche "
               + ". Pierdes un casco visible.", 0, 
               new ArrayList(Arrays.asList(TreasureKind.HELMET)), n);
       
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espía", 5, badconsequence, prize));
        
        // Monstruo: El lenguas
        
        badconsequence  = new BadConsequence("Menudo susto te "
               + "llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
       
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El lenguas", 20, badconsequence, prize));
        
        // Monstruo: Bicéfalo
        
        badconsequence  = new BadConsequence("Te faltan manos para"
               + " tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las"
               + " manos", 3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,
               TreasureKind.ONEHAND, TreasureKind.ONEHAND)), n);
       
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badconsequence, prize));
        
        // Monstruo sectario: El mal indecible impronunciable
        
        badconsequence = new BadConsequence("Pierdes una mano visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), n);
        prize = new Prize(3, 1);
        
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badconsequence, prize, -2));
        
        // Monstruo sectario: Testigos Oculares
        
        badconsequence = new BadConsequence("Pierdes tus tesoros visibles", 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(2, 1);
        
        unusedMonsters.add(new Monster("Testigos Oculares", 6, badconsequence, prize, 2));
        
        // Monstruo sectario: El gran cthulhu
        
        badconsequence = new BadConsequence("Hoy no es tu día de suerte, Mueres", true);
        prize = new Prize(2, 5);
        
        unusedMonsters.add(new Monster("El gran cthulhu", 20, badconsequence, prize, 4));
        
        // Monstruo sectario: Serpiente Político
        
        badconsequence = new BadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2, 1);
        
        unusedMonsters.add(new Monster("Serpiente Político", 8, badconsequence, prize, -2));
        
        // Monstruo sectario: Felpuggoth
        
        badconsequence = new BadConsequence("Pierdes tu casco y tu armadura visible. "
                + "Pierdes tus manos ocultas", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND, TreasureKind.ONEHAND, TreasureKind.BOTHHANDS)));
        prize = new Prize(1, 1);
        
        unusedMonsters.add(new Monster("Felpuggoth", 2, badconsequence, prize, 5));
        
        // Monstruo sectario: Shoggoth
        
        badconsequence = new BadConsequence("Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(4, 2);
        
        unusedMonsters.add(new Monster("Shoggoth", 16, badconsequence, prize, -4));
        
        // Monstruo sectario: Lolitagooth
        
        badconsequence = new BadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        
        unusedMonsters.add(new Monster("Lolitagooth", 2, badconsequence, prize, 3));
    }
    
    
// Inicializa el mazo de sectarios.
    
    private void initCultistCardDeck(){
        
        for(int i=0; i<4; i++)
            unusedCultists.add(new Cultist("Sectario", 1));
        
        for(int i=0; i<2; i++)
            unusedCultists.add(new Cultist("Sectario", 2));
    }
    
    
    // Baraja el mazo de cartas de tesoros.
    
    private void shuffleTreasures(){
        Collections.shuffle(unusedTreasures);
    }
    
    
    // Baraja el mazo de cartas de monstruos. 
    
    private void shuffleMonsters(){
        Collections.shuffle(unusedMonsters);
    }
    
    
    // Baraja el mazo de sectarios.
    
    private void shuffleCultists(){
        Collections.shuffle(unusedCultists);
    }
    
    
    // Devuelve el siguiente tesoro que hay en el mazo de tesoros (unusedTreasures)
    // y lo elimina de él. En caso de estar vacío, reinicia el mazo barajando el
    // mazo de tesoros usados.
    
    public Treasure nextTreasure(){

        if(unusedTreasures.isEmpty()){
           unusedTreasures = new ArrayList(usedTreasures);
           usedTreasures.clear();
           shuffleTreasures();
        }

        return unusedTreasures.remove(0);
    }
    
    
    // Devuelve el siguiente monstruo que hay en el mazo de mosntruos (unusedMonsters)
    // y lo elimina de él. En caso de estar vacío, reinicia el mazo barajando el
    // mazo de monstruos usados.
    
    public Monster nextMonster(){

        if(unusedMonsters.isEmpty()){
           unusedMonsters = new ArrayList(usedMonsters);
           usedMonsters.clear();
           shuffleMonsters();
        }
        
        return unusedMonsters.remove(0);        
    }
    
    // Devuelve el siguiente sectario.
    
    public Cultist nextCultist(){
        return unusedCultists.remove(0);
    }
    
    // Añade el tesoro t al mazo de tesoros usados.
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    
    // Añade el monstruo m al mazo de monstruos usados.
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    
    // Inicializa los mazos de cartas.
    
    public void initCards(){
        initTreasuresCardDeck();
        initMonstersCardDeck();
        initCultistCardDeck();
        shuffleTreasures();
        shuffleMonsters();
        shuffleCultists();
    }
    
}