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
      makeRecommendation(students.get(5), books);
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

         if (recommendedBooks.size() == 0){
            recommendedBooks.add(book);
            recommendedBookRatings.add(rating);
            continue;
         }

         if (rating >= recommendedBookRatings.getLast() || recommendedBookRatings.size() < 5){
            recommendedBooks.add(book);
            recommendedBookRatings.add(rating);
         }
      }

      return null;
   }
}
