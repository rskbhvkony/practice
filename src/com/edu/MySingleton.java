package com.edu;

/**
 * https://github.com/Neelesh-Janga/23-Java-Design-Patterns/blob/main/src/com/neelesh/design/patterns/creational/singleton/SingletonTest.java
 * https://gist.github.com/aritraroy/76300e7fb5582e8a79e93ba3b48e193d
 */
public class MySingleton  {

	private static MySingleton INSTANCE;

	private MySingleton() {
		if (INSTANCE != null) {
            throw new RuntimeException("Cannot instantiate single object using constructor. Use its #getInstance() method");
        }
	}

	public static MySingleton getInstance() {
		if (INSTANCE == null) {
            synchronized (MySingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MySingleton();
                }
            }
        }
        return INSTANCE;
	}

	protected Object readResolve() {
	        return INSTANCE;
	}

	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
