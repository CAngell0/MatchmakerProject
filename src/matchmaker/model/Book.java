package matchmaker.model;

public class Book {
   private String title;
   private String author;
   private String genre;
   private boolean isInEnglish;
   private int lexile;
   private boolean hasPictures;

   /**Creates a book with defauolt, empty data */
   public Book(){
      this.title = "";
      this.author = "";
      this.genre = "";
      this.hasPictures = false;
      this.isInEnglish = false;
      this.lexile = 1;
   }
   /**
    * Creates a book based on manuelly inputted data
    * @param title The title of the book
    * @param author The author of the book
    * @param genre The gebre or the book
    * @param isInEnglish Whether the book is in English
    * @param lexile The lexile level of the book
    * @param hasPictures Whether the book has pictures
    */
   public Book(String title, String author, String genre, boolean isInEnglish,int lexile, boolean hasPictures){
      this.title = title;
      this.author = author;
      this.genre = genre;
      this.hasPictures = hasPictures;
      this.isInEnglish = isInEnglish;
      this.lexile = lexile;
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
   public int getLexile(){
      return this.lexile;
   }

   @Override
   public String toString() {
      String description = "This is the book: " + title + ", by: " + author;
      description += "\n\tThe genre of this book is: " + genre;
      description += "\n\tThe difficult leve for the book is: " + lexile;
      description += "\n\tThis book " + ((hasPictures) ? "does" : "does not") + " have pictures";
      description += "\n\tThis book is written in " + ((isInEnglish) ? "English" : "Spanish");
      return description;
   }
}
