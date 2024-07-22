package com.synchron;

public interface Inter {
	
	default void stream() {
		System.out.println("Hi");
	}
	
	default void stream2() {
		System.out.println("Hi");
	}
	
	static void stream3() {
		System.out.println("Hi");
	}
	
	static void stream4() {
		System.out.println("Hi");
	}
   
	void m1();
	void m2();
}
