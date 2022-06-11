package org.brief5.DB;

import java.sql.*;


public class connectDB {

	public static void main(String[] args) {

		connectDB obj_cnx = new connectDB();
		System.out.println(obj_cnx.get_cnx());
	}

	public Connection get_cnx() {

		Connection cn = null;

		try {

			Class.forName("org.postgresql.Driver");
			cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentDB", "postgres", "20040201Aatman*");
			if (cn != null) {

				System.out.println("working");
			} else {
				System.out.println("not working");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cn;
	}
}
