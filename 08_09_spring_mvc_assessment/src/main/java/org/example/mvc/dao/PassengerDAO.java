package org.example.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.example.mvc.entity.Passengers;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerDAO {
	
private static String url = "jdbc:mysql://localhost:3306/gainsight";
	
	public boolean addPassengerDetails(Passengers passenger) {
		int count = 0;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","G@1nsight");
			pst = con.prepareStatement("insert into passengers values(?,?,?,?,?)");
			pst.setString(1, passenger.getPassengerId());
			pst.setString(2, passenger.getFirstName());
			pst.setString(3, passenger.getLastName());
			pst.setLong(4, passenger.getMobile());
			pst.setString(5, passenger.getEmail());
			
			count = pst.executeUpdate();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return count == 1;
	}

}
