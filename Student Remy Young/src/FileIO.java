import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.*;
public class FileIO {
  public static void main(String[] args)
  {
    //BufferedReader reader = null;
    try{
      File data = new File("/Users/student/Downloads/all_students_jan.csv");
      Path studentfile = Paths.get("/Users/student/Downloads/all_students_jan.csv");
      BufferedReader reader =  Files.newBufferedReader(studentfile, StandardCharsets.UTF_8);
      //  reader = new BufferedReader(new FileReader(data));
      Scanner file = new Scanner(data);
      ArrayList<Student> students = new ArrayList<Student>();
      file.nextLine();//skip the first line, it is not needed.
      //buffered reader
      //while(file.hasNextLine())
      File output =new File("/Users/student/Desktop/output.html"); // output location
      //if file doesnt exists, then create it
      if(!output.exists()){
        output.createNewFile();
      }
      FileWriter fw = new FileWriter(output);
      BufferedWriter bw = new BufferedWriter(fw);

      int counter = 0;
      String line;
      try{
        while( (line = file.nextLine()) !=null)
        {

          //reader.readLine();
          students.add(new Student(line));
          //System.out.println(line);
          // counter ++;
          //System.out.println(counter);

        }
      }
      catch(NoSuchElementException e){

      }
      boolean stop = false;
      Scanner input = new Scanner(System.in);
      System.out.println("Student information has been compiled.");
      while(stop == false)
      {
       try{ Thread.sleep(10);
       }
       catch(InterruptedException ex){
         Thread.currentThread().interrupt();
       }
       
      System.err.println("What would you like to do?");
      System.err.println("Please press 1 to match a last name.");
      System.err.println("Please press 2 to see if there are twins.");
      System.err.println("Please press 3 to find all of the students with the same birth month.");
      System.err.println("Please press 4 to find all students of a specific house.");
      System.err.println("Please press 5 to sort students by last name.");
      System.err.println("Please press 6 to tally the amount of males and females.");
      System.err.println("Please press 7 to find the number of students in two grades.");
      System.err.println("Please press 8 to find all of the students born in 2001.");
      System.err.println("Please press 9 to find first name frequency.");
      System.err.println("Please press 10 to sort the students by grade.");
      System.err.println("Please press 11 to find last name frequency.");
      System.err.println("Please press 12 to sort students by first name");
      System.err.println("Please press 13 to find what students enetered in a grade");
      System.err.println("Please press 14 to end");
      int choice = input.nextInt();
      //firstName; 0
      //middleName; 1
      //lastName; 2
      //sexCode; 3
      //gradeEntered; 4
      //currentGrade; 5
      //classYear; 6
      //birthDay; 7
      //birthMonth; 8
      //birthYear; 9
      //advisorName; 10

      //MatchLastName
      if(choice == 1)
      {
        Write("Match Last Name Data <br>", bw);
        MatchLastName(students, bw);
      }
      //Twins
      if(choice == 2)
      {
        Write("Twins Data <br>", bw);
        Twins(students,bw);
        
      }
      //SameBirthMonth
      if(choice == 3)
      {
        Write("Same Birth Month Data <br>", bw);
        SameBirthMonth(students, bw);
       
      }
      //SimilarHouse
      if(choice == 4)
      {
        Write("Similar House Data <br>", bw);
        SimilarHouse(students, bw);
        
      }
      //SortedByLastName
      if(choice == 5)
      {
        Write("Sorted By Last Name Data <br>", bw);
        SortedByLastName(students, bw);
        

      }
      //NumberOfMalesAndFemales
      if(choice == 6)
      {
        Write("Number Of Males and Females Data <br>", bw);
        NumberOfMalesAndFemales(students, bw);
        
      }
      // WhichGradeEntered
      if(choice == 7)
      {
        Write("Which Grade Entered Data <br>", bw);
        WhichGradeIn(students, bw);
        
      }
      //StudentsBornIn2001
      if(choice == 8)
      {
        Write("Sundetns Born in a certain Grade Data <br>", bw);
        StudentsBornIn2001(students, bw);
       
      }
      //FirstNameFrequency
      if(choice == 9)
      {
        Write("First Name Frequency Data <br>", bw);
        FirstNameFrequency(students, bw);
      
      }
      //StudentsByGrade
      if(choice == 10)
      {
        Write("Students By Grade Data <br>", bw);
        StudentsByGrade(students, bw);
        
      }
      if(choice == 11)
      {
        Write("Last Name Freqency Data <br>", bw);
        LastNameFrequency(students, bw);
        
      }
      if(choice == 12)
      {
        Write("First Name Frequency Data <br>", bw);
        SortedByFirstName(students, bw);
       
      }
      if(choice == 13)
      {
        Write("Which Grade Entered Data <br>", bw);
        EnterTheGrade(students, bw);
        
      }
      if(choice == 14)
      {
        stop = true;
      }
      System.out.println();
      Write("<br>", bw);
    }
      System.out.println("Thank You!");
      Write("Thank You For Using! <br>", bw);
      bw.close();

    }
    catch(IOException e){
      System.out.println(e);

    }


    
  }
  public static void MatchLastName(ArrayList<Student> student, BufferedWriter bw)
  {
    System.out.println("Please enter in the last name of the student you would like to find");
    System.out.println("Please Make sure that the first letter of the last name is capitalized");
    Scanner read = new Scanner(System.in);
    String lastName = read.nextLine();
    for(int i = 0; i<student.size();i++)
    {
      if(student.get(i).getLastName().contains(lastName) == true)
      {
        System.out.println(student.get(i).getFirstName() +" "+student.get(i).getMiddleName() + " " + student.get(i).getLastName() + " " + student.get(i).getSexCode() + " " + student.get(i).getGradeEntered() + " " + student.get(i).getCurrentGrade() + " "+ student.get(i).getClassYear() + " "+ student.get(i).getBirthDay() + " "+student.get(i).getBirthMonth() + " " + student.get(i).getBirthYear() + " "+ student.get(i).getAdvisorName());
        Write(student.get(i).getFirstName() +" "+student.get(i).getMiddleName() + " " + student.get(i).getLastName() + " " + student.get(i).getSexCode() + " " + student.get(i).getGradeEntered() + " " + student.get(i).getCurrentGrade() + " "+ student.get(i).getClassYear() + " "+ student.get(i).getBirthDay() + " "+student.get(i).getBirthMonth() + " " + student.get(i).getBirthYear() + " "+ student.get(i).getAdvisorName()+ "<br>", bw);
      }
    }
  }

  public static void Twins(ArrayList<Student> student, BufferedWriter bw)
  {
    Collections.sort(student, new Comparator<Student>(){
      @Override
      public int compare(Student student1, Student student2)
      {
        return student1.getLastName().compareTo(student2.getLastName());
      }
    });
   // for(int i = 0; i< student.size(); i++)
   // {
   //   System.out.println(student.get(i).getLastName());
   // }
    System.out.println("Twins:");
    int p = 0;
    for(int i = 0; i<student.size(); i++)
    {
     // System.out.println("Hello");

      if(p<student.size()-1)
      {
        p = i+1;
      }
      //System.out.println(student.get(i).getLastName());
      while(student.get(i).getLastName().equals(student.get(p).getLastName())==true)
      {
  
      //   System.out.println(student.get(p).getLastName());

        //System.out.println(student.get(i).getBirthDay());
        //System.out.println(student.get(p).getBirthDay());
       // System.out.println();
        if(student.get(i).getBirthDay() == student.get(p).getBirthDay() && student.get(i).getBirthMonth() == student.get(p).getBirthMonth() && student.get(i).getBirthYear() == student.get(p).getBirthYear()&& student.get(i).getFirstName() != student.get(p).getFirstName())
        {
          System.out.println(student.get(i).getFirstName() + " " +student.get(i).getLastName());
          System.out.println(student.get(p).getFirstName() + " " +student.get(p).getLastName());
          System.out.println();
      
          Write(student.get(i).getFirstName() + " " +student.get(i).getLastName(), bw);
          Write(" & ", bw);
          Write(student.get(p).getFirstName() + " " +student.get(p).getLastName() + "<br>", bw);
         
        }
        
        if(p<student.size()-1)
        {
        p++;
        }
        else
        {
          break;
          
        }
      }
    }


  }
  public static void SameBirthMonth(ArrayList<Student> student, BufferedWriter bw)
  {

    String[] months = new String[]{"Janurary", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
   //for(int i = 1; i<13; i++)
    //{
     // System.out.println("Students born in the month of "+ months[i-1] + ":");
     // for(int q=0; q<student.size(); q++)
     // {
     //   if(student.get(q).getBirthMonth() == i)
     //   {
     //     System.out.println(student.get(q).getFirstName() + " " + student.get(q).getLastName());
     //     Write(student.get(q).getFirstName() + " " + student.get(q).getLastName()+ "<br>", bw);
     //   }
     // }
      
    System.out.println("Please enter in the month that you would like to see which students have a birthday in.");
    System.out.println("(Press 1 for Janurary, 2 for Feburary, 3 for March . . . .)");
    Scanner read = new Scanner(System.in);
    int BirthMonth = read.nextInt();
    for(int i = 0; i<student.size(); i ++)
    {
      if(student.get(i).getBirthMonth() == BirthMonth){
      System.out.println(student.get(i).getFirstName() + " " + student.get(i).getLastName());
      Write(student.get(i).getFirstName() + " " + student.get(i).getLastName()+ "<br>", bw);
      }
      }
    Write("<br>", bw);
    }
  public static void SimilarHouse(ArrayList<Student> student, BufferedWriter bw)
  {
    System.out.println("Please enter in a house with the format Last Name/Last Name or First Name Last Name.  (Please also ensure that the first letter of each name is capitalized.)");
    Scanner read = new Scanner(System.in);
    String houseAdvisor = read.nextLine();
    for(int i = 0; i<student.size(); i++)
    {
      if(student.get(i).getAdvisorName().contains(houseAdvisor) == true)
      {
        System.out.println(student.get(i).getFirstName() + " " + student.get(i).getLastName());
        Write(student.get(i).getFirstName() + " " + student.get(i).getLastName()+"<br>", bw);
      }
    }
  }
  public static void SortedByLastName(ArrayList<Student> student, BufferedWriter bw)
  {

    Collections.sort(student, new Comparator<Student>(){
      @Override
      public int compare(Student student1, Student student2)
      {
        return student1.getLastName().compareTo(student2.getLastName());
      }
    });
    for(int i = 0; i<student.size(); i++)
    {
      System.out.println(student.get(i).getFirstName() + " " + student.get(i).getLastName());
      Write(student.get(i).getFirstName() + " " + student.get(i).getLastName()+"<br>", bw);
    }
  }
  public static void SortedByFirstName(ArrayList<Student> student, BufferedWriter bw)
  {
    //FIX THIS
    Collections.sort(student, new Comparator<Student>(){
      @Override
      public int compare(Student student1, Student student2)
      {
        return student1.getFirstName().compareTo(student2.getFirstName());
      }
    });
    for(int i = 0; i<student.size(); i++)
    {
      System.out.println(student.get(i).getFirstName() + " " + student.get(i).getLastName());
      Write(student.get(i).getFirstName() + " " + student.get(i).getLastName()+"<br>", bw);
    }

  }
  public static void NumberOfMalesAndFemales(ArrayList<Student> student, BufferedWriter bw)
  {
    int males = 0;
    int females = 0;
    for(int i= 0; i<student.size(); i++)
    {

      if(student.get(i).getSexCode().contains("F") == true)
      {
        females ++;
      }
      if(student.get(i).getSexCode().contains("M")== true)
      {
        males ++;
      }
    }
    System.out.println("number of males: " + males);
    System.out.println("number of females: " + females);
    Write("number of males: " + males +"<br>", bw);
    Write("number of females: " + females+"<br>", bw);
    

  }
  public static void EnterTheGrade(ArrayList<Student> student, BufferedWriter bw)
  {
    Scanner read = new Scanner(System.in);
    System.out.println("Please enter the grade you would like to see which students entered in");
    String Grade = read.nextLine();
    
    for(int i = 0; i< student.size(); i++)
    {
      if(student.get(i).getGradeEntered().contains(Grade))
      {
        System.out.println(student.get(i).getFirstName() +" "+student.get(i).getMiddleName() + " " + student.get(i).getLastName() + " " + student.get(i).getSexCode() + " " + student.get(i).getGradeEntered() + " " + student.get(i).getCurrentGrade() + " "+ student.get(i).getClassYear() + " "+ student.get(i).getBirthDay() + " "+student.get(i).getBirthMonth() + " " + student.get(i).getBirthYear() + " "+ student.get(i).getAdvisorName());
      }
    }
  }
  public static void WhichGradeIn(ArrayList<Student> student, BufferedWriter bw)
  {
    //Get it so that
    Scanner read = new Scanner(System.in);
    System.out.println("Please enter the first grade(4-12) you would like to see how many kids are in");
    String firstGradeString = read.nextLine();
    System.out.println("Please enter the second grade(4-12) you would like to see how many kids are in");
    String secondGradeString = read.nextLine();
    int firstGradeCount = 0;
    int secondGradeCount = 0;
    try{
    if(Integer.parseInt(firstGradeString) != 4&& Integer.parseInt(firstGradeString)!= 5&&Integer.parseInt(firstGradeString) != 6&&Integer.parseInt(firstGradeString) != 7&&Integer.parseInt(firstGradeString) != 8&&Integer.parseInt(firstGradeString) != 9&&Integer.parseInt(firstGradeString) != 10&&Integer.parseInt(firstGradeString) !=11&&Integer.parseInt(firstGradeString) != 12)
    {
      System.out.println("That was an invalid input");
      return;
    }
    if(Integer.parseInt(secondGradeString) != 4&& Integer.parseInt(secondGradeString) != 5&&Integer.parseInt(secondGradeString) != 6&&Integer.parseInt(secondGradeString) != 7&&Integer.parseInt(secondGradeString) != 8&&Integer.parseInt(secondGradeString) != 9&&Integer.parseInt(secondGradeString) != 10&&Integer.parseInt(secondGradeString) !=11&&Integer.parseInt(secondGradeString) != 12)
    {
      System.out.println("That was an invalid input");
      return;
    }
    }
    catch(Exception e)
    {
      System.out.println("That was not a valid input");
      return;
    }
    int  firstGrade = Integer.parseInt(firstGradeString);
    int secondGrade = Integer.parseInt(secondGradeString);
    for(int i = 0; i< student.size(); i++)
    {
       if(student.get(i).getCurrentGrade() == firstGrade)
      {
        firstGradeCount ++;
      }
      //if you don't have 4 - 12 say invalid data
      //if(firstGrade == "K")
      //{
       // firstGradeCount ++;
      //}
      if(student.get(i).getCurrentGrade() == secondGrade) // make sure that none of the K's get through
      {
        secondGradeCount ++;
      }


    }
    System.out.println("Number of Kids in " + firstGrade +": "+ firstGradeCount);
    System.out.println("Number of Kids in " + secondGrade +": "+ secondGradeCount);
    Write("Number of Kids in " + firstGrade +": "+ firstGradeCount + "<br>", bw);
    Write("Number of Kids in " + secondGrade +": "+ secondGradeCount + "<br>", bw);
    
  }
  public static void StudentsBornIn2001(ArrayList<Student> student, BufferedWriter bw)
  {
    for(int i = 0; i<student.size();i++)
    {
      if(student.get(i).getBirthYear() == 2001)
      {
        System.out.println(student.get(i).getFirstName() + " " + student.get(i).getLastName());
        Write(student.get(i).getFirstName() + " " + student.get(i).getLastName() + "<br>", bw);
      }
    }
  }
  public static void FirstNameFrequency(ArrayList<Student> student, BufferedWriter bw)
  {
    Collections.sort(student, new Comparator<Student>(){
      @Override
      public int compare(Student student1, Student student2)
      {
        return student1.getFirstName().compareTo(student2.getFirstName());
      }
    });
    //for(int  i = 0;i<student.size(); i++)
    //{
    // System.out.println(student.get(i).getFirstName());
    //}
    String firstName[] = new String[student.size()];
    int firstNameFrequency[] = new int[student.size()];
    int q =0;
    for(int i = 0; i<student.size(); i++)
    {
      if(i == 0)
      {
        firstName[q] = student.get(i).getFirstName();
        firstNameFrequency[q] ++;
      }
      if(student.get(i).getFirstName().equals(firstName[q]))
      {
        firstNameFrequency[q] ++;
      }
      else{
        q++;
        firstName[q] = student.get(i).getFirstName();
        firstNameFrequency[q] ++;
      }
    }
    //  for(int i = 0; i<firstName.length; i++)
    //  {
    //    System.out.println(firstNameFrequency[i]);
    //  }
    int Max = 0;
    int Counter = 0;
    int SpaceFound = 0;
    int FrequencyFound = 0;
    for(int p = 0; p<10; p++)
    {
      for(int m = 0; m<firstNameFrequency.length;m++)
      {
        Counter =Counter + firstNameFrequency[m];
        //  System.out.println("Counter :"  + Counter);
        if(firstNameFrequency[m]>Max)
        {
          Max = firstNameFrequency[m];
          FrequencyFound = m;
          SpaceFound  = Counter;
        }
      }
      int ForOutput = p+1;

      System.out.println("The "+ ForOutput +" most common name is: " + firstName[FrequencyFound] + " with " + firstNameFrequency[FrequencyFound] + " counts");
      Write("The "+ ForOutput +" most common name is: " + firstName[FrequencyFound] + " with " + firstNameFrequency[FrequencyFound] + " counts <br>", bw);
      firstNameFrequency[FrequencyFound] = 0;
      Max = 0;
      FrequencyFound = 0;
      SpaceFound = 0;
      Counter = 0;
    }
    try {
      Thread.sleep(10);               
  } catch(InterruptedException ex) {
      Thread.currentThread().interrupt();
  }
  }
  public static void LastNameFrequency(ArrayList<Student> student, BufferedWriter bw)
  {
    Collections.sort(student, new Comparator<Student>(){
      @Override
      public int compare(Student student1, Student student2)
      {
        return student1.getLastName().compareTo(student2.getLastName());
      }
    });
    //for(int  i = 0;i<student.size(); i++)
    //{
    // System.out.println(student.get(i).getFirstName());
    //}
    String LastName[] = new String[student.size()];
    int LastNameFrequency[] = new int[student.size()];
    int q =0;
    for(int i = 0; i<student.size(); i++)
    {
      if(i == 0)
      {
        LastName[q] = student.get(i).getLastName();
        LastNameFrequency[q] ++;
      }
      if(student.get(i).getLastName().equals(LastName[q]))
      {
        LastNameFrequency[q] ++;
      }
      else{
        q++;
        LastName[q] = student.get(i).getLastName();
        LastNameFrequency[q] ++;
      }
    }
    //  for(int i = 0; i<firstName.length; i++)
    //  {
    //    System.out.println(firstNameFrequency[i]);
    //  }
    int Max = 0;
    int Counter = 0;
    int SpaceFound = 0;
    int FrequencyFound = 0;
    for(int p = 0; p<10; p++)
    {
      for(int m = 0; m<LastNameFrequency.length;m++)
      {
        Counter =Counter + LastNameFrequency[m];
        //  System.out.println("Counter :"  + Counter);
        if(LastNameFrequency[m]>Max)
        {
          Max = LastNameFrequency[m];
          FrequencyFound = m;
          SpaceFound  = Counter;
        }
      }
      int ForOutput = p+1;

      System.out.println("The "+ ForOutput +" most common name is: " + LastName[FrequencyFound] + " with " + LastNameFrequency[FrequencyFound] + " counts");
      Write("The "+ ForOutput +" most common name is: " + LastName[FrequencyFound] + " with " + LastNameFrequency[FrequencyFound] + " counts <br>", bw);
      LastNameFrequency[FrequencyFound] = 0;
      Max = 0;
      FrequencyFound = 0;
      SpaceFound = 0;
      Counter = 0;
    }
  }
  
  public static void StudentsByGrade(ArrayList<Student> student, BufferedWriter bw)
  {
    for(int i = 0; i<9; i++)
    {
      int gradeOn = i +4;
      System.out.println("Students in Grade " + gradeOn+":");
      for(int q = 0; q<student.size(); q++)
      {
        if(student.get(q).getCurrentGrade() == gradeOn)
        {
          System.out.println(student.get(q).getFirstName() + " " + student.get(q).getLastName());
          Write(student.get(q).getFirstName() + " " + student.get(q).getLastName()+"<br>", bw);
        }
      }
      System.out.println();
      Write("<br>", bw);

    }
  }
  public static void Write(String content, BufferedWriter bw)
  {
    try{
    bw.write(content);
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
    }
  


}

