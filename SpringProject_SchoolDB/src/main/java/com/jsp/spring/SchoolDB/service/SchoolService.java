package com.jsp.spring.SchoolDB.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.spring.SchoolDB.entity.School;
import com.jsp.spring.SchoolDB.repository.SchoolRepository;


@Service
public class SchoolService {
	@Autowired
	private SchoolRepository schoolRepository;
	Scanner scanner=new Scanner(System.in);
	public String addSchool() {
		School school = new School();

		System.out.println("Enter SchoolId");
		school.setSchoolId(scanner.nextInt());
		scanner.nextLine();  

		System.out.println("Enter SchoolName");
		school.setSchoolName(scanner.nextLine()); 

		System.out.println("Enter location");
		school.setLocation(scanner.nextLine());

		System.out.println("Enter city");
		school.setCity(scanner.nextLine());

		System.out.println("Enter board");
		school.setBoard(scanner.nextLine());

		System.out.println("Enter noOf Students");
		school.setNoOfStudent(scanner.nextInt());
		scanner.nextLine();  

		System.out.println("Enter noOfFaculty");
		school.setNoOfFaculty(scanner.nextInt());
		scanner.nextLine();  

		schoolRepository.addSchool(school);

		return "Data saved successfully";
	}

	public School findSchoolById() {
		System.out.println("enter School Id");
		int schoolId=scanner.nextInt();
		return schoolRepository.findSchoolById(schoolId);

	}

	public School findSchoolBySchoolName() {
		System.out.println("enter SchoolName");
		String schoolName = scanner.nextLine();
		return schoolRepository.findSchoolBySchoolName(schoolName);
	}

	public List<School> findAllSchoolByCity() {
		System.out.println("Enter City");
		String city = scanner.nextLine();
		return schoolRepository.findAllSchoolByCity(city);
	}
	public List<School> findAllSchoolByBoard() {
		System.out.println("Enter Board");
		String board = scanner.nextLine();
		return schoolRepository.findAllSchoolByBoard(board);
	}
	public void updateNoOfStudentsById() {
		System.out.println("Enter School Id");
		int schoolId = scanner.nextInt();
		System.out.println("Enter New No of Students");
		int noOfStudents = scanner.nextInt();
		schoolRepository.updateNoOfStudentsById(schoolId, noOfStudents);
	}
	public void updateLocationByName() {
		System.out.println("Enter School Name");
		String schoolName = scanner.nextLine();
		System.out.println("Enter New Location");
		String newLocation = scanner.nextLine();
		schoolRepository.updateLocationByName(schoolName, newLocation);
	}
	public void deleteSchoolBySchoolName() {
		System.out.println("Enter School Name to Delete");
		String schoolName = scanner.nextLine();
		schoolRepository.deleteSchoolBySchoolName(schoolName);
	}
	public void deleteAllSchoolsByLocation() {
		System.out.println("Enter Location to Delete All Schools");
		String location = scanner.nextLine();
		schoolRepository.deleteAllSchoolsByLocation(location);
	}
	public void deleteAllSchoolsWhereNoOfStudentsLessThan() {
		System.out.println("Enter Student Limit");
		int limit = scanner.nextInt();
		schoolRepository.deleteAllSchoolsWhereNoOfStudentsLessThan(limit);
	}

}
