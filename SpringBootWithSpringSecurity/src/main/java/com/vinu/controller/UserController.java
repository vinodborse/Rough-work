package com.vinu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vinu.iservice.IUserService;
import com.vinu.model.User;
import com.vinu.response.GenericResponse;


/**
 * @author Vinod Borse
 * 04-Sep-2019
 */
@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/v1/registerUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	  public @ResponseBody GenericResponse registerPatientHandler(
	      @RequestParam("userName") String userName, @RequestParam("firstName") String firstName,
	      @RequestParam("lastName") String lastName, @RequestParam("password") String password) {
		  
		  User userAuth = userService.findByUsername(userName);
		  if(null != userAuth){
			  System.out.println("User Already Exists, cannot register user again");
			  return new GenericResponse("UserName Already Exists, cannot Register User again.");
		  }
	
		  userService.addUser(userName, firstName, lastName, password);
		  return new GenericResponse("User Registered successfully");
	  }
	
	  @RequestMapping(value ="/v1/username", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	  public @ResponseBody User userMasterHandler(@RequestParam String username) {
		  User user = userService.findByUsername(username);
		  return user;
	  }
	  
	  @RequestMapping(value ="/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	  public @ResponseBody GenericResponse test() {
		  return new GenericResponse("THIS IS TEST CASE!!!!!!!!!!!!!!");
	  }

}
