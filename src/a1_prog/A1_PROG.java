package a1_prog;  

import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;  

// Student class that represents a learner  
class Student {  
    private String studentId;  
    private String name;  
    private int age;  
    private String email;  
    private String course;  

    public Student(String studentId, String name, int age, String email, String course) {  
        this.studentId = studentId;  
        this.name = name;  
        this.age = age;  
        this.email = email;  
        this.course = course;  
    }  

    public String getStudentId() {  
        return studentId;  
    }  

    public String getName() {  
        return name;  
    }  

    public int getAge() {  
        return age;  
    }  

    public String getEmail() {  
        return email;  
    }  

    public String getCourse() {  
        return course;  
    }  

    @Override
public String toString() {
    return "STUDENT ID: " + studentId + "\n" +
           "STUDENT NAME: " + name + "\n" +
           "STUDENT AGE: " + age + "\n" +
           "STUDENT EMAIL: " + email + "\n" +
           "STUDENT COURSE: " + course + "\n";
}


}  

public class A1_PROG {  
    private static ArrayList<Student> students = new ArrayList<>();  
    private static Scanner scanner = new Scanner(System.in);  

    public static void main(String[] args) {  
        while (true) {  
            System.out.println("STUDENT MANAGEMENT APPLICATION");  
            System.out.println("Please select one of the following menu items:");  
            System.out.println("[1] Capture a new student.");  
            System.out.println("[2] Search for a student.");  
            System.out.println("[3] Delete a student.");  
            System.out.println("[4] Print students report.");  
            System.out.println("[5] Exit Application.");  

            int choice = scanner.nextInt();  
            scanner.nextLine(); // Consume newline  

            switch (choice) {  
                case 1:  
                    captureStudent();  
                    break;  
                case 2:  
                    searchStudent();  
                    break;  
                case 3:  
                    deleteStudent();  
                    break;  
                case 4:  
                    printStudentReport();  
                    break;  
                case 5:  
                    System.out.println("Exiting student management application...");  
                    // Do not close the scanner here; instead, transition to learner management  
                    LearnerManagementApplication.main(args);  
                    return;  
                default:  
                    System.out.println("Invalid choice. Please try again.");  
            }  
        }  
    }  

    private static void captureStudent() {  
        System.out.println("CAPTURE A NEW STUDENT");  
        System.out.print("Enter the student ID: ");  
        String studentId = scanner.nextLine();  
        System.out.print("Enter the student name: ");  
        String name = scanner.nextLine();  
        int age = 0;  

        while (true) {  
            System.out.print("Enter the student age (must be 16 or older): ");  
            String input = scanner.nextLine();  
            
            // Check if the input is a valid integer  
            if (!input.matches("\\d+")) {  
                System.out.println("You have entered an incorrect student age!!! Please enter a numeric value.");  
                continue; // Prompt for age again  
            }  

            age = Integer.parseInt(input);  
            
            // Check if the age is less than 16  
            if (age < 16) {  
                System.out.println("You have entered an incorrect student age!!! Age must be 16 or older.");  
            } else {  
                break; // Valid age  
            }  
        }  

        System.out.print("Enter the student email: ");  
        String email = scanner.nextLine();  
        System.out.print("Enter the student course: ");  
        String course = scanner.nextLine();  

        students.add(new Student(studentId, name, age, email, course));  
        System.out.println("Student details have been successfully saved.");  
    }  

    private static void searchStudent() {  
        System.out.print("Enter the student ID to search: ");  
        String studentId = scanner.nextLine();  
        for (Student student : students) {  
            if (student.getStudentId().equals(studentId)) {  
                System.out.println(student);  
                return;  
            }  
        }  
        System.out.println("Student with Student ID: " + studentId + " was not found!");  
    }  

    private static void deleteStudent() {  
        System.out.print("Enter the student ID to delete: ");  
        String studentId = scanner.nextLine();  
        for (Student student : students) {  
            if (student.getStudentId().equals(studentId)) {  
                System.out.print("Are you sure you want to delete student " + studentId + "? (y/n): ");  
                String confirmation = scanner.nextLine();  
                if (confirmation.equalsIgnoreCase("y")) {  
                    students.remove(student);  
                    System.out.println("Student with Student ID: " + studentId + " was deleted.");  
                }  
                return;  
            }  
        }  
        System.out.println("Student with Student ID: " + studentId + " was not found!");  
    }  

    private static void printStudentReport() {  
        System.out.println("STUDENT REPORT");  
        for (Student student : students) {  
            System.out.println(student);  
        }  
    }  
}  










// QUESTION 3
// Scenario:  A local school is having problem with student management in terms of keeping their information and reports. 
//            I have designed a student management sytem that will help keep track of the students information.

class LearnerManager {  
    private List<Student> learners;  

    public LearnerManager() {  
        learners = new ArrayList<>();  
    }  

    public void addLearner(Student learner) {  
        learners.add(learner);  
    }  

    public void displayLearners() {  
        for (Student learner : learners) {  
            System.out.println(learner);  
        }  
    }  

    public void generateReport() {  
        System.out.println("Learner Report:");  
        System.out.println("====================");  
        displayLearners();  
        System.out.println("====================");  
    }  

    public List<Student> getLearners() {  
        return learners;  
    }  
}  

// Main class for learner management  
class LearnerManagementApplication {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        LearnerManager learnerManager = new LearnerManager();  

        while (true) {  
            System.out.println("LEARNER MANAGEMENT APPLICATION");  
            System.out.println("1. Add Learner");  
            System.out.println("2. Display Learners");  
            System.out.println("3. Generate Learner Report");  
            System.out.println("4. Exit");  
            System.out.print("Choose an option: ");  
            int choice = scanner.nextInt();  
            scanner.nextLine(); // Consume newline  

            switch (choice) {  
                case 1:  
                    System.out.print("Enter The Student's name: ");  
                    String name = scanner.nextLine();  
                    System.out.print("Enter No. of days been Absent: ");  
                    String absent = scanner.nextLine();  
                    System.out.print("Enter No. days Attended: ");  
                    int present = scanner.nextInt();  
                    scanner.nextLine(); 
                    System.out.print("Enter The Subject Name: ");  
                    String subject = scanner.nextLine();  
                    System.out.print("Enter The Corresponding Mark : ");  
                    String score = scanner.nextLine();  
                    Student learner = new Student(name, absent, present, subject, score);  
                    learnerManager.addLearner(learner);  
                    break;  
                case 2:  
                    learnerManager.displayLearners();  
                    break;  
                case 3:  
                    learnerManager.generateReport();  
                    break;  
                case 4:  
                    System.out.println("Exiting...");  
                    scanner.close();  
                    return;  
                default:  
                    System.out.println("Invalid option. Please try again.");  
            }  
        }  
    }  
}

/*
    Title: Sololearn
    Author: Davit Kocharyan and Yeva Hyusyan
    Date: 12 july 2022
    Code version: 1
    Avaailability: https://www.sololearn.com/en/
    */

/*
    Title: GeeksforGeeks - Java Programming Language
    Author: GeeksforGeeks Team
    Date: 5 March 2023
    Code version: 2.1
    Availability: https://www.geeksforgeeks.org/java/
*/


/*
    Title: Java Documentation - Oracle
    Author: Oracle Corporation
    Date: 20 August 2022
    Code version: Java SE 17
    Availability: https://docs.oracle.com/javase/17/docs/
*/

/*
    Title: JavaTpoint - Java Tutorial
    Author: JavaTpoint Team
    Date: 10 April 2023
    Code version: 3.0
    Availability: https://www.javatpoint.com/java-tutorial
*/

