package matchmaker.controller.model;

public class Book {
   private String title;
   private String author;
   private String genre;
   private boolean hasPictures;
   private int difficulty;

   public Book(){
      this.title = "None";
      this.author = "None";
      this.genre = "None";
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
}
