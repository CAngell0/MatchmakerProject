package matchmaker.controller;

import java.util.Scanner;
import java.util.ArrayList;
import matchmaker.model.Book;
import matchmaker.model.Student;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class IOController {
   public static ArrayList<Book> readBooksFromFile(String path){
      ArrayList<Book> books = new ArrayList<Book>();

      try (Scanner fileScanner = new Scanner(new File(path))){
         //Gets the first header line of the CSV file. This is to increment the scanner and skip this line
         String bookLine = fileScanner.nextLine();
         //Gets each next line along with the book characteristics. Turns it into book object and adds to the books ArrayList
         while (fileScanner.hasNextLine()){
            bookLine = fileScanner.nextLine();
            String[] lineContents = bookLine.split(",");

            books.add(new Book(
               lineContents[0], //Title
               lineContents[1], //Author
               lineContents[2], //Genre
               Boolean.parseBoolean(lineContents[5]), //Has Pictures
               (lineContents[3].equalsIgnoreCase("english")), //Is In English
               Integer.parseInt(lineContents[4]) //Difficulty Level
            ));
         }
         
      } catch (FileNotFoundException error){
         System.out.println("Error reading book file.");
         System.out.println(error.getMessage());
      }

      return books;
   }

   public static ArrayList<Student> readStudentsFromFile(String path){
      ArrayList<Student> students = new ArrayList<Student>();

      try (Scanner fileScanner = new Scanner(new File(path))){
         String studentLine = fileScanner.nextLine();
         while (fileScanner.hasNextLine()){
            studentLine = fileScanner.nextLine();
            String[] lineContents = studentLine.split(",");

            students.add(new Student(
               lineContents[0], //Name
               (lineContents[1].equals("English")), //isEnglishSpeaker
               Integer.parseInt(lineContents[2]), //age
               lineContents[3], //preferredGenre
               Boolean.parseBoolean(lineContents[4]) //wantsPictures
            ));
         }
      } catch (IOException error){
         System.out.println("Error reading student file.");
         System.out.println(error.getMessage());
      }

      return students;
   }

   public static ArrayList<Student> readAllStudents() {
      ArrayList<Student> allStudents = new ArrayList<Student>();
      ArrayList<Student> groupOne = IOController.readStudentsFromFile("group_one.csv");
      ArrayList<Student> groupTwo = IOController.readStudentsFromFile("group_two.csv");
      ArrayList<Student> groupThree = IOController.readStudentsFromFile("group_three.csv");
      allStudents.addAll(groupOne);
      allStudents.addAll(groupTwo);
      allStudents.addAll(groupThree);
      return allStudents;
   }
}
