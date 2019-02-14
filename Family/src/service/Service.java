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
	private Statement st, st1;
	private ResultSet rs, rs1;
	private List list;
	private People pp;
	
	public List getList() {
		list = new ArrayList();
		
		dbconnection = JdbcConnection.getConnection();
		try {
			st = dbconnection.createStatement();
			String sql = "select * from peoples";
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
	
	public void addRecord(Object params) {
		dbconnection = JdbcConnection.getConnection();
		try {
			st1 = dbconnection.createStatement();
			String sql="insert into peoples(name, gender, birthday, phone_number, id_card_number) values(params.name, params.gender, params.birthday, params.phone, params.idCard)"; 
			rs1 = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
