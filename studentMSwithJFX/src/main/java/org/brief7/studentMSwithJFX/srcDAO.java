package org.brief7.studentMSwithJFX;

import java.util.List;

public interface srcDAO {

	
	public abstract void createStudent(student student);
	public abstract student getStudentById(Integer IdStudent);
	public abstract student updateByName(String fName, String lName);
	public abstract void updateStudentEmailById(String newEmail,Integer Student);
	public abstract void deleteStudentById(Integer IdStudent);
	public abstract List<student> getAllStudentInfo();
}
