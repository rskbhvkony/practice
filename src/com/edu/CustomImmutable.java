package com.edu;

public final class CustomImmutable {
	private final String s1;

	CustomImmutable(String s) {
		this.s1 = s;
	}
	
	public String getS1() {
		return s1;
	}
}
