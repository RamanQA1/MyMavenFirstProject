package com.google.search;

import org.testng.annotations.Test;

public class LoginPage_2 {
	@Test(dataProvider = "Cred",dataProviderClass = ExcelDataSupllier.class)
	public void login(String username, String password) {
		
		System.out.println("Username:" +username+ "Password:" +password);
		
//		// reading .xlsx file using the data provider mentioned at the top of the test
//		// and printing the data of the .xlsx file
//		System.out.println("Stations are : " + stations);
//
//		// comparing the expected list and the list of stations from the input "FROM"
//		// field
//		for (String station : stations) {
//			if (fromInputFieldElements.contains(station))
//				System.out.println("Station Found : " + station);
//		}

		// calculating date from one month from current data
//		Calendar cal = Calendar.getInstance(); 
//		cal.add(Calendar.MONTH, 1);
//		
//		int month = cal.get(Calendar.MONTH) + 1;
//		int day = cal.get(Calendar.DAY_OF_MONTH) + 1;
//		int year = cal.get(Calendar.YEAR) + 1;

	}

}
