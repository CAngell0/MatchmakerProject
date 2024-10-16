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
      Book recommendedBook = null;
      ArrayList<Book> recommendList = new ArrayList<Book>();

      for (int index = 0; index < bookList.size(); index++){
         Book currentBook = bookList.get(index);
         if (currentBook.getHasPictures() == currentStudent.getWantsPictures()){
            recommendList.add(currentBook);
         }
      }

      for (int index = recommendList.size() - 1; index >= 0; index--){
         Book currentBook = recommendList.get(index);
         if (currentBook.getIsInEnglish() != currentStudent.getIsEnglishSpeaker()){
            recommendList.remove(index);
         }
      }

      for (int index = recommendList.size() - 1; index >= 0; index--){
         Book currentBook = recommendList.get(index);
         String bookGenre = currentBook.getGenre();

         if (!bookGenre.contains(currentStudent.getPreferredGenre())){
            recommendList.remove(index);
         }
      }

      for (int index = recommendList.size() - 1; index >= 0; index--){
         Book currentBook = recommendList.get(index);
         int readingLevel = currentBook.getDifficulty();
         int range = readingLevel - (currentStudent.getAge() * 100);
         range = Math.abs(range);

         if (range <= 100){
            recommendList.remove(index);
         }
      }

      if (recommendList.size() > 0){
         recommendedBook = recommendList.get(0);
      } else {
         int randomIndex = (int) Math.random() * bookList.size();
         recommendedBook = recommendList.get(randomIndex);
      }

      return recommendedBook;
   }
}
