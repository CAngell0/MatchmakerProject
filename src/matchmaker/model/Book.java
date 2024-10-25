package matchmaker.model;

public class Book {
   private String title;
   private String author;
   private String genre;
   private boolean hasPictures;
   private boolean isInEnglish;
   private int difficulty;

   public Book(){
      this.title = "";
      this.author = "";
      this.genre = "";
      this.hasPictures = false;
      this.isInEnglish = false;
      this.difficulty = 1;
   }
   public Book(String title, String author, String genre, boolean hasPictures, boolean isInEnglish, int difficulty){
      this.title = title;
      this.author = author;
      this.genre = genre;
      this.hasPictures = hasPictures;
      this.isInEnglish = isInEnglish;
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
   public boolean getIsInEnglish(){
      return this.isInEnglish;
   }
   public int getDifficulty(){
      return this.difficulty;
   }

   @Override
   public String toString() {
      String description = "This is the book: " + title + ", by: " + author;
      description += "\n\tThe genre of this book is: " + genre;
      description += "\n\tThe difficult leve for the book is: " + difficulty;
      description += "\n\tThis book " + ((hasPictures) ? "does" : "does not") + " have pictures";
      description += "\n\tThis book is written in " + ((isInEnglish) ? "English" : "Spanish");
      return description;
   }
}
