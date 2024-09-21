package com.jsp.spring.SchoolDB.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class School {

	@Id
	private int schoolId;
	private String schoolName;
	private String location;
	private String city;
	private String board;
	private int noOfFaculty;
	private int noOfStudent;
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public int getNoOfFaculty() {
		return noOfFaculty;
	}
	public void setNoOfFaculty(int noOfFaculty) {
		this.noOfFaculty = noOfFaculty;
	}
	public int getNoOfStudent() {
		return noOfStudent;
	}
	public void setNoOfStudent(int noOfStudent) {
		this.noOfStudent = noOfStudent;
	}
	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + ", location=" + location + ", city="
				+ city + ", board=" + board + ", noOfFaculty=" + noOfFaculty + ", noOfStudent=" + noOfStudent + "]";
	}
	
}
