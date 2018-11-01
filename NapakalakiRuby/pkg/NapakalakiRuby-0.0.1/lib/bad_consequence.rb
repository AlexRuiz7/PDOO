# coding: utf-8

require_relative 'treasure_kind.rb'

module Napakalaki

  class BadConsequence
  
    # CONSULTORES
  
    #attr_reader :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :death,
     # :specificVisibleTreasures, :specificHiddenTreasures, :MAXTREASURES
     
    def getLevels
      @levels
    end
    
    def isDeath
      @death
    end
    
    # INICIALIZADOR
    
    @@MAXTREASURES=10
    def initialize(text, levels, nVisibleTreasures, nHiddenTreasures, specificVisibleTreasures,
        specificHiddenTreasures, death)
      @text=text
      @levels=levels
      @nVisibleTreasures=nVisibleTreasures
      @nHiddenTreasures=nHiddenTreasures
      @specificVisibleTreasures=specificVisibleTreasures
      @specificHiddenTreasures=specificHiddenTreasures
      @death=death
    end
  
    private_class_method :new;
  
    def self.newLevelNumberOfTreasures(txt, lvl, visibleTreasures, hiddenTreasures)
      new(txt, lvl, visibleTreasures, hiddenTreasures, Array.new, Array.new, false)
    end
  
    def self.newLevelSpecificTreasures(txt, lvl, specVisibleTreasures, specHiddenTreasures)
      new(txt, lvl, 0, 0, specVisibleTreasures, specHiddenTreasures, false)
    end
  
    def self.newDeath(txt)
      new(txt, 10, @@MAXTREASURES, @@MAXTREASURES, Array.new, Array.new, true)
    end
    
    # MÉTODOS
    
    # Devuelve true si no hay mal rollo por cumplir.
    
    def isEmpty
      empty=false
      
      if(@levels==0 and @death==false and @nVisibleTreasures==0 and @nHiddenTreasures==0 and 
         @specificVisibleTreasures.empty? and @specificHiddenTreasures.empty? )
        empty=true
      end
      
      return empty
    end
    
    
    # Elimina el tesoro t del mal rollo.
    
    def substractVisibleTreasure(t)
      if(!@specificVisibleTreasures.empty?)
        index=@specificVisibleTreasures.index(t.getType)
        @specificVisibleTreasures.delete_at(index)
      elsif(@nVisibleTreasures != 0)
          @nVisibleTreasures -= 1
      end
    end
    
    
    # Elimina el tesoro t del mal rollo.
    
    def substractHiddenTreasure(t)
      if(!@specificHiddenTreasures.empty?)
        index=@specificHiddenTreasures.index(t.getType)
        @specificHiddenTreasures.delete_at(index)
      elsif(@nHiddenTreasures != 0)
          @nHiddenTreasures -= 1
      end
    end
    
    def adjustToFitTreasureLists(v, h)
      if(@specificVisibleTreasures.empty? and @specificHiddenTreasures.empty?)
        nVTreasures = [v.size, @nVisibleTreasures].min
        nHTreasures = [h.size, @nHiddenTreasures].min

        bc = BadConsequence.newLevelNumberOfTreasures(@text, 0, nVTreasures, nHTreasures)
      else
        adjusted_specific_visible=Array.new
        adjusted_specific_hidden=Array.new
        treasure_kind=Array.new
        
        treasure_kind << TreasureKind::ARMOR
        treasure_kind << TreasureKind::ONEHAND
        treasure_kind << TreasureKind::BOTHHANDS
        treasure_kind << TreasureKind::HELMET
        treasure_kind << TreasureKind::SHOES
        puts "treasure kind loop"
        treasure_kind.each do |tKind|
          min1=min2=0

          # Contamos cuantos tesoros tenemos de cada tipo en el jugador y en BC
          
          @specificVisibleTreasures.each do |vKind|
            if(vKind == tKind)
              min1+=1
            end
          end
          puts "sv loop"
          v.each do |vKind|
            if(vKind.getType == tKind)
              min2+=1
            end
          end
          puts "v loops"
          # Añadimos el numero mínimo de tesoros al BC
          puts min1
          puts min2
          i=0
          while(i<[min1, min2].min)
            adjusted_specific_visible << tKind
            i+=1
          end
          puts "add v"
          # Reseteamos contadores y hacemos lo mismo para los tesoros ocultos
          
          min1=min2=0
          
          @specificHiddenTreasures.each do |hKind|
            if(hKind == tKind)
              min1+=1
            end
          end
          puts "sh loop"
          h.each do |hKind|
            if(hKind.getType == tKind)
              min2+=1
            end
          end
          puts "h loops"
          # Añadimos el numero mínimo de tesoros al BC
          puts min1
          puts min2
          i=0
          while(i<[min1, min2].min)
            adjusted_specific_hidden << tKind
            i+=1
          end
          puts "add h"
        end
        
        bc = BadConsequence.newLevelSpecificTreasures(@text, 0, adjusted_specific_visible, adjusted_specific_hidden)
        
      end
        puts bc.to_s
      return bc
      
    end
    
    # Método to_string
    
    def to_s
      "Mal Rollo-> #{@text}, niveles: #{@levels},
        Tesoros Visibles: #{@nVisibleTreasures}, Tesoros Ocultos: #{@nHiddenTreasures},
        Muerte: #{@death}, Tesoros Visibles Espec.: #{@specificVisibleTreasures}, 
        Tesoros Ocultos Esp.: #{@specificHiddenTreasures}";
    end
  
  end

end