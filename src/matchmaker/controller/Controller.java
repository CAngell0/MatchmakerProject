package matchmaker.controller;

import java.util.Scanner;
import java.util.ArrayList;

import matchmaker.model.Book;
import matchmaker.model.Student;
import matchmaker.utility.UserInput;

public class Controller {
   private Scanner keyboardInput;
   private UserInput userInput;

   private String book1;
   private String book2;
   private String book3;
   private String book4;

   public Controller(){
      this.keyboardInput = new Scanner(System.in);
      this.userInput = new UserInput(keyboardInput);
      this.book1 = "Curious George";
      this.book2 = "365 Cuentos y Rimas Para la Hora de Dormir";
      this.book3 = "My First I Can Draw";
      this.book4 = "Richard Scarry's Cars";
   }

   public void start(){
      userInput.askQuestions();

      keyboardInput.close();
   }

   private Book makeRecommendation(Student currentStudent, ArrayList<Book> bookList){
      ArrayList<Book> recommendList = new ArrayList<Book>();

      return null;
   }
}
