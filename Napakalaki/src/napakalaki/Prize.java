 
package napakalaki;

/**
 *
 * @author alex
 */
public class Prize {
    
    // DECLARACIÓN DE VARIABLES
    
    private int treasures;
    private int level;

    // CONSTRUCTORES
    
    public Prize(int treasures, int level) {
        this.treasures = treasures;
        this.level = level;
    }

    // GETTERS
    
    public int getTreasures() {
        return treasures;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Premio: " + "tesoros=" + treasures + ", nivel=" + level;
    }

}