package com.jp_repo.dp.creational.singleton;

public class BillPughSingletonDP implements Runnable {
	
	/** Bill Pugh Singleton Implementation (Initialization-on-demand holder idiom):
		This method leverages the Java language's class loading mechanism to achieve lazy initialization and 
		thread safety without explicit synchronization. It's generally considered the most robust and recommended approach.
	 **/
	
	private BillPughSingletonDP(){
		
	}
	
	public BillPughSingletonDP getInstance() {
		return InstanceHolder.INSTANCE;
	}
	
	private static class InstanceHolder{
		private static final BillPughSingletonDP INSTANCE = new BillPughSingletonDP();
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new BillPughSingletonDP());
		Thread t2 = new Thread(new BillPughSingletonDP());
		Thread t3 = new Thread(new BillPughSingletonDP());
		Thread t4 = new Thread(new BillPughSingletonDP());
		Thread t5 = new Thread(new BillPughSingletonDP());
		
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
		System.out.println(Thread.currentThread().getName() + " " + BillPughSingletonDP.InstanceHolder.INSTANCE.hashCode());
	}


}
