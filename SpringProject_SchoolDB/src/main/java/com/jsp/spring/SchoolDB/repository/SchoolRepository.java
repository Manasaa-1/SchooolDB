package com.jsp.spring.SchoolDB.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jsp.spring.SchoolDB.entity.School;

@Repository
public class SchoolRepository {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
	
	public void addSchool(School school) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		em.persist(school);;

		et.commit();
		em.close();
	}
	
	public School findSchoolById(int SchoolId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		School school =em.find(School.class,SchoolId);
		et.commit();
		em.close();
		return school;
		
	}

	

	public School findSchoolBySchoolName(String schoolName) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		School school =em.createQuery("SELECT s FROM School s WHERE s.schoolName = :name", School.class)
                .setParameter("name", schoolName)
                .getSingleResult();
		et.commit();
		em.close();
		return school;
	}

	

	public List<School> findAllSchoolByCity(String city) {
	    EntityManager em = emf.createEntityManager();
	    List<School> schools = em.createQuery("SELECT s FROM School s WHERE s.city = :city", School.class)
	                             .setParameter("city", city)
	                             .getResultList();
	    em.close();
	    return schools;
	}

	public List<School> findAllSchoolByBoard(String board) {
	    EntityManager em = emf.createEntityManager();
	    List<School> schools = em.createQuery("SELECT s FROM School s WHERE s.board = :board", School.class)
	                             .setParameter("board", board)
	                             .getResultList();
	    em.close();
	    return schools;
	}

	public void updateNoOfStudentsById(int id, int noOfStudents) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    et.begin();
	    School school = em.find(School.class, id);
	    school.setNoOfStudent(noOfStudents);
	    et.commit();
	    em.close();
	}

	public void updateLocationByName(String name, String newLocation) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    et.begin();
	    School school = em.createQuery("SELECT s FROM School s WHERE s.schoolName = :name", School.class)
	                      .setParameter("name", name)
	                      .getSingleResult();
	    school.setLocation(newLocation);
	    et.commit();
	    em.close();
	}
	public void deleteSchoolBySchoolName(String name) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    et.begin();
	    School school = em.createQuery("SELECT s FROM School s WHERE s.schoolName = :name", School.class)
	                      .setParameter("name", name)
	                      .getSingleResult();
	    em.remove(school);
	    et.commit();
	    em.close();
	}

	public void deleteAllSchoolsByLocation(String location) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    et.begin();
	    em.createQuery("DELETE FROM School s WHERE s.location = :location")
	      .setParameter("location", location)
	      .executeUpdate();
	    et.commit();
	    em.close();
	}

	public void deleteAllSchoolsWhereNoOfStudentsLessThan(int limit) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    et.begin();
	    em.createQuery("DELETE FROM School s WHERE s.noOfStudent < :limit")
	      .setParameter("limit", limit)
	      .executeUpdate();
	    et.commit();
	    em.close();
	}

	
}