package matchmaker.model;

import java.util.HashMap;

public class LexileIndex {
   public static class RangeValue {
      public int minimum;
      public int maximum;
      public int range;

      public RangeValue(int minimum, int maximum){
         this.minimum = minimum;
         this.maximum = maximum;
         this.range = maximum - minimum;
      }

      @Override
      public String toString() {
         return "This range goes from " + this.minimum + " to " + this.maximum + ". With a range of " + this.range + ".";
      }
   }

   private HashMap<Integer, RangeValue> gradeLexileKey;
   private HashMap<Integer, RangeValue> ageGradeKey;

   public LexileIndex(){
      this.ageGradeKey = new HashMap<Integer, RangeValue>();
      this.gradeLexileKey = new HashMap<Integer, RangeValue>();

      this.ageGradeKey.put(5, new RangeValue(0, 0));
      this.ageGradeKey.put(6, new RangeValue(0, 1));
      this.ageGradeKey.put(7, new RangeValue(1, 2));
      this.ageGradeKey.put(8, new RangeValue(2, 3));
      this.ageGradeKey.put(9, new RangeValue(3, 4));
      this.ageGradeKey.put(10, new RangeValue(4, 5));
      this.ageGradeKey.put(11, new RangeValue(5, 6));
      this.ageGradeKey.put(12, new RangeValue(6, 7));
      this.ageGradeKey.put(13, new RangeValue(7, 8));
      this.ageGradeKey.put(14, new RangeValue(8, 9));

      this.gradeLexileKey.put(0, new RangeValue(0, 100));
      this.gradeLexileKey.put(1, new RangeValue(0, 100));
      this.gradeLexileKey.put(2, new RangeValue(100, 300));
      this.gradeLexileKey.put(3, new RangeValue(250, 500));
      this.gradeLexileKey.put(4, new RangeValue(350, 600));
      this.gradeLexileKey.put(5, new RangeValue(450, 700));
      this.gradeLexileKey.put(6, new RangeValue(500, 800));
      this.gradeLexileKey.put(7, new RangeValue(550, 850));
      this.gradeLexileKey.put(8, new RangeValue(600, 900));
      this.gradeLexileKey.put(9, new RangeValue(650, 1000));
   }

   public RangeValue getLexileByGrade(int grade){
      return this.gradeLexileKey.get(grade);
   }

   public RangeValue getLexileByAge(int age){
      RangeValue gradeRange = this.ageGradeKey.get(age);
      RangeValue lowerLexileRange = this.gradeLexileKey.get(gradeRange.minimum);
      RangeValue upperLexileRange = this.gradeLexileKey.get(gradeRange.maximum);
      return new RangeValue(lowerLexileRange.minimum, upperLexileRange.maximum);
   }
}
