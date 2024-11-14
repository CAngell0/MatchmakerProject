package matchmaker.view;

import javax.swing.JOptionPane;

public class Popup {
   /**
    * Displays the supplied message as a popup.
    * @param message Message to display.
    */
   public void displayMessage(String message){
      JOptionPane.showMessageDialog(null, message);
   }
   
   /**
    * Asks a question and returns its input through a popup.
    * @param question The question you are asking.
    * @return The string the user inputs as their answer.
    */
   public String askQuestion(String question){
      String input = "";

      input = JOptionPane.showInputDialog(null, question);
      if (input == null) input = "";
      
      return input;
   }
}

