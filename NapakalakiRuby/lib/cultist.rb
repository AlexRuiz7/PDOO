# coding: utf-8

module Napakalaki

  class Cultist
  
    # CONSULTORES
  
    def getGainedLevels
      @gainedLevels
    end
  
    # Inicializador que llama al inicializador de la clase padre Player
  
    def initialize(name, gainedLevels)
      @name=name
      @gainedLevels=gainedLevels
    end

  end

end