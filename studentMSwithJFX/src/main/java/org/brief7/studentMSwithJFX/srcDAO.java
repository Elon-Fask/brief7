package org.brief7.studentMSwithJFX;

import java.util.List;

public interface srcDAO {

	
	public abstract void createStudent(student student);
	public abstract student getStudentById(String IdStudent);
	public abstract student updateByName(String fName, String lName);
	public abstract void updateStudentEmailById(String newEmail,String idStudent);
	public abstract void deleteStudentById(Integer IdStudent);
	public abstract List<student> getAllStudentInfo();
	public abstract List<student> showAll();
}
