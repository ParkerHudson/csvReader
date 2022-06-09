public class Student {

  public String name, studentNum, classYear, major; //variables for student info

  public Student() {} //default constructor

  public Student( //Constuctor
    String name,
    String studentNum,
    String classYear,
    String major
  ) { //Create student object and assign variables
    this.name = name;
    this.studentNum = studentNum;
    this.classYear = classYear;
    this.major = major;
  }
}
