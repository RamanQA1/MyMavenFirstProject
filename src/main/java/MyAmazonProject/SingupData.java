package MyAmazonProject;

import org.testng.annotations.DataProvider;

public class SingupData {
	
	@DataProvider(name="cred")
	public String[][] userdata(){
		
		String[][] users= {{"Raman","raman123","Delhi"},{"Ajay","ajay123","Mumbai"}};
		return users;
		
		
	}
	

}
