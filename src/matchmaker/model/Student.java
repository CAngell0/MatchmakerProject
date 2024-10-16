package matchmaker.model;

public class Student {
   private String name;
   private String preferredGenre;
   private boolean isEnglishSpeaker;
   private int age;
   private boolean wantsPictures;

   public Student(){
      this.name = "";
      this.preferredGenre = "";
      this.isEnglishSpeaker = false;
      this.age = 0;
      this.wantsPictures = false;
   }
   public Student(String name, String preferredGenre, boolean isEnglishSpeaker, int age, boolean wantsPictures){
      this.name = name;
      this.preferredGenre = preferredGenre;
      this.isEnglishSpeaker = isEnglishSpeaker;
      this.age = age;
      this.wantsPictures = wantsPictures;
   }

   public String getName(){
      return this.name;
   }
   public String getPreferredGenre(){
      return this.preferredGenre;
   }
   public boolean getIsEnglishSpeaker(){
      return this.isEnglishSpeaker;
   }
   public int getAge(){
      return this.age;
   }
   public boolean getWantsPictures(){
      return this.wantsPictures;
   }

   @Override
   public String toString() {
      String description = "This is a student named \"" + name + "\" and they are " + age + " years old";
      description += "\nThis student prefers the " + preferredGenre + " genre";
      description += "\nThis student is" + ((isEnglishSpeaker) ? "" : " not") + " an English speaker";
      description += "\nThis student " + ((wantsPictures) ? "wants" : "doesn't want") + " a picture book";
      return description;
   }
}
