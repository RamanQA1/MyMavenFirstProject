package com.google.search;

import java.util.LinkedHashSet;

public class Code {

	public static void main(String[] args) {
		
		int a[]= {4,6,3,4,7,10,26,38};
		int max=a[0];
		int min=a[0];
		
		for (int i = 1; i < a.length; i++) {
			if(a[i]>max) {
				max=a[i];
			}
			
			if(a[i]<min) {
				min=a[i];
			}
			
		}
	System.out.println(max-min);
	}
		
		
	}

