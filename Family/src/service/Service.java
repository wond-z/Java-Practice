package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.People;
import jdbc.JdbcConnection;

public class Service {
	private Connection dbconnection;
	private Statement st;
	private ResultSet rs;
	private String sql;
	private List list;
	private People pp;
	
	public List getList() {
		list = new ArrayList();
		
		dbconnection = JdbcConnection.getConnection();
		try {
			st = dbconnection.createStatement();
			sql = "select * from peoples";
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				pp = new People();
				pp.setId(rs.getInt("id"));
				pp.setName(rs.getString("name"));
				pp.setGender(rs.getInt("gender"));
				pp.setBirthday(rs.getDate("birthday"));
				pp.setPhoneNumber(rs.getString("phone_number"));
				pp.setIdCardNumber(rs.getString("id_card_number"));
				
				list.add(pp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
