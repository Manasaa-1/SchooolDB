package com.jsp.spring.SchoolDB;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.spring.SchoolDB.Controller.SchoolController;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        SchoolController schoolController = ac.getBean(SchoolController.class);
        
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        do {
            System.out.println("\nSchool Management System");
            System.out.println("1. Add School");
            System.out.println("2. Find School By Id");
            System.out.println("3. Find School By Name");
            System.out.println("4. Find Schools By City");
            System.out.println("5. Find Schools By Board");
            System.out.println("6. Update Number of Students By Id");
            System.out.println("7. Update School Location By Name");
            System.out.println("8. Delete School By Name");
            System.out.println("9. Delete Schools By Location");
            System.out.println("10. Delete Schools Where No. of Students Less Than a Limit");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println(schoolController.addSchool());
                    break;
                case 2:
                    System.out.println(schoolController.findSchoolById());
                    break;
                case 3:
                    System.out.println(schoolController.findSchoolBySchoolName());
                    break;
                case 4:
                    System.out.println(schoolController.findAllSchoolByCity());
                    break;
                case 5:
                    System.out.println(schoolController.findAllSchoolByBoard());
                    break;
                case 6:
                    schoolController.updateNoOfStudentsById();
                    break;
                case 7:
                    schoolController.updateLocationByName();
                    break;
                case 8:
                    schoolController.deleteSchoolBySchoolName();
                    break;
                case 9:
                    schoolController.deleteAllSchoolsByLocation();
                    break;
                case 10:
                    schoolController.deleteAllSchoolsWhereNoOfStudentsLessThan();
                    break;
                case 11:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 11);
        
        scanner.close();
    }
}
