# coding: utf-8

require_relative 'treasure_kind.rb'

module Napakalaki
  
  class Treasure
    
    # CONSULTORES
    
    def getType
      @type
    end
    
    def getBonus
      @bonus
    end
    
    def getName
      @name
    end
    
    # INICIALIZADOR
    
    def initialize(n, bonus, t)
      @name=n
      @bonus=bonus
      @type=t
    end
    
    # Método to_string

    def to_s
      "Tesoro: #{@name} \tBonus: #{@bonus} \tTipo: #{@type}"
    end
  
  end

end