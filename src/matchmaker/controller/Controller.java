package matchmaker.controller;

import java.util.Scanner;
import java.util.ArrayList;

import matchmaker.model.Book;
import matchmaker.model.Student;
import matchmaker.utility.UserInput;

import matchmaker.controller.IOController;

public class Controller {
   private Scanner keyboardInput;
   private UserInput userInput;

   private ArrayList<Book> hasPicturesList;
   private ArrayList<Book> noPicturesList;
   private ArrayList<Book> isEnglishList;
   private ArrayList<Book> notEnglishList;

   public Controller() {
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
   }

   private Book makeRecommendation(Student student, ArrayList<Book> booksList){
      Book recommendedBook = null;
      ArrayList<Book> recommendations = new ArrayList<Book>();

      for (Book book : booksList){
         if (student.getIsEnglishSpeaker() == book.getIsInEnglish() && student.getWantsPictures() == book.getHasPictures()){
            
         } else continue;
      }

      return recommendedBook;
   }
}
