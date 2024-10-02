package matchmaker.controller.model;

public class Book {
   private String title;
   private String author;
   private String genre;
   private boolean hasPictures;
   private int difficulty;

   public Book(){
      this.title = "";
      this.author = "";
      this.genre = "";
      this.hasPictures = false;
      this.difficulty = 1;
   }
   public Book(String title, String author, String genre, boolean hasPictures, int difficulty){
      this.title = title;
      this.author = author;
      this.genre = genre;
      this.hasPictures = hasPictures;
      this.difficulty = difficulty;
   }

   public String getTitle(){
      return this.title;
   }
   public String getAuthor(){
      return this.author;
   }
   public String getGenre(){
      return this.genre;
   }
   public boolean getHasPictures(){
      return this.hasPictures;
   }
   public int getDifficulty(){
      return this.difficulty;
   }

   @Override
   public String toString() {
      String description = "This is the book: " + title + ", by: " + author;
      description += "\nThe genre of this book is: " + genre;
      description += "\n The difficult leve for the book is: " + difficulty;
      description += "\n This book " + ((hasPictures) ? "does" : "does not") + " have pictures";
      return description;
   }
}
