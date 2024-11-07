package matchmaker.utility;

import java.util.HashMap;

public class LexileIndex {
   public static class RangeValue {
      public int minimum;
      public int maximum;
      public int range;

      /**
       * Creates an object that contains a minimum, maximum, and range property
       * @param minimum The minimum of the range
       * @param maximum The maximum of the range
       */
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

   /**Creates an index that has data correlating a students age and grade to a range of what their lexile level should be*/
   public LexileIndex(){
      //Indexes for lexiles that correlate to grade. And what age correlates to each grade
      this.ageGradeKey = new HashMap<Integer, RangeValue>();
      this.gradeLexileKey = new HashMap<Integer, RangeValue>();

      //Adds all the ages correlated to each grade manually.
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

      //Adds all the grades correlated to each lexile range manually
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
   
   /**
    * Gets a lexile score range that correlates to a student's grade level
    * @param grade What grade the student is in
    * @return A lexile score range
    */
   public RangeValue getLexileByGrade(int grade){
      return this.gradeLexileKey.get(grade);
   }

   /**
    * Gets a lexile score range that correlates to a student's grade level
    * @param age What age the student is
    * @return A lexile score range
    */
   public RangeValue getLexileByAge(int age){
      RangeValue gradeRange = this.ageGradeKey.get(age);
      RangeValue lowerLexileRange = this.gradeLexileKey.get(gradeRange.minimum);
      RangeValue upperLexileRange = this.gradeLexileKey.get(gradeRange.maximum);
      return new RangeValue(lowerLexileRange.minimum, upperLexileRange.maximum);
   }
}
