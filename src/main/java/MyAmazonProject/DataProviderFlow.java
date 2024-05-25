package MyAmazonProject;

import org.testng.annotations.Test;

public class DataProviderFlow {
	
	@Test(dataProvider ="cred",dataProviderClass = SingupData.class )
	public void signUp(String username, String password,String city) {
		
		System.out.println("Username" +username+ "Password" +password+ "City" +city);
		
		
	}

}
