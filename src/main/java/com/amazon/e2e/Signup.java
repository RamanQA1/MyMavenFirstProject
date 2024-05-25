package com.amazon.e2e;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;





public class Signup {
	
	
	
//	HardCoaded Variable = CHROME browser
//	String browsername = "Chrome";
	
//	Runtime input passes browsers values or Reuseability method..[use this method]
//	Optional is used for only in one class and one test case run..
// optional  
	 
	
	String browsername=null;  
	
	@Parameters("browsername")
	@BeforeClass
   public void beforeClass(@Optional("chrome")String browsername) {
		
		this.browsername=browsername;
	}
	
	
	
	@Test
	public void signup() {
		System.out.println("Singning up with user details"  +browsername);
	}

}
