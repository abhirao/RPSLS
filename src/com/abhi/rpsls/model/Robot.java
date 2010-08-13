package com.abhi.rpsls.model;

import java.util.Random;


public class Robot 
{
	private static final String[] choices = {"Rock","Paper","Scissors","Lizard","Spock"};
	
	
	public String Choice()
	{
		Random generator = new Random();
		
		int pickIndex = generator.nextInt(4); 
		
		return choices[pickIndex];
	}
	

}
