# coding: utf-8

module Napakalaki

  class Prize
  
    # CONSULTORES
  
    #attr_reader :levels, :treasures
    
    def getLevels
      @levels
    end
    
    def getTreasures
      @treasures
    end
  
    # INICIALIZADOR
  
    def initialize(treasures, levels)
      @treasures=treasures
      @levels=levels
    end
  
    def to_s
      "Tesoros ganados: #{@treasures} \n Niveles ganados: #{@levels}"
    end
  
  end

end