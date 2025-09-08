package com.jp_repo.dp.creational.singleton;

public class SingletonMain  implements Runnable{
	
	/** Different ways to create singletone pattern: 
	 * Billpugh - Initialization-on-demand holder
	 * enum - especially for handling serialization and reflection issues. Java enums inherently guarantee a single instance.
	 * Double-Checked Locking (Optimized Lazy Initialization) - reduce the overhead of synchronization by performing a 
	 * 					double-check on the instance variable. The volatile keyword ensures visibility across threads.
	 * Lazy Initialization (Thread-Safe with synchronized method): The instance is created only when the getInstance() 
	 * 							method is called for the first time. The method is synchronized to ensure thread safety.
	 * Eager Initialization (Early Initialization) - The instance is created at the time of class loading, regardless of
								whether it's actually needed.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * SingletonDP singletonDP1 = SingletonDP.getInstance(); SingletonDP
		 * singletonDP2 = SingletonDP.getInstance();
		 * System.out.println(singletonDP1.hashCode());
		 * System.out.println(singletonDP2.hashCode());
		 */
		Sample sample; // class is not loaded as it is not used. its only referenced.
		Sample sample1 = new Sample(); // class is loaded as it is used
		
		// Breaking singleton in multi threading scenario
		Thread t1 = new Thread(new SingletonMain());
		Thread t2 = new Thread(new SingletonMain());
		Thread t3 = new Thread(new SingletonMain());
		Thread t4 = new Thread(new SingletonMain());
		Thread t5 = new Thread(new SingletonMain());
		
		//start() creates a new thread and then calls run() in that new thread, enabling concurrency.
		//run() executes its code within the current thread, without creating a new thread, 
		//and thus does not enable concurrency when called directly.
		t1.start(); t2.start(); t3.start(); t4.start(); t5.start();
		try {
			t1.sleep(100); t2.sleep(104); t3.sleep(101); t4.sleep(102); t5.sleep(103);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//SingletonDP.getInstance();
		System.out.println(Thread.currentThread().getName() + " " + SingletonDP.getInstance().hashCode());
	}

}
