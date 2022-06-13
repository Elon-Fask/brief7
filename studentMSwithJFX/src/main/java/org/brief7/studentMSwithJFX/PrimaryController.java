package org.brief7.studentMSwithJFX;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PrimaryController {
	
		@FXML
		private TextField firstname;
		@FXML
		private TextField lastname;
		@FXML
		private TextField idstudent;
		/*
		 * @FXML private TextField salary;
		 */
		
		@FXML
		private Label lavel;
		
		@FXML
		private TableView<student> table;
		
		@FXML
		private TableColumn<student, Integer> eid;
		@FXML
		private TableColumn<student, String> name;
		@FXML
		private TableColumn<student, String> department;
		@FXML
		private TableColumn<student, String> salary1;
		@FXML
		private TableColumn<student, String> mobile;
		
		@FXML 
		private TextField id;
		
		
		student emp;
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		// create table employee ( id number,name varchar2(15),department varchar2(15),mobileNo varchar2(10),salary number);
		public void register(ActionEvent ae){
			
			emp=new student(0, null, null, null, null, null);
			emp.setFName(firstname.getText());
			emp.setLName(lastname.getText());
			/* emp.setIdStudent(id.getText()); */
			//emp.setSalary(Float.parseFloat(salary.getText()));
			
			/*if(emp.getMobileNo().length()<10 || emp.getMobileNo().length()>10){
				lavel.setText("please enter correct mobile No");
				return;
			}*/
			
			try {
				con=ConnectDB.getConnection();
				String sql="insert into students(id_student, fname, lname, email, adresse, contact) Values (?,?,?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1,emp.getIdStudent());
				pstmt.setString(2,emp.getFName());
				pstmt.setString(3,emp.getLName());
				/*
				 * pstmt.setString(4,emp.getEmail()); 
				 * pstmt.setString(5, emp.getAdresse());
				 * pstmt.setString(6, emp.getContact());
				 */
				
				rs=pstmt.executeQuery();
				if(rs.next()){
					lavel.setText("Register Sucessfully.");
					eid.setCellValueFactory(new PropertyValueFactory<student, Integer>("eid"));
					name.setCellValueFactory(new PropertyValueFactory<student, String>("name"));
					department.setCellValueFactory(new PropertyValueFactory<student, String>("department"));
					salary1.setCellValueFactory(new PropertyValueFactory<student, String>("salary1"));
					mobile.setCellValueFactory(new PropertyValueFactory<student, String>("mobile"));
					ObservableList<student> data = FXCollections.observableArrayList(
					         new student(101,emp.getFName(),emp.getLName(), emp.getAdresse(), emp.getEmail(), emp.getContact())
					);
						
					table.getItems().addAll(data);

					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println(emp.getContact()+"...........");
		}
		public void showAll(ActionEvent ae){
			try {
				con =ConnectDB.getConnection();
				String sql="select * from employee";
				pstmt=con.prepareStatement(sql);
				
				rs=pstmt.executeQuery();
				while(rs.next()){
					eid.setCellValueFactory(new PropertyValueFactory<student, Integer>("idStudent"));
					name.setCellValueFactory(new PropertyValueFactory<student, String>("firstName"));
					department.setCellValueFactory(new PropertyValueFactory<student, String>("lastName"));
					salary1.setCellValueFactory(new PropertyValueFactory<student, String>("email"));
					mobile.setCellValueFactory(new PropertyValueFactory<student, String>("adresse"));
					ObservableList<student> data = FXCollections.observableArrayList(
					         new student(rs.getInt("idStudent"),rs.getString("firstName"),rs.getString("lastName"),rs.getString("email"),rs.getString("adresse"),rs.getString(0))
					);
					table.getItems().addAll(data);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void deleteEmployee(ActionEvent ae){
			try {
				con =ConnectDB.getConnection();
				String sql="delete from student where id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(id.getText()));
				rs=pstmt.executeQuery();
				if(rs!=null){
					lavel.setText("Record deleted ");
				}else{
					lavel.setText("please check employee id");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		public void update(ActionEvent ae) throws IOException{
			Stage primaryStage= new Stage();
			Parent root =FXMLLoader.load(getClass().getResource("/application/Update.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource(arg0))
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
}