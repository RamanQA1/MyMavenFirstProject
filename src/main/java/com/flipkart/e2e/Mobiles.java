package com.flipkart.e2e;

import org.testng.annotations.Test;

public class Mobiles {
	
	@Test(priority=1,description="Signin with valid Credential",groups={"Sanity","Regression","e2e"})
	public void Singup() {
		System.out.println("signup with valid Credential");
	}
	
	@Test(priority=2,description="Signin with valid Credential",groups={"Sanity","Regression","e2e"})
	public void signIn() {
		System.out.println("SingIn with valid Credential");
	}
	
	@Test(priority=3,description="Searching Apple mobile",groups={"Regression","e2e"})
	public void searchProducts() {
		System.out.println("Searching Apple moblie");
	}
	
	@Test(priority=4,groups={"Regression","e2e"})
	public void apple14ProMax() {
		System.out.println("Selecting Apple 14 pro Max ");
	}
	
	@Test(priority=5,groups={"Sanity","Regression","e2e"})
	public void addToCart() {
		System.out.println("Adding Apple 14 pro Max ");
	}
	
	@Test(priority=6,groups={"Regression","e2e"})
	public void addShippingDetails() {
		System.out.println("Filling Shipping details for Dilevery");
	}
	
	@Test(priority=7,groups={"Sanity","Regression","e2e"})
	public void makePayment() {
		System.out.println("Paying Amount through Credit Card");
	}
	
	@Test(priority=8,groups={"Regression","e2e"})
	public void orderPlaced() {
		System.out.println("After Successful Order Tracking Item");
	}
	@Test(priority=9,groups={"Regression","e2e"})
	public void returnOrder() {
		System.out.println("Order Return by Custumer");
	}
	@Test(priority=10,groups={"Regression","e2e"})
	public void replaceOrder() {
		System.out.println("Order Replaced By the Custumer");
	}
	@Test(priority=11,enabled=true,groups={"Regression","e2e"})
	public void custumerFeedback() {
		System.out.println("Custumer Feedback Response");
	}
	
	@Test
	public void checkout() {
		
		System.out.println("checkout details of customers");
	}
	

}
