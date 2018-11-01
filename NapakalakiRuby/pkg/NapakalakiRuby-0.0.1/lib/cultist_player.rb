# coding: utf-8

require_relative 'cultist.rb'

module Napakalaki

  class CultistPlayer < Player
  
    # CONSULTORES
  
    def self.getTotalCultistPlayers
      @@TOTALCULTISTPLAYERS
    end
  
    # Inicializador que llama al inicializador de la clase padre Player
  
    @@TOTALCULTISTPLAYERS=0
    def initialize(p, c)
      super(p)
      @myCultistCard=c
      @@TOTALCULTISTPLAYERS += 1
    end
 
    # MÉTODOS
  
  
    # Devuelve el nivel de combate del jugador siendo sectario.
  
    def getCombatLevel
      combat_lvl=super*1.2
      return (combat_lvl + @myCultistCard.getGainedLevels*@@TOTALCULTISTPLAYERS).to_i
    end
  
  
    # Devuelve el nivel de combate del monstruo a combatir.
  
    def getOponentLevel(m)
      m.getCombatLevelAgainstCultistPlayer
    end
  
  
    # Método redefinido. Devleve siempre false. Se es sectario toda la partida.
  
    def shouldConvert
     return false
    end
  
    def giveMeATreasure
      n=Random.rand(@visibleTreasures.size)
      
      return @visibleTreasures.delete_at(n)
    end
  
  
    # Devuelve true si el enemigo del jugador tiene tesoros visibles para robar.
  
    def canYouGiveMeATreasure
      return !@enemy.getVisibleTreasures.empty?
    end
    
    
    # Método to_string
    
    def to_s
      "#{@name}  Nivel: #{@level}  Nivel de combate: #{getCombatLevel}"
    end
    
  end

end