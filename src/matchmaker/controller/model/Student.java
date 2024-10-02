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
}
