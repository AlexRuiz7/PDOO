
package napakalaki;

import java.util.Random;

/**
 *
 * @author alex
 */
public class CultistPlayer extends Player{
    
    
    // DECLARACIÓN DE VARIABLES
    
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    
    // CONSTRUCTOR

    public CultistPlayer(Player p, Cultist c) {
        super(p);
        myCultistCard = c;
        totalCultistPlayers++;
    }
    
    
    // MÉTODOS
    
    @Override
    public int getCombatLevel() {
        int combatLvl = (int) (super.getCombatLevel()*1.2);
        
        return combatLvl + myCultistCard.getGainedLevels()*totalCultistPlayers;
    }
    

    @Override
    protected int getOponentLevel(Monster m) {
        return m.getLevelChangeAgainstCultistPlayer();
    }

    
    @Override
    protected boolean shouldConvert() {
        return false;
    }

    
    @Override
    protected boolean canYouGiveMeATreasure() {
        return !enemy.getVisibleTreasures().isEmpty();
    }

    
    @Override
    protected Treasure giveMeATreasure() {
        Random rnd = new Random();
        int n = rnd.nextInt(getVisibleTreasures().size());
        
        return getVisibleTreasures().get(n);
    }

    public static int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }

    
    @Override
    public String toString() {
        return super.toString() + "Nivel de Combate Sectario: " + getCombatLevel();
    }
    
}
