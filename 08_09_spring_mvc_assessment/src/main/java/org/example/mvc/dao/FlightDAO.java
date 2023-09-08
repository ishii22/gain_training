package org.example.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.example.mvc.entity.Flight;
import org.springframework.stereotype.Repository;

@Repository
public class FlightDAO {

	private static String url = "jdbc:mysql://localhost:3306/gainsight";
	
	public ArrayList<Flight> findFlightBySourceDestination(String source, String destination) {
//		int count = 0;
		ArrayList<Flight> flist = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","G@1nsight");
			pst = con.prepareStatement("select * from flight where source = ? and destination = ?");
			pst.setString(1,source);
			pst.setString(2, destination);
			rs = pst.executeQuery();
			while(rs.next())
				flist.add(new Flight(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5)));
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
		return flist;
//		return count==1;
	}
}
