package net.javaguides.springboot.controller;	

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;


@CrossOrigin(origins =  "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private UserRepository userrepository;
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	
	@GetMapping("/alluser")
	public List<User> getUserList(){
		log.debug("inside getUserList method");
		//return ResponseEntity.ok().body(userservice.getUserList());
		return userrepository.findAll();
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody  User user){
		log.debug("inside addUser method");
		return ResponseEntity.ok().body(this.userservice.addUser(user));
		//return userrepository.save(user);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		log.debug("inside getUserByID method");
		return ResponseEntity.ok().body(userservice.getUserById(id));
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> UpdateUserByID(@PathVariable int id, @RequestBody User user){
		log.debug("inside UpdateUserByID method");
		//userservice.getUserById(id);
		//userservice.updateUser(user);
		//user.setId(id);
		return ResponseEntity.ok().body(this.userservice.updateUser(user));
	}
	
	@DeleteMapping("/user/{id}")
	public HttpStatus deleteUser(@PathVariable int id){
		log.debug("inside deleteUser method");
		this.userservice.deleteUserById(id);
		return HttpStatus.OK;
	}
	

}
