package com.dong.control;

import java.util.List;

import com.dong.dao.UserDao;
import com.dong.model.User;

public class UserAction {
	
	public void add(User user) throws Exception{
		UserDao dao = new UserDao();
		dao.addUser(user);
	}
	
	public void edit(User user) throws Exception{
		UserDao dao = new UserDao();
		dao.updateUser(user);
	}
	
	public void del(Integer id) throws Exception{
		UserDao dao = new UserDao();
		dao.deleteUser(id);
	}
	
	public List<User> query() throws Exception{
		UserDao dao = new UserDao();
		return dao.query();
	}
	
	public User query(Integer id) throws Exception{
		UserDao dao = new UserDao();
		return dao.get(id);
	}
	
}
