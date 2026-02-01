//// Problem 4 : A java program to read object and write into file using Serializable Interface.

package JavaLabmannual;

import java.io.*;

//Step 1: Create a class that implements Serializable
class Employee implements Serializable {
 private static final long serialVersionUID = 1L; // good practice
 int id;
 String name;
 double salary;

 // Constructor
 public Employee(int id, String name, double salary) {
     this.id = id;
     this.name = name;
     this.salary = salary;
 }

 // Display method
 void display() {
     System.out.println("ID: " + id);
     System.out.println("Name: " + name);
     System.out.println("Salary: " + salary);
 }
}

//Step 2: Main class to write and read the object
public class SerizableInterface_04 {
 public static void main(String[] args) {
     // Create an employee object
     Employee emp = new Employee(101, "Mohit Kumar", 55000.0);

     // File name where object will be stored
     String filename = "employee.dat";

     // --- Write object to file ---
     try (FileOutputStream fos = new FileOutputStream(filename);
          ObjectOutputStream oos = new ObjectOutputStream(fos)) {

         oos.writeObject(emp);
         System.out.println("✅ Object has been serialized and saved to " + filename);

     } catch (IOException e) {
         e.printStackTrace();
     }

     // --- Read object from file ---
     try (FileInputStream fis = new FileInputStream(filename);
          ObjectInputStream ois = new ObjectInputStream(fis)) {

         Employee e = (Employee) ois.readObject();
         System.out.println("\n✅ Object has been deserialized:");
         e.display();

     } catch (IOException | ClassNotFoundException e) {
         e.printStackTrace();
     }
 }
}

