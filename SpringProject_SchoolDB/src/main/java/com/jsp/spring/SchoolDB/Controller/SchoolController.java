package com.jsp.spring.SchoolDB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jsp.spring.SchoolDB.entity.School;
import com.jsp.spring.SchoolDB.service.SchoolService;

import java.util.List;

@Controller
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    
    public String addSchool() {
        return schoolService.addSchool();
    }


    public School findSchoolById() {
        return schoolService.findSchoolById();
    }

   
    public School findSchoolBySchoolName() {
        return schoolService.findSchoolBySchoolName();
    }

    public List<School> findAllSchoolByCity() {
        return schoolService.findAllSchoolByCity();
    }

    
    public List<School> findAllSchoolByBoard() {
        return schoolService.findAllSchoolByBoard();
    }

    
    public void updateNoOfStudentsById() {
        schoolService.updateNoOfStudentsById();
    }

    
    public void updateLocationByName() {
        schoolService.updateLocationByName();
    }

    public void deleteSchoolBySchoolName() {
        schoolService.deleteSchoolBySchoolName();
    }

   
    public void deleteAllSchoolsByLocation() {
        schoolService.deleteAllSchoolsByLocation();
    }

   
    public void deleteAllSchoolsWhereNoOfStudentsLessThan() {
        schoolService.deleteAllSchoolsWhereNoOfStudentsLessThan();
    }
}
