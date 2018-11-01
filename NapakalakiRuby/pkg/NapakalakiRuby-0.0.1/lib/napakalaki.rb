# coding: utf-8

require 'singleton'
require_relative 'card_dealer.rb'
require_relative 'player.rb'
require_relative 'combat_result.rb'
require_relative 'cultist_player.rb'

module Napakalaki
  
  class Napakalaki
    
    include Singleton
    
    # COSULTORES
    
    def getCurrentPlayer
      @currentPlayer
    end
    
    def getCurrentMonster
      @currentMonster
    end
    
    
    # INICIALIZADOR
    
    def initialize
      @currentMonster=nil
      @currentPlayer=nil
      @players=Array.new
      @dealer=CardDealer.instance
    end
    
    # MÉTODOS
    
    private
    
    
    # Inicializa el array de jugadores con el array de nombres dados.
    
    def initPlayers(names)
      names.each do |n|
      @players << Player.new(n)
      end
    end
    
    
    # Decide qué jugador es el siguiente en jugar.
    
    def nextPlayer
      if(@currentPlayer.nil?)
        n=rand(@players.length).to_i
      else
        if(@players.index(@currentPlayer) == (@players.length - 1))
          n=0
        else
          n = @players.index(@currentPlayer) + 1
        end
      end

      @currentPlayer=@players.at(n)

      return @currentPlayer
    end

    
    # Devuelve si el jugador activo puede terminar su turno.
    
    def nextTurnAllowed
      return (@currentPlayer.nil? or @currentPlayer.validState)
    end
    
    
    # Asigna un enemigo a cada jugador de manera aleatorio y evitando que un
    # jugador sea enemigo de sí mismo.

    def setEnemies
      @players.each do |p|
        begin
          pos = Random.rand(@players.size)
        end while(pos == @players.index(p))
        
        enemy = @players.at(pos);
        p.setEnemy(enemy)
      end
    end
    
    
    # Desarrolla la lucha entre el jugador actual y el monstruo actual.
    # Devuelve un objeto de tipo CombatResult.
    
    public
    def developCombat
      combat_result=@currentPlayer.combat(@currentMonster)
      @dealer.giveMonsterBack(@currentMonster)
      
      # Código para convertir a sectario
      
      if(combat_result==CombatResult::LOSEANDCONVERT)
        p=CultistPlayer.new(@currentPlayer, @dealer.nextCultist)
        pos=@players.index(@currentPlayer)
        @players[pos]=p
        @currentPlayer=p
        
        puts "Ahora eres un jugador sectario.\n"
      end
      
      return combat_result
    end
    
    
    # Elimina los tesoros ocultos indicados de la lista de tesoros ocultos 
    # del jugador. Los tesoros descartados se devuelven al CardDealer.
    
    def discardVisibleTreasures(t)
      
      t.each do |x|
        @currentPlayer.discardVisibleTreasure(x)
        @dealer.giveTreasureBack(x)
      end
      
    end
    
    
    # Elimina los tesoros ocultos indicados de la lista de tesoros ocultos 
    # del jugador. Los tesoros descartados se devuelven al CardDealer.
    
    
    def discardHiddenTreasures(t)
      
      t.each do |x|
        @currentPlayer.discardHiddenTreasure(x)
        @dealer.giveTreasureBack(x)
        
      end
      
    end
    
    
    # Pasa todos los tesoros dados a visibles(equipados).
    
    def makeTreasuresVisible(t)
      
      t.each do |x|
        @currentPlayer.makeTreasureVisible(x)
      end
      
    end
    
    
    # Inicializa el juego pidiendo a CardDealer la inicialización de los mazos
    # de cartas, inicializa los jugadores y les asigna sus enemigos. Empieza
    # la ronda asignando el turno.
      
    def initGame(players)
      @dealer.initCards
      initPlayers(players)
      setEnemies
      nextTurn
    end
    
    
    # Verifica si el jugador actual está en condiciones de acabar de turno.
    # Si se puede cambiar de turno, se actualiza currentMonster y currentPlayer.
    # En caso de que sea la primera jugada o que el jugador haya muerto se 
    # le reparte tesoros para que pueda jugar.
    
    def nextTurn
      state_ok=nextTurnAllowed

      if(state_ok)
        @currentMonster=@dealer.nextMonster
        @currentPlayer=nextPlayer
        
        if(@currentPlayer.isDead)
          @currentPlayer.initTreasures
        end
      end
      
      return state_ok
    end
    
    
    # Devuelve true si el parámetro result es WINGAME
    
    def endOfGame(result)
      return CombatResult::WINGAME==result
    end
 
  end
end