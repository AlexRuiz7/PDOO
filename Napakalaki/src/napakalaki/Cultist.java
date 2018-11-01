
package napakalaki;

/**
 *
 * @author alex
 */
public class Cultist {
    
    // DECLARACIÓN DE VARIABLES
    
    private String name;
    private int gainedLevels;
    
    
    // CONSTRUCTOR

    public Cultist(String name, int gainedLevels) {
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    
    // GETTERS
    
    public String getName() {
        return name;
    }

    public int getGainedLevels() {
        return gainedLevels;
    }
    
    
    // MÉTODO TO_STRING

    @Override
    public String toString() {
        return name + ", Niveles Ganados: " + gainedLevels;
    }
 
}