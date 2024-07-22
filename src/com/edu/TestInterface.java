package com.edu;

public interface TestInterface {
	public abstract int add();

	public default int minus() {
		return 0;
	}
}
