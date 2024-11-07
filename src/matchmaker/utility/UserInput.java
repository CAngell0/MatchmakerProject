package matchmaker.utility;

import java.util.Scanner;

public class UserInput {
   private Scanner keyboardInput;
   private String bookType;
   private String genre;
   private String language;
   private boolean hasPictures;
   private int difficultyLevel;

   /**
    * A wrapper that has functions for user input
    * @param scanner The scanner to use for input
    */
   public UserInput(Scanner scanner){
      this.keyboardInput = scanner;
   }

   /**Asks questions for what kind of book the user wants and puts them into the object's properties */
   public void askQuestions(){
      System.out.println("Do you want a fiction or non-fiction book?");
      bookType = keyboardInput.nextLine();

      System.out.println("What genre of book do you want?");
      genre = keyboardInput.nextLine();

      System.out.println("What language do you want the book in?");
      language = keyboardInput.nextLine();

      System.out.println("Do you want a picture book? true or false");
      hasPictures = keyboardInput.nextBoolean();
      keyboardInput.nextLine();

      System.out.println("What difficult do you want the book to be? 1-5");
      difficultyLevel = keyboardInput.nextInt();
      keyboardInput.nextLine();
   }

   public String getBookType(){
      return bookType;
   }
   public String getGenre(){
      return genre;
   }
   public String getLanguage(){
      return language;
   }
   public boolean getHasPictures(){
      return hasPictures;
   }
   public int getDifficultyLevel(){
      return difficultyLevel;
   }
   public Scanner getScanner(){
      return keyboardInput;
   }
}
