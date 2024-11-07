package matchmaker.controller;

import java.util.Scanner;
import java.text.MessageFormat;
import java.util.ArrayList;

import matchmaker.model.Book;
import matchmaker.model.Student;
import matchmaker.utility.LexileIndex;
import matchmaker.utility.UserInput;
import matchmaker.utility.LexileIndex.RangeValue;
import matchmaker.controller.IOController;

public class Controller {
   private LexileIndex lexileIndex;
   private UserInput userInput;

   public Controller() {
      this.lexileIndex = new LexileIndex();
   }

   public void start() {
      ArrayList<Student> students = IOController.readAllStudents();
      ArrayList<Book> books = IOController.readBooksFromFile("books_modified.csv");

      for (Student currentStudent : students){
         Book recommendation = makeRecommendation(currentStudent, books);

         System.out.println(MessageFormat.format("""
            Student '{0}' is recommended "{1}"
               By: {2}
         """, currentStudent.getName(), recommendation.getTitle(), recommendation.getAuthor()));
      }
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
         Book currentBook = bookList.get(index);

         if (currentBook.getIsInEnglish() != currentStudent.getIsEnglishSpeaker()){
            recommendList.remove(index);
         }
      }

      for (int index = recommendList.size() - 1; index >= 0; index--){
         Book currentBook = bookList.get(index);

         if (!currentBook.getGenre().contains(currentStudent.getPreferredGenre())){
            recommendList.remove(index);
         }
      }

      for (int index = recommendList.size() - 1; index >= 0; index--){
         Book currentBook = bookList.get(index);
         RangeValue studentLexileRange = lexileIndex.getLexileByAge(currentStudent.getAge());
         int bookLexile = currentBook.getLexile();
         
         if (!(bookLexile >= studentLexileRange.minimum && bookLexile <= studentLexileRange.maximum)){
            recommendList.remove(index);
         }
      }

      if (recommendList.size() > 0){
         recommendedBook = recommendList.get(0);
      } else {
         int randomIndex = (int) (Math.random() * bookList.size());
         recommendedBook = bookList.get(randomIndex);
      }

      return recommendedBook;
   }


   private void manualRecommendation(){
      String input = "";

      while (!input.equalsIgnoreCase("quit")){
         userInput.askQuestions();

         System.out.println("Type quit to exit");
         input = userInput.getScanner().nextLine();
      }
   }

   private void testFiles(){
      System.out.println("Checking that books are being read correctly...");
      ArrayList<Book> books = IOController.readBooksFromFile("books_modified.csv");
      System.out.println("Loadad: " + books.size());

      System.out.println("Checking that students are being read correctly...");
      ArrayList<Student> students = IOController.readAllStudents();
      System.out.println("Loadad: " + students.size());
   }
}
