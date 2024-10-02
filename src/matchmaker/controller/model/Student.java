package matchmaker.controller.model;

public class Student {
   private String name;
   private String preferredGenre;
   private boolean isEnglishSpeaker;
   private int age;

   public Student(){
      this.name = "";
      this.preferredGenre = "";
      this.isEnglishSpeaker = false;
      this.age = 0;
   }
   public Student(String name, String preferredGenre, boolean isEnglishSpeaker, int age){
      this.name = name;
      this.preferredGenre = preferredGenre;
      this.isEnglishSpeaker = isEnglishSpeaker;
      this.age = age;
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

   @Override
   public String toString() {
      String description = "This is a student named \"" + name + "\" and they are " + age + " years old";
      description += "\nThis student prefers the " + preferredGenre + " genre";
      description += "\nThis student is" + ((isEnglishSpeaker) ? "" : " not") + " an English speaker";
      return description;
   }
}
