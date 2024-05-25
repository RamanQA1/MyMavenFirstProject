package com.flipkart.e2e;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignupFlow {
	
	@Test(dataProvider="cred")
	public void signup(String username,String password) {
		
		System.out.println("username" +username +   "password" + password);
		
	}
	
	@DataProvider(name="cred")
	public Object[][] userdetails(){
		
		Object[][] users= {{"raman","raman1232"},{"ajaykumar","ajay321"},{"rohanvermasharma","rohan@13142526"}};
		
		return users;
		
	}
	}