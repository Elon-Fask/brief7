package org.brief5.dao;

import java.util.List;
import java.util.Map;

import org.brief5.studentManagement.student;

public interface srcDAO {
	         //Query all
		public abstract List<student> getAllInfo();
			//Add a new candidate
		public abstract void insert(student nstudent);
			//delete a candidate
		public abstract void delete(int idStudent);
			//Update candidate name based on id
		public abstract void update(int idStudent,String fName, String lName);
		   //Get an candidate by id
		public abstract student getStudentById(int idStudent);
}
