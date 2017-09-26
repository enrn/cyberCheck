package com.singleton.example;

public class Singleton {
	
	//create the singleton object whenever class loads
	private static Singleton singleton=new Singleton();
	
	//create private constructor ..which is not accessible to other
	private Singleton(){
		
		System.out.println("creating singleton..");
	}
	//declare a global access to the object
	public static Singleton getInstance(){
		
		return singleton;
		
	}
	
	

}
