package matchmaker.controller;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

import matchmaker.model.Book;
import matchmaker.model.Student;
import matchmaker.model.LexileIndex;
import matchmaker.model.LexileIndex.RangeValue;
import matchmaker.utility.UserInput;

import matchmaker.controller.IOController;

public class Controller {
   private Scanner keyboardInput;
   private LexileIndex lexileIndex;
   private UserInput userInput;

   private ArrayList<Book> hasPicturesList;
   private ArrayList<Book> noPicturesList;
   private ArrayList<Book> isEnglishList;
   private ArrayList<Book> notEnglishList;

   public Controller() {
      this.lexileIndex = new LexileIndex();

      this.hasPicturesList = new ArrayList<Book>();
      this.noPicturesList = new ArrayList<Book>();
      this.isEnglishList = new ArrayList<Book>();
      this.notEnglishList = new ArrayList<Book>();
   }

   public void start() {
      ArrayList<Student> students = IOController.readAllStudents();
      ArrayList<Book> books = IOController.readBooksFromFile("books_modified.csv");

      for (Book bookItem : books) {
         if (bookItem.getHasPictures()) this.hasPicturesList.add(bookItem);
         else this.noPicturesList.add(bookItem);

         if (bookItem.getIsInEnglish()) this.isEnglishList.add(bookItem);
         else this.notEnglishList.add(bookItem);
      }

      System.out.println("Recommendation for " + students.get(5).getName());
      makeRecommendation(students.get(5), this.hasPicturesList);
   }

   private Book makeRecommendation(Student student, ArrayList<Book> booksList){
      ArrayList<Book> recommendedBooks = new ArrayList<Book>();
      ArrayList<Integer> recommendedBookRatings = new ArrayList<Integer>();
      int highestRatingValue = 0;

      for (int index = 0; index < booksList.size(); index++){
         int rating = 0;
         Book book = booksList.get(index);
         RangeValue lexileRange = this.lexileIndex.getLexileByAge(student.getAge());
         if (student.getIsEnglishSpeaker() == book.getIsInEnglish()) rating++;
         if (student.getWantsPictures() == book.getHasPictures()) rating++;
         if (book.getLexile() > lexileRange.minimum && book.getLexile() < lexileRange.maximum) rating++;
         if (book.getGenre().contains(student.getPreferredGenre())) rating++;

         System.out.println((student.getIsEnglishSpeaker() == book.getIsInEnglish()) + ", " + (student.getWantsPictures() == book.getHasPictures()) + ", " + (book.getLexile() > lexileRange.minimum && book.getLexile() < lexileRange.maximum) + ", " + book.getGenre().contains(student.getPreferredGenre()));

         if (recommendedBooks.size() == 0){
            recommendedBooks.add(book);
            recommendedBookRatings.add(rating);
            continue;
         }

         // if (rating > recommendedBookRatings.get(recommendedBookRatings.size() - 1)){
         //    for (int ratingIndex = recommendedBookRatings.size() - 1; ratingIndex >= 0 ; ratingIndex--){
         //       if (rating <= recommendedBookRatings.get(ratingIndex)){
         //          recommendedBooks.add(ratingIndex, book);
         //          recommendedBookRatings.add(ratingIndex, rating);
         //          break;
         //       }
         //    }
         // } else if (rating == recommendedBookRatings.get(recommendedBookRatings.size() - 1) && !(recommendedBooks.size() >= 5)){
         //    recommendedBooks.add(book);
         //    recommendedBookRatings.add(rating);
         // }
      }

      // System.out.println(recommendedBooks.toString());
      // System.out.println(recommendedBookRatings.toString());

      return null;
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
