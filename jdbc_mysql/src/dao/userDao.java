package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBhelper;

public class userDao {
	
		//查询all
		public List<User> list(){
			List<User> users = new ArrayList<User>();
			String sql = "select * from user";
			try {
				Connection conn = DBhelper.getConnection();	//获得连接对象
				PreparedStatement ps = conn.prepareStatement(sql);
		         ResultSet rs = ps.executeQuery(sql);
		         while(rs.next()){
		        	 User user = new User();
		        	 int id = rs.getInt(1);
		        	 String username = rs.getString(2);
		        	 String password = rs.getString(3);
		        	 String phone = rs.getString(4);
		        	 String email = rs.getString(5);
		        	 String sex = rs.getString(6);
		        	 user.setId(id);
		        	 user.setUsername(username);
		        	 user.setPassword(password);
		        	 user.setPhone(phone);
		        	 user.setEmail(email);
		        	 user.setSex(sex);
		        	 users.add(user);
		         }
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return users;
		}
		
		//通过id查询用户
		public User list(String id)
		{
			User user = new User();
			String sql = "select * from user where id="+id;
			try {
				Connection conn=DBhelper.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					user.setId(rs.getInt(1));
					user.setUsername(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setPhone(rs.getString(4));
					user.setEmail(rs.getString(5));
					user.setSex(rs.getString(6));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
		
	//添加用户
	public void addUser(User user){
		
		String sql="insert into user values(null,?,?,?,?,?);";
		try {
			Connection conn = DBhelper.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getPhone());
			ps.setString(4,user.getEmail());
			ps.setString(5,user.getSex());
			ps.execute();
			
		/*	 ResultSet rs = ps.getGeneratedKeys();
	            if (rs.next()) {
	                int id = rs.getInt(1);
	                user.setId(id);
	            }*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	//根据id删除记录
	public boolean deleteUser(String id){
		boolean result = false;
		try {
			Connection conn = DBhelper.getConnection();
			String sql="delete from user where id=?";
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, id);
			result=ptmt.execute();
			//System.out.println(result); //execute()返回的是false....
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//更新
	public void updataUser(String id,User user){
		String sql="update user set username=?,password=?,phone=?,email=?,sex=? where id=?";
		try {
			Connection conn=DBhelper.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getSex());
			ps.setString(6, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		
	//分页查询
	public List<User> list(int start,int count){
		List<User> users = new ArrayList<User>();
		String sql = "select * from user order by id desc limit ?,? ";
		
		try {
			Connection conn = DBhelper.getConnection();	//获得连接对象
			PreparedStatement ps = conn.prepareStatement(sql);
			
			 ps.setInt(1, start);
	         ps.setInt(2, count);
	         
	         ResultSet rs = ps.executeQuery(sql);
	         
	         while(rs.next()){
	        	 User user = new User();
	        	 int id = rs.getInt(1);
	        	 String username = rs.getString(2);
	        	 String password = rs.getString(3);
	        	 String phone = rs.getString(4);
	        	 String email = rs.getString(5);
	        	 String sex = rs.getString(6);
	        	 
	        	 user.setId(id);
	        	 user.setUsername(username);
	        	 user.setPassword(password);
	        	 user.setPhone(phone);
	        	 user.setEmail(email);
	        	 user.setSex(sex);
	        	 
	        	 users.add(user);
	         }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
}
