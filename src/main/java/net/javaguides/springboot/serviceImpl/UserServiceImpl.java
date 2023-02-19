package net.javaguides.springboot.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userrepository;
	
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	
	@Override
	public List<User> getUserList(){
		log.debug("inside getUserList method");
		return this.userrepository.findAll();
	}
	
	@Override
	public User getUserById(int id){
		log.debug("inside getUserByID method");
		Optional<User> UserDB = this.userrepository.findById(id);
		
		if(UserDB.isPresent()) {
			return UserDB.get();
		}else {
			throw new ResourceNotFoundException("Record not Found with id : " + id);
		}
		
	}
	
	@Override
	public User addUser(User user) {
		log.debug("inside addUser method");
		user.setId(user.getId());
		user.setFirstName(user.getFirstName());
		user.setLastName(user.getLastName());
		user.setDesignation(user.getDesignation());
		user.setCity(user.getCity());
		//user.setCreatedAt();
		return userrepository.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		log.debug("inside UpdateUser method");
		Optional<User> UserDB = this.userrepository.findById(user.getId());
		
		if(UserDB.isPresent()) {
			Date date=new Date();
			User userupdate = UserDB.get();
			//userupdate.setId(user.getId());
			userupdate.setDesignation(user.getDesignation());
			userupdate.setFirstName(user.getFirstName());
			userupdate.setLastName(user.getLastName());
			userupdate.setCity(user.getCity());
			userupdate.setUpdatedAt(date);
			userrepository.save(userupdate);
			return userupdate;
		}else {
			throw new ResourceNotFoundException("Record not Found with id"+user.getId());
		}
	}
	
	@Override
	public void deleteUserById(int id) {
		log.debug("inside deleteUserByID method");
		
		Optional<User> UserDB = this.userrepository.findById(id);
		
		if(UserDB.isPresent()) {
			this.userrepository.delete(UserDB.get());
		}else {
			throw new ResourceNotFoundException("Record not Found with id : " +id);
		}
		
	}
	
}