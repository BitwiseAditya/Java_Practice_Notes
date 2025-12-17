import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable {
    private int studentId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private Set<Course> courses;
    private int age;
    // Code for getter and setter methods

    public Student(int studentId, String firstName, String lastName, String dateOfBirth, Set<Course> courses, int age) {

        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.courses = courses;
        this.age = age;
    }

}

public class Serialization {
    // Create a stream instance to write to a file
FileOutputStream outFile = new FileOutputStream("StudentData.bin");
 
Set<Course>courses=new HashSet<>();
courses.add(new Course("Java"));
courses.add(new Course("Python"));
 
// Get a student object
Student student=new Student(20156,"Peter","Johnson","29/05/1995",courses,23);
 
// Create ObjectStream
ObjectOutputStream objStream = new ObjectOutputStream(outFile);
 
// Write the student object
objStream.writeObject(student);
 
objStream.close();
outFile.close();

}
