
package napakalaki;

import java.util.Random;

/**
 *
 * @author alex
 */
public class Dice {
    
    private Random generator=new Random();
    
    private Dice() {
    }
    
    public static Dice getInstance() {
        return DiceHolder.INSTANCE;
    }
    
    private static class DiceHolder {

        private static final Dice INSTANCE = new Dice();
    }
    
    public int nextNumber(){
        return (generator.nextInt(6)+1);
    }
        
}
