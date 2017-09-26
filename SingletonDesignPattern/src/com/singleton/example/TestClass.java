package com.singleton.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestClass {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		
		Singleton s1=Singleton.getInstance();
		Singleton s2=Singleton.getInstance();
		
		System.out.println("s1="+s1.hashCode());

		System.out.println("s2="+s2.hashCode());
		//REflection
		
	Class clazz =	Class.forName("com.singleton.example.Singleton");
	Constructor<Singleton> ctor=clazz.getDeclaredConstructor();
	ctor.setAccessible(true);
	Singleton s3=ctor.newInstance();
	
	System.out.println("s2="+s3.hashCode());
	}
	
	

}
