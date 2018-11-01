# coding: utf-8

require_relative 'treasure.rb'
require_relative 'bad_consequence.rb'
require_relative 'dice.rb'

module Napakalaki
  
  class Player
    
    # CONSULTORES
    
    def getName
      @name
    end
    
    def getVisibleTreasures
      @visibleTreasures
    end
    
    def getHiddenTreasures
      @hiddenTreasures
    end
    
    def getLevels
      @level
    end
    
    def isDead
      @dead
    end
    
    def canISteal
      @canISteal
    end
    
    def getEnemy
      @enemy
    end
    
    
    # INICIALIZADOR
    
    @@MAXLEVEL=10
    def initialize(name)
      @name=name
      @level=1
      @dead=true
      @canISteal=true
      @visibleTreasures=Array.new
      @hiddenTreasures=Array.new
      @pendingBadConsequence=BadConsequence.newLevelNumberOfTreasures("", 0, 0, 0)
    end
    
    # CONSTRUCTOR DE COPIA
    
    def Player(p)
      @name=p.name
      @level=p.level
      @dead=p.dead
      @canISteal=p.canISteal
      @visibleTreasures=p.visibleTreasures
      @hiddenTreasures=p.hiddenTreasures
      @pendingBadConsequence=p.pendingBadConsequence
      @enemy=p.enemy
    end
    
    # MÉTODOS
    
    
    # Revive al jugador.
    
    private
    def bringToLife
      @dead=false
    end
    
    
    # Calcula el nivel de combate del jugador según las normas del juego.

    def getCombatLevel
      lvl=0
      
      @visibleTreasures.each do |t|
        lvl += t.getBonus
      end
      
      return @level + lvl
    end
    
    
    # Aumenta el nivel del jugador en l niveles.

    def incrementLevels(l)
      @level += l
      
      if(@level > @@MAXLEVEL)
        @level = 10
      end
    end
    
    
    # Decrementa el nivel del jugador en l niveles.

    def decrementLevels(l)
      @level -= l
      
      if(@level <= 0)
        @level = 1
      end
    end
    
    
    # Actualiza el mal rollo por cumplir del jugador.

    def setPendingBadConsequence(b)
      @pendingBadConsequence=b
    end
    
    
    # plica el buen rollo del monstruo m.
    
    def applyPrize(m)
      incrementLevels(m.getLevelsGained)
      
      if(m.getTreasuresGained > 0)
        dealer=CardDealer.instance
        
        i=0
        while(i<m.getTreasuresGained)
          @hiddenTreasures.push(dealer.nextTreasure)
          i = i+1
        end
        
      end
      
    end
    
    
    # Aplica el mal rollo del monstruo m.
    
    def applyBadConsequence(m)
      if(m.getBadConsequence.isDeath)
        discardAllTreasures
      else
        decrementLevels(m.getBadConsequence.getLevels)
        pbc=m.getBadConsequence.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
        setPendingBadConsequence(pbc)
      end

    end
    
    
    # Comprueba si se puede equipar el tesoro t según las reglas del juego.
    
    def canMakeTreasureVisible(t)
      can_make=true
      
      # Sólo se puede tener un tesoro de cada tipo, excepto ONEHAND que se 
      # permite tener 2.
      
      # Recuento de ONEHAND/BOTHHANDS equipados.
      
      one_hand=0
      both_hands=false
      
      @visibleTreasures.each do |x|
        if(x.getType==TreasureKind::ONEHAND)
          one_hand+=1
        end
        if(x.getType==TreasureKind::BOTHHANDS)
          both_hands=true
        end
      end
      if( (one_hand>0 and t.getType==TreasureKind::BOTHHANDS) or
          (both_hands and t.getType==TreasureKind::ONEHAND) )
            can_make=false
      else
        @visibleTreasures.each do |x|
          if( (x.getType==t.getType and x.getType!=TreasureKind::ONEHAND) or
              (t.getType==TreasureKind::ONEHAND and one_hand>1) )
                can_make=false
          end
        end
      end

      return can_make
    end
    
    
    # Devuelve el número de tesoros visibles de tipo tKind que tiene el jugador.

    def howManyVisibleTreasures(tKind)
      total
      
      @visibleTreasures.each do |t|
        if (t.getType == tKind)
          total += 1
        end
      end
      
      return total
    end
    
    
    # Mata al jugador si no tiene tesoros. Implica reiniciar su nivel.
    
    def dieIfNoTreasures
      if (@visibleTreasures.empty? && @hiddenTreasures.empty?)
        @dead = true
        @level = 1      
      end
    end
    
    public
    
    # Desarrolla la lucha del jugador con el monstruo dado. Si el nivel de
    # combate del jugador es mayor que el del monstruo, el jugador gana.
    # Se comprueba si el jugador ha ganado la partida.
    # Devuelve un objeto del tipo CombatResult.
    
    def combat(m)
      
      if(getCombatLevel >= getOponentLevel(m))
        applyPrize(m)
        
        if(@level >= @@MAXLEVEL)
          combat_result=CombatResult::WINGAME
        else
          combat_result=CombatResult::WIN
        end
     
      else
        applyBadConsequence(m)
        if(shouldConvert)
          combat_result=CombatResult::LOSEANDCONVERT
        else
          combat_result=CombatResult::LOSE
        end
        
      end
      
      return combat_result
    end
    
    
    # Equipa el tesoro dado siempre que el jugador pueda hacerlo.
    # Pasa el tesoro t de los tesoros ocultos a los visibles.
    
    def makeTreasureVisible(t)
      
      if(canMakeTreasureVisible(t))
        @visibleTreasures.push(t)
        index=@hiddenTreasures.index(t)
        @hiddenTreasures.delete_at(index)
      end
      
    end
    
    
    # Elimina el tesoro t del los tesoros visibles del jugador. Se elimina 
    # también de su mal rollo pendiente. Por último se comprueba si el jugador
    # se ha quedado sin tesoros, en cuyo caso muere.
    
    def discardVisibleTreasure(t)
      index=@visibleTreasures.index(t)
      @visibleTreasures.delete_at(index)
      
      if(!@pendingBadConsequence.nil? and !@pendingBadConsequence.isEmpty )
            @pendingBadConsequence.substractVisibleTreasure(t)
      end
      
        dieIfNoTreasures();
    end
    
    
    # Elimina el tesoro t del los tesoros ocultos del jugador. Se elimina 
    # también de su mal rollo pendiente. Por último se comprueba si el jugador
    # se ha quedado sin tesoros, en cuyo caso muere.

    def discardHiddenTreasure(t)
      index=@hiddenTreasures.index(t)
      @hiddenTreasures.delete_at(index)
      
      if(!@pendingBadConsequence.nil? and !@pendingBadConsequence.isEmpty )
            @pendingBadConsequence.substractVisibleTreasure(t)
      end
      
        dieIfNoTreasures();
    end
    
    
    # Devuelve true si el jugador no tiene BC que cumplir ni más de 4 tesoros
    # ocultos.
    
    def validState
      valid_state=false
      
      if(@pendingBadConsequence.isEmpty and @hiddenTreasures.count <= 4)
        valid_state=true
      end
      
      return valid_state
    end
    
    
    # Reparte tesoros al jugador en caso de que sea su primer turno o que se
    # haya quedado sin ellos.

    def initTreasures
      dealer=CardDealer.instance
      bringToLife

      @hiddenTreasures.push(dealer.nextTreasure)
      
      dice=Dice.instance
      number=dice.nextNumber
      
      if(number > 1)
        @hiddenTreasures.push(dealer.nextTreasure)
      end
      if(number == 6)
        @hiddenTreasures.push(dealer.nextTreasure)
      end
    end
    
    
    # Roba un tesoro oculto al azar a su enemigo y lo almacena en sus tesoros
    # ocultos. Comprueba que puede robar y que el enemigo tiene tesoros ocultos.
    
    def stealTreasure
      t=nil
      
      if(canISteal)
        if(@enemy.canYouGiveMeATreasure)
          t=@enemy.giveMeATreasure
          @hiddenTreasures.push(t)
          haveStolen
        end
      end
    
      return t
    end
    
    
    # Asigna un enemigo al jugador.
    
    def setEnemy(enemy)
      @enemy=enemy
    end
    
    protected
    # Devuelve un tesoro elegido al azar de entre los tesoros ocultos del jugador.
    
    def giveMeATreasure
      n=Random.rand(@hiddenTreasures.size)
      
      return @hiddenTreasures.delete_at(n)
    end
    
    
    # Devuele true si tiene tesoros(ocultos) que pueden ser robados por otro
    # jugador, falso en caso contrario.

    def canYouGiveMeATreasure
      return !@hiddenTreasures.empty?
    end
    
    
    # Cambia el atributo canISteal a false cuando el jugador roba un tesoro.
    private
    def haveStolen
      @canISteal=false
    end
    
    
    # Descarta todos los tesoros del jugador.
    
    public
    def discardAllTreasures
      visible_treasures_cpy=Array.new(@visibleTreasures)
      hidden_treasures_cpy=Array.new(@hiddenTreasures)
      
      visible_treasures_cpy.each do |t|
        discardVisibleTreasure(t)
      end
      
      hidden_treasures_cpy.each do |t|
        discardHiddenTreasure(t)
      end
      
    end
    
    # Comprueba si el jugador pasa a sectario después de perder un combate.
    
    def shouldConvert
      return Dice.instance.nextNumber==1
    end
    
    
    # Devuelve el nivel de combate del monstruo a combatir.
    
    def getOponentLevel(m)
      m.getCombatLevel
    end
    
    
    # Método to_string
    
    def to_s
      "#{@name}  Nivel: #{@level}  Nivel de combate: #{getCombatLevel}"
    end
  
  end

end