# coding: utf-8

require 'singleton'
require_relative 'monster.rb'
require_relative 'treasure.rb'
require_relative 'cultist.rb'

module Napakalaki
  
  class CardDealer
  
   include Singleton
   
   # Inicializador
    
    #attr_reader :unusedMonsters
    
   def initialize
     @unusedMonsters=Array.new
     @usedMonsters=Array.new
     @unusedTreasures=Array.new
     @usedTreasures=Array.new
     @unusedCultists=Array.new
   end
   
   # Inicializa el mazo de cartas de tesoros.
   
   private
   def initTreasuresCardDeck
    
     puts "Cargando tesoros.\n"
     
     # Tesoro: ¡Sí, mi amo!
        
     @unusedTreasures << Treasure.new("!Sí, mi amo!", 4, TreasureKind::HELMET)
        
     # Tesoro: Botas de investigación
        
     @unusedTreasures << Treasure.new("Botas de investigación", 3, TreasureKind::SHOES)
        
     # Tesoro: Capucha de Cthulhu
        
     @unusedTreasures << Treasure.new("Capucha de Cthulhu", 3, TreasureKind::HELMET)
        
     # Tesoro: A prueba de babas
        
     @unusedTreasures << Treasure.new("A prueba de babas", 2, TreasureKind::ARMOR)
        
     # Tesoro: Botas de lluvia ácida
        
     @unusedTreasures << Treasure.new("Botas de lluvia ácida", 1, TreasureKind::BOTHHANDS)
        
     # Tesoro: Cascco minero
        
     @unusedTreasures << Treasure.new("Casco minero", 2, TreasureKind::HELMET)
        
     # Tesoro: Ametralladora Thompson
        
     @unusedTreasures << Treasure.new("Ametralladora Thompson", 4, TreasureKind::BOTHHANDS)
        
     # Tesoro: Camiseta de la UGR
        
     @unusedTreasures << Treasure.new("Camiseta de la UGR", 1, TreasureKind::ARMOR)
        
     # Tesoro: Clavo de raíl ferroviario
        
     @unusedTreasures << Treasure.new("Clavo de raíl ferroviario", 3, TreasureKind::ONEHAND)
        
     # Tesoro: Cuchillo de sushi arcano
        
     @unusedTreasures << Treasure.new("Cuchillo de sushi arcano", 2, TreasureKind::ONEHAND)
        
     # Tesoro: Fez alópado
        
     @unusedTreasures << Treasure.new("Fez alópado", 3, TreasureKind::HELMET)
        
     # Tesoro: Hacha prehistórica
        
     @unusedTreasures << Treasure.new("Hacha prehistórica", 2, TreasureKind::ONEHAND)
        
     # Tesoro: El aparato del Pr. Tesla
        
     @unusedTreasures << Treasure.new("El aparato del Pr. Tesla", 4, TreasureKind::ARMOR)
        
     # Tesoro: Gaita
        
     @unusedTreasures << Treasure.new("Gaita", 4, TreasureKind::BOTHHANDS)
        
     # Tesoro: Insecticida
        
     @unusedTreasures << Treasure.new("Insecticida", 2, TreasureKind::ONEHAND)
        
     # Tesoro: Escopeta de 3 cañones
        
     @unusedTreasures << Treasure.new("Escopeta de 3 cañones", 4, TreasureKind::BOTHHANDS)
        
     # Tesoro: Garabato místico
        
     @unusedTreasures << Treasure.new("Garabato místico", 2, TreasureKind::ONEHAND)
        
     # Tesoro: La rebeca metálica
        
     @unusedTreasures << Treasure.new("La rebeca metálica", 2, TreasureKind::ARMOR)
        
     # Tesoro: Lanzallamas
        
     @unusedTreasures << Treasure.new("Lanzallamas", 4, TreasureKind::BOTHHANDS)
        
     # Tesoro: Necro-comicón
        
     @unusedTreasures << Treasure.new("Necro-comicón", 1, TreasureKind::ONEHAND)
        
     # Tesoro: Necronomicón
        
     @unusedTreasures << Treasure.new("Necronomicón", 5, TreasureKind::BOTHHANDS)
        
     # Tesoro: Linterna a 2 manos
        
     @unusedTreasures << Treasure.new("Linterna a 2 manos", 3, TreasureKind::BOTHHANDS)
        
     # Tesoro: Necro-gnomicón
        
     @unusedTreasures << Treasure.new("Necro-gnomicón", 2, TreasureKind::ONEHAND)
        
     # Tesoro: Necrotelecom
        
     @unusedTreasures << Treasure.new("Necrotelecom", 2, TreasureKind::HELMET)
        
     # Tesoro: Mazo de los antiguos
        
     @unusedTreasures << Treasure.new("Mazo de los antiguos", 3, TreasureKind::ONEHAND)
        
     # Tesoro: Necro-playboycón
        
     @unusedTreasures << Treasure.new("Necro-playboycón", 3, TreasureKind::ONEHAND)
        
     # Tesoro: Porra preternatural
        
     @unusedTreasures << Treasure.new("Porra preternatural", 2, TreasureKind::ONEHAND)
        
     # Tesoro: Shogulador
        
     @unusedTreasures << Treasure.new("Shogulador", 1, TreasureKind::BOTHHANDS)
        
     # Tesoro: Varita de atizamiento
        
     @unusedTreasures << Treasure.new("Varita de atizamiento", 3, TreasureKind::ONEHAND)
        
     # Tesoro: Tentáculo de pega
        
     @unusedTreasures << Treasure.new("Tentáculo de pega", 2, TreasureKind::HELMET)
        
     # Tesoro: Zapato deja-amigos
        
     @unusedTreasures << Treasure.new("Zapato deja-amigos", 1, TreasureKind::SHOES)
   
   end
      
   # Inicializa el mazo de cartas de monstruos.
   
   private
   def initMonstersCardDeck
     
     n=Array.new 
     
      puts "Cargando monstruos.\n"
  
      # Monstruo: Byakhees de bonanza
  
      badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes tu amadura
        visible y otra oculta.", 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("Byakhees de bonanza", 8, prize, badConsequence)
  
      # Monstruo: Chibithulhu
  
      badConsequence = BadConsequence.newLevelSpecificTreasures("Embobados con el 
        lindo primigenio te descartas de tu casco visible.", 0 , [TreasureKind::HELMET], n)
      prize = Prize.new(1, 1);
      @unusedMonsters << (Monster.new("Chibithulhu", 2, prize, badConsequence))
  
      # Monstruo: El sopor de Dunwich
  
      badConsequence = BadConsequence.newLevelSpecificTreasures("El primordial bostezo.
        Pierdes el calzado visible.", 0, [TreasureKind::SHOES], n)
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("El sopor de Dunwich", 2, prize, badConsequence)
  
      # Monstruo: Ángeles de la noche ibicenca
  
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te atrapan para 
        llevarte de fiesta y te dejan caer en mitad del vuelo. Pierdes una mano 
        visible y otra oculta.", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
      prize = Prize.new(4, 1)
      @unusedMonsters << (Monster.new("Angeles de la noche ibicenca", 14, prize, badConsequence))
  
      # Monstruo: El gorrón del umbral
  
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus
        tesoros visibles.", 0, 10, 0)
      prize = Prize.new(3, 1)
      @unusedMonsters << Monster.new("El gorron del umbral", 10, prize, badConsequence)
  
      # Monstruo: H.P Munchcraft
  
      badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura
        visible.", 0, [TreasureKind::ARMOR], n)
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("H.P Munchcraft", 6, prize, badConsequence)
  
      # Monstruo: Bichgooth
  
      badConsequence = BadConsequence.newLevelSpecificTreasures("Sientes bichos
        bajo la ropa. Descarta tu armadura visible.", 0, [TreasureKind::ARMOR], n)
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("Bichgooth", 2, prize, badConsequence)
  
      # Monstruo: El rey de rosa
  
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles 
        y 3 tesoros visibles.", 5, 3, 0)
      prize = Prize.new(4, 2)
      @unusedMonsters << Monster.new("El rey de rosa", 13, prize, badConsequence)
  
      # Monstruo: La que redacta en las tinieblas
  
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones 
        y pierdes 2 niveles.", 2, 0, 0)
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("La que redacta en las tinieblas", 2, prize, badConsequence)
  
      # Monstruo: Los hondos
  
      badConsequence = BadConsequence.newDeath("Estos monstruos resultan bastante 
        superficiales y te aburren mortalmente. Estas muerto.")
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("Los hondos", 8, prize, badConsequence)
  
      # Monstruo: Semillas Cthulhu
  
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles 
       y 2 tesoros ocultos.", 2, 0, 2)
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("Semillas Cthulhu", 4, prize, badConsequence)
  
      # Monstruo: Dameargo
  
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te intentas
        escaquear. Pierdes una mano visible.", 0, [TreasureKind::ONEHAND], n)
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("Dameargo", 1, prize, badConsequence)
  
      # Monstruo: Pollipólipo volante
  
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito.
        Pierdes 3 niveles", 3, 0, 0)
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("Pollipolipo volante", 3, prize, badConsequence)
  
      # Monstruo: Yskhtihyssg-Goth
  
      badConsequence = BadConsequence.newDeath("No le hace gracia que pronuncien mal
        su nombre. Estas muerto.")
      prize = Prize.new(3, 1)
      @unusedMonsters << Monster.new("Yskhtihyssg-Goth", 12, prize, badConsequence)
  
      # Monstruo: Familia feliz
  
      badConsequence = BadConsequence.newDeath("La familia te atrapa. Estas muerto.")
      prize = Prize.new(4, 1)
      @unusedMonsters << Monster.new("Familia feliz", 1, prize, badConsequence)
  
      # Monstruo: Roboggoth
  
      badConsequence = BadConsequence.newLevelSpecificTreasures("La quinta directiva
        primaria te obliga a perder 2 niveles y un tesoro '2 manos' visible.", 2, 
        [TreasureKind::BOTHHANDS], n)
      prize = Prize.new(2, 1)
      @unusedMonsters << Monster.new("Roboggoth", 8, prize, badConsequence)
  
      # Monstruo: El espía
  
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te asusta por la 
        noche. Pierdes un casco visible.", 0, [TreasureKind::HELMET], n)
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("El espia", 5, prize, badConsequence)
  
      # Monstruo: El Lenguas
  
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Mendudo susto te 
        llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0)
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("El lenguas", 20, prize, badConsequence)
  
      # Monstruo: Bicéfalo
      m=Array.new;
      m << TreasureKind::ONEHAND
      m << TreasureKind::ONEHAND
      m << TreasureKind::BOTHHANDS
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te faltan manos 
        para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",
        3, m, n)
      prize = Prize.new(1, 1)
      @unusedMonsters << Monster.new("Bicefalo", 20, prize, badConsequence)
     
     
      # MONSTRUOS SECTARIOS
      
      #######################################################
      
      ########## FALTA MONSTRUOS SECTARIOS  #################
      
      #######################################################
   end
   
   
   # Inicializa el mazo de sectarios
   
   def initCultistCardDeck
     i=0
     while(i<4)
       @unusedCultists.push(Cultist.new("Sectario", 1))
       i += 1
     end
     i=0
     while(i<2)
       @unusedCultists.push(Cultist.new("Sectario", 2))
       i += 1
     end
   end
   
   # Baraja el mazo de cartas de tesoros.
   
   private
   def shuffleTreasures
     @unusedTreasures.shuffle!
   end
   
   
   # Baraja el mazo de cartas de tesoros.
   
   def shuffleMonsters
     @unusedMonsters.shuffle!
   end
   
   # Baraja el mazo de cartas de sectarios.
   
   def shuffleCultists
     @unusedCultists.shuffle!
   end
   
   
   # Devuelve el siguiente tesoro que hay en el mazo de tesoros (unusedTreasures)
   # y lo elimina de él. En caso de estar vacío, reinicia el mazo barajando el
   # mazo de tesoros usados.
   public
   def nextTreasure
      if(@unusedTreasures.empty?)
        @unusedTreasures = Array.new(@usedTreasures)
        @usedTreasures.clear
        shuffleTreasures
      end
     
      return @unusedTreasures.delete_at(0)
   end
   
   
   # Devuelve el siguiente monstruo que hay en el mazo de monstruos (unusedMonsters)
   # y lo elimina de él. En caso de estar vacío, reinicia el mazo barajando el
   # mazo de monstruos usados.
   
   def nextMonster
      if(@unusedMonsters.empty?)
        @unusedMonsters = Array.new(@usedMonsters)
        @usedMonsters.clear
        shuffleMonsters
      end
      
      return @unusedMonsters.delete_at(0)
   end
   
   
   # Devuelve la siguiente carta dek tipo sectario
   
   def nextCultist
     @unusedCultists.pop
   end
   
   # Añade tesoro t al mazo de usados.
   
   def giveTreasureBack(t)
     @usedTreasures.push(t)
   end
   
   
   # Añade monstruo m al mazo de usados.
   
   def giveMonsterBack(m)
    @usedMonsters.push(m)
   end
   
   
   # Inicializa los mazos de cartas.
   
   def initCards
     initTreasuresCardDeck
     initMonstersCardDeck
     initCultistCardDeck
     shuffleTreasures
     shuffleMonsters
     shuffleCultists
   end
   
  end

end