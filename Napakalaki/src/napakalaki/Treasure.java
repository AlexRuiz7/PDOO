
package napakalaki;

/**
 *
 * @author alex
 */
public class Treasure {
    
    // DECLARACIÓN DE VARIABLES
    
    private String name;
    private int bonus;
    private TreasureKind type;
    
    // CONSTRUCTOR

    public Treasure(String name, int bonus, TreasureKind type) {
        this.name = name;
        this.bonus = bonus;
        this.type = type;
    }
    
    // GETTERS

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    public TreasureKind getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Tesoro: " + name + ", bonus=" + bonus + ", tipo=" + type;
    }
    
}