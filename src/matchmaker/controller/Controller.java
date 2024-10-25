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

   private String book1;
   private String book2;
   private String book3;
   private String book4;

   public Controller(){
      // this.keyboardInput = new Scanner(System.in);
      // this.userInput = new UserInput(keyboardInput);
   }

   public void start(){
      // userInput.askQuestions();

      // keyboardInput.close();

      // ArrayList<Book> books = IOController.readBooksFromFile("books_modified.csv");
      // System.out.println("The list has this many items: " + books.size());

     ArrayList<Student> students = IOController.readStudentsFromFile("group_one.csv");
     System.out.println(students.size());
   }

   private ArrayList<String> generateRecommendation(ArrayList<Student> studentList, ArrayList<Book> bookList){
      ArrayList<String> studentRecommendations = new ArrayList<String>();

      for (int index = 0; index < studentList.size(); index++){
         Student currentStudent  = studentList.get(index);
         String currentRecommendation = "Student #" + index + " " + currentStudent.getName();
         currentRecommendation += " is recommended to read: ";

         Book recommendedBook = makeRecommendation(currentStudent, bookList);
         currentRecommendation += recommendedBook.getTitle();

         studentRecommendations.add(currentRecommendation);
      }

      return studentRecommendations;
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
