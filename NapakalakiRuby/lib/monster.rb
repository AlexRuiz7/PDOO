# coding: utf-8

require_relative 'prize.rb'
require_relative 'bad_consequence.rb'

module Napakalaki

  class Monster
  
    # CONSULTORES
  
    #attr_reader :name, :combatLevel, :prize, :bc
    
    def getName
      @name
    end
    
    def getCombatLevel
      @combatLevel
    end
    
    def getPrize
      @prize
    end
    
    def getBadConsequence
      @bc
    end
   
  
    # INCIALIZADOR
  
    def initialize(name, combatLevel, prize, bc, level_change=0)
      @name=name
      @combatLevel=combatLevel
      @prize=prize
      @bc=bc
      @levelChangeAgainstCultistPlayer=level_change
    end
    
    # Devuelve el número de niveles ganados proporcionados por su buen rollo.
    
    def getLevelsGained
      return @prize.getLevels
    end
    
    # Devuelve el número de tesoros ganados proporcionados por su buen rollo.
    
    def getTreasuresGained
      return @prize.getTreasures
    end
    
    
    def getCombatLevelAgainstCultistPlayer
      return @combatLevel + @levelChangeAgainstCultistPlayer
    end
    
    # Método to_string
    
    def to_s
      "Monstruo: #{@name}. Nivel de combate: #{@combatLevel} \n#{@prize} \n#{@bc}"
    end
  
  end
  
end