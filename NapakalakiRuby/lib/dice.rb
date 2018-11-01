# coding: utf-8

require 'singleton'

module Napakalaki
  
  class Dice
    
    include Singleton
    
    def nextNumber
      return (Random.rand(6) + 1).to_i
    end
    
  end
  
  # d=Dice.instance
  # puts "Numero: #{d.nextNumber}" 
  
end