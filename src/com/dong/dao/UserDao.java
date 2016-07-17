package com.dong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dong.db.DBUtil;
import com.dong.model.User;

public class UserDao {
	public void addUser(User user) throws Exception{
	Connection conn = DBUtil.getConnection();
	String sql = "insert into user (user_id,username,password)"
			+"values(?,?,?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1, user.getUser_id());
	ps.setString(2,user.getUsername());
	ps.setString(3, user.getPassword());
	ps.execute();
	}
	
	public void deleteUser(int id) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = " delete from user "
				+" where user_id=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
	}

	
	public void updateUser(User user) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql =" update user set username=?,password=? "
				 +" where user_id=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setInt(3, user.getUser_id());
		ps.execute();
	}
	
	public List<User> query() throws Exception{
		Connection conn = DBUtil.getConnection();
		Statement st = conn.createStatement();
		ResultSet res = st.executeQuery("select * from user");
		List<User> test = new ArrayList<User>();
		User u = null;
		while(res.next()){
			u = new User();
			u.setUser_id(res.getInt(1));
			u.setUsername(res.getString(2));
			u.setPassword(res.getString(3));
			test.add(u);
		}
		return test;
	}
	
	public User get(int id) throws Exception{
		Connection conn = DBUtil.getConnection();
		String sql = " delete from user "
				+" where user_id=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		User user = null;
		ResultSet res = ps.executeQuery();
		while(res.next()){
			user = new User();
			user.setUser_id(id);
			user.setUsername(res.getString(2));
			user.setPassword(res.getString(3));
		}
		return user;
	}
}
