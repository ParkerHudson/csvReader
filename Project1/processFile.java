import java.io.*;
import java.util.*;

public class processFile { //Take in CSV file, store student entities in Student class, print student entities to console.

  public static void main(String[] args) {
    //Prompt user for file name/path to csv file
    Scanner sc = new Scanner(System.in);
    System.out.println("Please input path to CSV file: ");

    String filePath = sc.nextLine();

    System.out.println("\nAttempting to access CSV file at '" + filePath + "'");
    sc.close();
    //open file
    try {
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      System.out.println("\nFile accessed successfully\n");
      //read file into program (store in Student object)

      List<Student> entities = new ArrayList<>();
      String row = null;
      row = br.readLine(); // Skip first line (headers)

      while ((row = br.readLine()) != null) {
        String[] attributes = row.split(","); //Split row into individual attributes

        Student newStudent = new Student( // Create student object using provided attributes
          attributes[0],
          attributes[1],
          attributes[2],
          attributes[3]
        );
        entities.add(newStudent); //Add student object to list
      }
      br.close(); //Close buffered reader

      //print to console
      System.out.printf(
        "%-20s %-14s %-10s %-20s",
        "Name",
        "Student #",
        "Year",
        "Major"
      );
      System.out.println(
        "\n----------------------------------------------------------"
      );
      for (Student temp : entities) {
        System.out.printf(
          "%-20s %-14s %-10s %-20s",
          temp.name,
          temp.studentNum,
          temp.classYear,
          temp.major
        );
        System.out.println();
      }
    } catch (Exception e) {
      System.out.println(
        "There was an error accessing the file. Perhaps the file path is incorrect."
      );
    }
  }
}
