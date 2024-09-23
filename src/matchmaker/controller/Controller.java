package matchmaker.controller;

import java.util.Scanner;

public class Controller {
   private Scanner keyboardInput;

   private String book1;
   private String book2;
   private String book3;
   private String book4;

   public Controller(){
      this.keyboardInput = new Scanner(System.in);
      this.book1 = "Curious George";
      this.book2 = "365 Cuentos y Rimas Para la Hora de Dormir";
      this.book3 = "My First I Can Draw";
      this.book4 = "Richard Scarry's Cars";
   }

   public void start(){
      makeRecommendation();
      askQuestions();
      keyboardInput.close();
   }

   private void makeRecommendation(){
      System.out.println("Do you want a fiction or non-fiction book?");
      String bookType = keyboardInput.nextLine();

      System.out.println("Do you want a picture book? true or false");
      boolean hasPictures = keyboardInput.nextBoolean();
      keyboardInput.nextLine();

      System.out.println("What genre of book do you want?");
      String genre = keyboardInput.nextLine();

      System.out.println("What difficult do you want the book to be? 1-5");
      int difficulty = keyboardInput.nextInt();
      keyboardInput.nextLine();

      System.out.println("What language do you want the book in?");
      String language = keyboardInput.nextLine();

      
      String recommendedBook = "";

      if (language.equalsIgnoreCase("spanish") || !hasPictures){
         recommendedBook = book2;
      } else {
         if (bookType.equalsIgnoreCase("non-fiction")){
            recommendedBook = book4;
         } else {
            if (hasPictures){
               if (difficulty < 3){
                  recommendedBook = book3;
               } else {
                  recommendedBook = book1;
               }
            } else {
               recommendedBook = book4;
            }
         }
      }

      System.out.println(recommendedBook);
   }
   
   private void askQuestions(){
      System.out.println("Do you want a fiction or non-fiction book?");
      String bookType = keyboardInput.nextLine();

      System.out.println("Do you want a picture book? true or false");
      boolean hasPictures = keyboardInput.nextBoolean();
      keyboardInput.nextLine();

      System.out.println("What genre of book do you want?");
      String genre = keyboardInput.nextLine();

      System.out.println("What difficult do you want the book to be? 1-5");
      int difficulty = keyboardInput.nextInt();
      keyboardInput.nextLine();

      System.out.println("What language do you want the book in?");
      String language = keyboardInput.nextLine();

      String recommendedBook = makeRecommendation(bookType, genre, language, hasPictures, difficulty);

      System.out.println(recommendedBook);
   }

   private String makeRecommendation(String book, String genre, String language, boolean hasPictures, int difficultyLevel){
      String recommendedBook = "";

      if (language.equalsIgnoreCase("spanish") || !hasPictures){
         recommendedBook = book2;
      } else {
         if (book.equalsIgnoreCase("non-fiction")){
            recommendedBook = book4;
         } else {
            if (hasPictures){
               if (difficultyLevel < 3){
                  recommendedBook = book3;
               } else {
                  recommendedBook = book1;
               }
            } else {
               recommendedBook = book4;
            }
         }
      }

      return recommendedBook;
   }

}
