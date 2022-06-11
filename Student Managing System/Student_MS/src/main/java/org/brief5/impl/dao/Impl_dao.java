package org.brief5.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.brief5.dao.srcDAO;
import org.brief5.DB.connectDB;
import org.brief5.studentManagement.student;

public class Impl_dao implements srcDAO{

	@Override
	public List<student> getAllInfo() {
		List<student> studentList= new ArrayList<>();
		connectDB obj_cnx= new connectDB();		
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			cn =obj_cnx.get_cnx();
			// Create Statement
			st = cn.createStatement();
			String sql = "select * from students";
			rs = st.executeQuery(sql);
			// Traversal result set
			while (rs.next()) {
				int idStudent = rs.getInt("idStudent");//id
				String fName = rs.getString("fName");
				String lName = rs.getString("lName");
				String email = rs.getString("email");
				String adresse = rs.getString("adresse");
				String contact = rs.getString("contact");
				
				student student = new student ();
				student.setIdStudent(idStudent);
				student.setFName(fName);
				student.setLName(lName);
				student.setEmail(email);
				student.setAdresse(adresse);
				student.setContact(contact);
				
				studentList.add(student);
				//System.out.println("id: " + id + "\nnom: " + nom + "\nprenom: " + prenom+ "\nmail: "+mail+ "\nadresse: "+adresse+"\nville: "+ville+"\npays: "+pays );
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		return studentList;
	}

	@Override
	public void insert(student nstudent) {
		Connection cn=null;
		connectDB obj_cnx =new connectDB();
        cn =obj_cnx.get_cnx();

        try {
        	 String query = "Insert into students"+ "(fName, lName, email, adresse, contact) values"+" (?, ?, ?, ?, ?);"; 
        	 PreparedStatement preparedStmt = cn.prepareStatement(query);
        	 
     		
        	  preparedStmt.setString (1, nstudent.getFName());
        	  preparedStmt.setString (2, nstudent.getLName());
        	  preparedStmt.setString (3, nstudent.getEmail());
        	  preparedStmt.setString (4, nstudent.getAdresse());
        	  preparedStmt.setString (5, nstudent.getContact());
        	 
        	  System.out.println(preparedStmt);
        	  preparedStmt.executeUpdate();
        	  //cn.close();
        	
        System.out.println ("New Student Added Successfully");
        
        } catch (Exception e) {
        e.printStackTrace ();
        }
	}

	@Override
	public void delete(int idStudent) {
		Connection cn = null;
		connectDB obj_cnx = new connectDB();
		cn = obj_cnx.get_cnx();

		try {
			String query = "delete from students where id_student=?;";
			PreparedStatement preparedStmt = cn.prepareStatement(query);

					
			preparedStmt.setInt(1, idStudent);
			preparedStmt.executeUpdate();
			// cn.close();
			int result = preparedStmt.executeUpdate();
            System.out.println("Number of records affected: " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(int idStudent,String fName,String lName) {
		Connection cn = null;
		connectDB obj_cnx = new connectDB();
		cn = obj_cnx.get_cnx();

		try {
			String query = "Update students set fname =?, lname=? where id_student=?;";
			PreparedStatement preparedStmt = cn.prepareStatement(query);
     		
			preparedStmt.setInt(1, idStudent);
			preparedStmt.setString(2, fName);
			preparedStmt.setString(3, lName);
			preparedStmt.executeUpdate();
			// cn.close();

			System.out.println("Student Updated");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public student getStudentById(int idStudent) {
		student cnd = null;
		String SQL = "SELECT *FROM students WHERE id_student=?";
		Connection cn = null;
		connectDB obj_cnx = new connectDB();
		cn = obj_cnx.get_cnx();
		try(PreparedStatement ps = cn.prepareStatement(SQL)) {
			
			ps.setInt(1, idStudent);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int IdStudent = rs.getInt("id_Student");
				String FName= rs.getString("fName");
				String LName = rs.getString("lName");
				String Email = rs.getString("email");
				String Adresse = rs.getString("adresse");
				String Contact = rs.getString("contact");
				
				cnd = new student();
				cnd.setIdStudent(idStudent);
				cnd.setFName(FName);
				cnd.setLName(LName);
				cnd.setEmail(Email);
				cnd.setAdresse(Adresse);
				cnd.setContact(Contact);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return cnd;
	}

}
