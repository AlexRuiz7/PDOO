# coding: utf-8

require_relative 'card_dealer.rb'

module Napakalaki
  
#=begin
  
  dealer=CardDealer.instance
  dealer.initCards
  monsters=Array.new(dealer.unusedMonsters)
  puts dealer.nextMonster.name
  puts "###################"
  # Ver Monstruos
  
  monsters.each do |monster|
    puts monster.name;
  end
  
  puts "\nMonstruos con nivel de combate mayor que 10.\n"
  
  monsters.each do |monster|
    if monster.combatLevel > 10
      puts monster.name
    end
  end
  
  puts "\nMonstruos con los que pierdes nivel.\n"
  
  monsters.each do |monster|
    if monster.bc.levels < 1 #&& monster.bc.nVisibleTreasures == 0 && monster.bc.nHiddenTreasures == 0
      puts monster.name
    end
  end
  
  puts "\nMonstruos con los que subes mas de 1 nivel.\n"
  
  monsters.each do |monster|
    if monster.prize.levels > 1
      puts monster.name
    end
  end
  
  puts "\nMonstruos con los que pierdes tesoros.\n"
  
  monsters.each do |monster|
    if monster.bc.nVisibleTreasures != 0 && monster.bc.nHiddenTreasures != 0
      puts monster.name
    end
  end
  
#=end

end