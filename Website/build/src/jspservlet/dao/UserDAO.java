package jspservlet.dao;

import jspservlet.vo.User;

public interface UserDAO {
	public int queryByUsername(User user) throws Exception;
	public void addUser(User user) throws Exception;
	public int select(String name) throws Exception;
	public void change(User user)throws Exception;
}
