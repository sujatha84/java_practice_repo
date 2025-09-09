package com.jp_repo.dp.creational.singleton;

public class SingletonDP {
	
	/** Creational DP focus on the process of creating objects. They aim to enhance 
	flexibility and efficiency in object creation, allowing systems to remain 
	independent of how their objects are constructed, composed, and represented. 
	This approach helps streamline the instantiation process and can lead to more 
	maintainable and adaptable code **/
	
	/**The Singleton design pattern is a creational design pattern that ensures a class
    has only one instance and provides a global point of access to that instance. 
    This pattern is particularly useful when exactly one object is needed to coordinate
    actions across the system, such as a logger, a configuration manager, or a database
    connection pool. **/
	
	/** 
	Singleton Design Pattern:
	A class implemented with the Singleton pattern typically ensures that only one instance
	of that class exists per ClassLoader (and thus, usually per Java Virtual Machine - JVM). This is enforced by the 
	class itself, often through a private constructor and a static getInstance() method.
	Spring Singleton Bean:
	A Spring singleton bean ensures that only one instance of that bean exists per 
	Spring ApplicationContext. If multiple Spring ApplicationContexts are running within 
	the same JVM, each context will have its own singleton instance of the same bean.**/
	
	static {
		System.out.println("singletonDP class loaded");
	}
	
	//A private static variable within the class holds the single instance of the class.
	private static SingletonDP SINGLETON_DP_INSTANCE;
	
	// Private constructor to prevent direct instantiation
	private SingletonDP()
	{
		 // Initialization logic if needed
	}
	
    // Public static method to get the single instance
	public static SingletonDP getInstance() {					 
		 
		if(SINGLETON_DP_INSTANCE == null) {
			
			try { Thread.sleep(100); } catch (InterruptedException e) { // TODO Auto-generated catch block 
				 e.printStackTrace(); 
			 }
			
			SINGLETON_DP_INSTANCE = new SingletonDP();
		}
		return SINGLETON_DP_INSTANCE;		
	}
	
	// Other methods of the Singleton class
    public void showMessage() {
        System.out.println("Hello from the Singleton!");
    }

}
