package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import beans.People;
import jdbc.JdbcConnection;

public class Service {
	private Connection dbconnection;
	private Statement st;
	private ResultSet rs;
	private int count;
	private List list;
	private People pp;
	
	public int getPageCount() {
		dbconnection = JdbcConnection.getConnection();
        try {
			st = dbconnection.createStatement();
			String sql = "SELECT COUNT(*) FROM peoples";
	        rs = st.executeQuery(sql);
	        rs.next();
	        count = rs.getInt(1);
	        dbconnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(count);
        return count;
	}
	
	public List getList(int pageNo, int pageSize) {
		list = new ArrayList();
		dbconnection = JdbcConnection.getConnection();
		try {
			st = dbconnection.createStatement();
//			String sql = "select * from peoples";
			System.out.println(pageNo);
			System.out.println(pageSize);
			String sql = "SELECT id, name, gender, birthday, phone_number FROM peoples LIMIT " + pageNo + "," + pageSize;
			rs = st.executeQuery(sql);
			
			System.out.println("查询数据列表完成！");
			
			while(rs.next()) {
				pp = new People();
				pp.setId(rs.getInt("id"));
				pp.setName(rs.getString("name"));
				pp.setGender(rs.getInt("gender"));
				pp.setBirthday(rs.getDate("birthday"));
				pp.setPhoneNumber(rs.getString("phone_number"));
//				pp.setIdCardNumber(rs.getString("id_card_number"));
				
				list.add(pp);
			}
//			// key和数据库中存储字段名相同（不可取）
//			ResultSetMetaData md = rs.getMetaData();
//			int columnCount = md.getColumnCount();
//			while (rs.next()) {
//				Map<String,Object> rowData = new HashMap<String,Object>();
//				for (int i = 1; i <= columnCount; i++) {
//					rowData.put(md.getColumnName(i), rs.getObject(i));
//				}
//				list.add(rowData);
//			}

			dbconnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addRecord(JSONObject json) {
		dbconnection = JdbcConnection.getConnection();
		try {
//			System.out.println(json);
			String name = json.getString("name");
			String gender = json.getString("gender");
			String birthday = json.getString("birthday");
			String phone = json.getString("phone");
			String idCard = json.getString("idCard");
			
			st = dbconnection.createStatement();
			String sql = "insert into peoples(name, gender, birthday, phone_number, id_card_number) values('" + name + "','" + gender + "','" + birthday + "','" + phone + "','" + idCard + "')";
			st.executeUpdate(sql);
			dbconnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
