/** 
 * By: Marcos Gil
 * 
 * This is a program that takes 6 command line arguments(which are the users
 * grades in this order for Assignments, Project, Tutorials, Quizzes, Miderm,
 * and Final). The program takes these grades and calulates the users final
 * grade then return it rounded to 1 decimal place.
 * 
 * Using DrJava: Hit the compile button to compile, then in the 
 * Interactions window, type
 * 
 *  java Grades num num num num num num
 * 
 * Using cmd.exe (windows) or terminal (mac)
 * Compilation: javac Grades.java
 * Usage      : java Grades num num num num num num
 *
 * Examples: (run in the interaction window of DrJava, or a shell)
 *  
 * > java Grades 3
 * Usage: java Grades A P T Q M F
 *
 * where each is a non-negative number 
 * 
 * > java Grades 75.1 30 45.1 77 65.2 72.3
 * 65.2
 */

public class Grades{
  
  /* A class that contains the methods required to compute the Final Grade round the final grade
   * to 1 decimal place */
  
  public static double computeGrade(String[] grades){
    
    /**
    * This method will return a double that contains the
    * users Final Grade(before being rounded)
    * 
    * Input: An array of strings that holds each grade portion
    * Return: A single double that holds the users Final Grade
    * 
    * Contract:
    *  computerGrade: String[] -> double
    *  
    *  Purpose: Calculate the Final Grade of a user
    *  
    *  Pre-Conditions:
    *    6 command line arguments, all being in the range of 0-105
    *  
    *  Post-Conditions:
    *    Outputs >"Sorry you can only enter grades up to 105 in the command line arguments. Please try again. "
    *            >"0.0"
    *            If a number outside the range is entered
    * 
    *            > num
    *            If command line arguments are valid.
    * 
    *  Side Effecs:
    *    None
    */
  
    /* Setting a return value of 0 and returning it if the command line input are not valid(since the method requires a double return */
    double incorrectInputReturn = 0; 
    
    /* Loop for checking if the command line inputs fall into the required range and returns a message and the value 0 if they don't*/
    for (int i = 0; i < grades.length; i += 1){
      double checkValue = Double.parseDouble(grades[i]);
      if ((checkValue > 105) || (checkValue < 0)){
        System.out.println("Sorry you can only enter grades between 0 and 105 in the command line arguments. Please try again. ");
        return incorrectInputReturn;
      }
    }
    
    /* Taking input which is in string formart and turning it into a float so it can be 
     * used with arimetic operatons then calculating the weight of each mark portion */
    float assignments = Float.parseFloat(grades[0]);
    float project = Float.parseFloat(grades[1]);
    float tutorials = Float.parseFloat(grades[2]);
    float quizzes = Float.parseFloat(grades[3]);
    float midTerm = Float.parseFloat(grades[4]);
    float finalExam = Float.parseFloat(grades[5]);
    
    double assignmentWeight = assignments * 0.25;
    double projectWeight = project * 0.1;
    double tutorialsWeight = tutorials * 0.1;
    double quizzesWeight = quizzes * 0.05;
    double midTermWeight = midTerm * 0.15;
    double finalExamWeight = finalExam * 0.35;
    
    /* Making sure the user passed the Midterm + Final with a combined amount of over 25, since if they didn't the class is failed */
    
    if (finalExamWeight + midTermWeight >= 25){
      double finalGrade = assignmentWeight + projectWeight + tutorialsWeight + quizzesWeight + midTermWeight + finalExamWeight; 
      return finalGrade;
    }
    else {
      return Math.min(((finalExamWeight + midTermWeight)*2), assignmentWeight + projectWeight + tutorialsWeight + quizzesWeight + midTermWeight + finalExamWeight);
    }
  }

  public static String roundGrade(double grade){
    
    /**
    * This method will return a string that contains the users Final
    * Grade after being rounded to one decimal place.
    * 
    * Input: A double that contains the users Final Grade
    * Return: A string that contains the users Final Grade rounded to 1 decimal place
    * 
    * Contract:
    *  roundGrade: double -> String
    *  
    *  Purpose: Round the grade to 1 decimal then return it as a string
    *  
    *  Pre-Conditions:
    *    A single double that holds the users Final Grade 
    *  
    *  Post-Conditions:
    *    Outputs >string of Final Grade
    *            Example: "75.1"
    *            If a double is passed into the method
    *  
    *  Side Effecs:
    *    None
    */
    
    /* Using Math.round to round our input then making it into a string and returning it */
    double finalGradeRounded = Math.round(grade * 10.0)/10.0;
    String roundedGradeString  = Double.toString(finalGradeRounded);
    
    return roundedGradeString;
  }
  
  public static void main(String[] args){

    // check that right number of command line arguments were given
    if( args.length != 6){
      System.out.println("Usage: java Grades A P T Q M F\n\nwhere each is a non-negative number");
      return; // exit program
    }
    
    // args has six elements -- we assume each represents a non-negative number
    System.out.println(roundGrade(computeGrade(args)));
    }
}