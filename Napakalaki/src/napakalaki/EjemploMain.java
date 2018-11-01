
package napakalaki;

//import Test.GameTester;

import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import Test.GameTester;
import java.util.ArrayList;


public class EjemploMain {

    public static void main(String[] args) {
      
      ArrayList<String> names = new ArrayList();
      Napakalaki game = Napakalaki.getInstance();
      NapakalakiView napakalakiView = new NapakalakiView();
      
      Dice.createInstance(napakalakiView);
      
      PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
      
      names = namesCapture.getNames();
      game.initGame(names);
      napakalakiView.setNapakalakiModel(game);
      napakalakiView.setVisible(true);
      //GameTester test = GameTester.getInstance();
      
      // Poner el numero de jugadores con el que se quiera probar
      //test.play(game, 2); 
              
    }
}
