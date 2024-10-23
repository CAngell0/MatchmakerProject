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
               (lineContents[3] == "English"), //Is In English
               Integer.parseInt(lineContents[4]) //Difficulty Level
            ));
         }
         
      } catch (FileNotFoundException error){
         System.out.println("Error reading book file.");
         System.out.println(error.getMessage());
         System.err.println(error.getStackTrace());
      }

      return books;
   }
}
