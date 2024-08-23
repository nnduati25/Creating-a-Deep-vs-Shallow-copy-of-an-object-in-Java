Code Snippet for Shallow Copying 

// Define Student Class
class Student{

// constructor for course
course(String courseName){
    this.type=courseName;
 }
}
// defining public student Class 
 public class student {
    String name;
    Course course;

    //Constructor for student
public Student(String name, Course course) {
        this.name = name;
        this.course = course; 
 }
  // Overriding the clone() method to create a shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy
    }

    // Main method to demonstrate shallow copy
    public static void main(String[] args) {
        try {
            // Create an original Course object
            Course course = new Course("java");
            
            // Create an original Student object
            Student student1 = new Student("Martin", course);

            // Create a shallow copy of student1
            Student student2 = (Student) student1.clone();

            // Print details of original and copied students
            System.out.println("Original Student: " + student1.name + ", " + student1.course.courseName);
            System.out.println("Shallow Copy: " + student2.name + ", " + student2.course.courseName);

            // Modify the course name of the copied student
            student2.course.courseName = "Programming";

            // Print details after modification
            System.out.println("\nAfter modification:");
            System.out.println("Original Student: " + student1.course.courseName); // Output will be "programming"
            System.out.println("Shallow Copy: " + student2.course.courseName);   // Output will be "programming"
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
```
Output

```yaml
Original Student: Martin, Java
Shallow Copy: Martin, Java

After modification:
Original Student: Programming
Shallow Copy: Programming
```

  
Code Snippet for Deep Copying 
  
// Define the Course class
class Course {
    String courseName;

    // Constructor for Course
    Course(String courseName) {
        this.courseName = courseName;
    }

    // Copy constructor for deep copy
    public Course(Course original) {
        this.courseName = original.courseName;
    }
}

// Define the Student class
public class Student {
    String name;
    Course course;

    // Constructor for Student
    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    // Copy constructor for deep copy
    public Student(Student original) {
        this.name = original.name;
        // Create a new Course object to ensure deep copy
        this.course = new Course(original.course);
    }

    public static void main(String[] args) {
        // Create an original Course object
        Course course = new Course("Programming");

        // Create an original Student object
        Student student1 = new Student("Martin", course);

        // Create a deep copy of student1 using the copy constructor
        Student student2 = new Student(student1);

        // Print details of original and copied students
        System.out.println("Original Student: " + student1.name + ", " + student1.course.courseName);
        System.out.println("Deep Copy: " + student2.name + ", " + student2.course.courseName);

        // Modify the course name of the copied student
        student2.course.courseName = "Java";

        // Print details after modification
        System.out.println("\nAfter modification:");
        System.out.println("Original Student: " + student1.course.courseName); // Output will be "Programming"
        System.out.println("Deep Copy: " + student2.course.courseName);   // Output will be "Java"
    }
}

Output
```yaml
Original Student: Martin, Programming
Deep Copy: Martin, Programming

After modification:
Original Student: Programming
Deep Copy: Java

```
