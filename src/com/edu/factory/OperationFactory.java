package com.edu.factory;

public interface OperationFactory {

	    Operation getInstance(String animal) throws InvalidOperationException;
}
