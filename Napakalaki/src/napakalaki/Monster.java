
package napakalaki;

/**
 *
 * @author alex
 */
public class Monster {
    
    // DECLARACIÓN DE VARIABLES
    
    private String name;
    private int combatLevel;
    private int levelChangeAgaisntCultistPlayer;
    
    private Prize prize;
    private BadConsequence bc;
    
    // CONSTRUCTORES

    public Monster(String name, int combatLevel, BadConsequence bc, Prize prize) {
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.bc = bc;
        levelChangeAgaisntCultistPlayer = 0;
    }
    
    public Monster(String n, int combatLvl, BadConsequence b, Prize p, int levelChange){
        name = n;
        combatLevel = combatLvl;
        bc = b;
        prize = p;
        levelChangeAgaisntCultistPlayer = levelChange;
    }
    
    
    // GETTERS

    public String getName() {
        return name;
    }

    public int getCombatLevel() {
        return combatLevel;
    }

    public BadConsequence getBadConsequence() {
        return bc;
    }
    
    public int getLevelsGained(){
        return prize.getLevel();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    
    public Prize getPrize(){
        return prize;
    }
    
    public int getLevelChangeAgainstCultistPlayer() {
        return (combatLevel + levelChangeAgaisntCultistPlayer);
    }
    
    
    // Método toString
    
    @Override
    public String toString() {
        return "Monstruo " + name + ": Nivel=" + " " + combatLevel + " " + prize + " " + bc;
    }
    
    /*
    public static void main(String [] args){
        Prize p = new Prize(7,4);
        BadConsequence bc = new BadConsequence("baia",3, 4, 2);
        Monster m = new Monster("Alex",5, p, bc);
        System.out.println(m.toString());
    }
    */
}