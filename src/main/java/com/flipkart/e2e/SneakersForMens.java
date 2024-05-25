package com.flipkart.e2e;

import org.testng.annotations.Test;

public class SneakersForMens {
	
	@Test(priority=1,description="SingUp with valid Credential",groups={"Sanity","Regression","e2e"})
	public void signUp() {
		System.out.println("SingUp with valid Credential");
	}
	
	@Test(priority=2,description="Signin with valid Credential",groups={"Sanity","Regression","e2e"})
	public void signIn() {
		System.out.println("SingIn with valid Credential");
	}
	
	@Test(priority=3,description="Searching Mens Sneakers",groups={"Regression","e2e"})
	public void searchProducts() {
		System.out.println("Searching Mens Sneakers");
	}
	
	@Test(priority=4,groups={"Regression","e2e"})
	public void sneakersForMens() {
		System.out.println("Selecting Adidas White Sneakers");
	}
	
	@Test(priority=5,groups={"Sanity","Regression","e2e"})
	public void addToCart() {
		System.out.println("Adding Adidas White Sneakers to Cart");
	}
	  
	@Test(priority=6,groups={"Regression","e2e"})
	public void addShippingDetails() {
		System.out.println("Filling Shipping details for Dilevery");
	}
	
	@Test(priority=7,groups={"Sanity","Regression","e2e"})
	public void makePayment() throws Exception {
		System.out.println("Paying Amount through Credit Card");
//		throw new Exception("Payment Cancel due to network slowness");
	}
	
	@Test(priority=8,dependsOnMethods="makePayment",groups={"Regression","e2e"})
	public void orderPlaced() {
		System.out.println("After Successful Order Tracking Item");
	}
	@Test(priority=9,dependsOnMethods="makePayment",groups={"Regression","e2e"})
	public void returnOrder() {
		System.out.println("Order Return by Custumer");
	}
	@Test(priority=10,dependsOnMethods="makePayment",groups={"Regression","e2e"})
	public void replaceOrder() {
		System.out.println("Order Replaced By the Custumer");
	}
	@Test(priority=11,groups={"Regression","e2e"})
	public void makePaymentAgain() {
		System.out.println("Make Payment Again by Custumer");
	}

	@Test(priority=12,enabled=true,groups={"Regression","e2e"})
	public void custumerFeedback() {
		System.out.println("Custumer Feedback Response");
	}
	
	
	
	
	
	
	
	

}
