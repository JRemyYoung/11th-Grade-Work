import java.io.File;
import java.util.Scanner;


public class Student {
 
    Scanner input = new Scanner(System.in);
    String firstName;
    String middleName;
    String lastName;
    String sexCode;
    String gradeEntered;
    int currentGrade;
    int classYear;
    int birthDay;
    int birthMonth;
    int birthYear;
    String advisorName;
    
    public Student(String input)
    {
      
      String[] line = input.split(",");
      firstName = line[0];
      middleName = line[1];
      lastName = line[2];
      sexCode = line[3];
      gradeEntered = line[4];
      currentGrade = Integer.parseInt(line[5]);
      classYear = Integer.parseInt(line[6]);
      birthDay = Integer.parseInt(line[7]);
      birthMonth = Integer.parseInt(line[8]);
      
      birthYear = Integer.parseInt(line[9]);
      advisorName = line[10];
    }

    public Scanner getInput() {
      return input;
    }

    public void setInput(Scanner input) {
      this.input = input;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getMiddleName() {
      return middleName;
    }

    public void setMiddleName(String middleName) {
      this.middleName = middleName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public String getSexCode() {
      return sexCode;
    }

    public void setSexCode(String sexCode) {
      this.sexCode = sexCode;
    }

    public String getGradeEntered() {
      return gradeEntered;
    }

    public void setGradeEntered(String gradeEntered) {
      this.gradeEntered = gradeEntered;
    }

    public int getCurrentGrade() {
      return currentGrade;
    }

    public void setCurrentGrade(int currentGrade) {
      this.currentGrade = currentGrade;
    }

    public int getClassYear() {
      return classYear;
    }

    public void setClassYear(int classYear) {
      this.classYear = classYear;
    }

    public int getBirthDay() {
      return birthDay;
    }

    public void setBirthDay(int birthDay) {
      this.birthDay = birthDay;
    }

    public int getBirthMonth() {
      return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
      this.birthMonth = birthMonth;
    }

    public int getBirthYear() {
      return birthYear;
    }

    public void setBirthYear(int birthYear) {
      this.birthYear = birthYear;
    }

    public String getAdvisorName() {
      return advisorName;
    }

    public void setAdvisorName(String advisorName) {
      this.advisorName = advisorName;
    }
    
}
