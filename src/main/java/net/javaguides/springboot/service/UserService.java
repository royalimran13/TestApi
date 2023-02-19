package net.javaguides.springboot.service;

import java.util.List;


import net.javaguides.springboot.model.User;


public interface UserService {
	
	List<User> getUserList();
	
	public User getUserById(int id);
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUserById(int id);
	

}
