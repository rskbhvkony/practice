package com.edu.factory;

public class OperationFactoryImpl  implements OperationFactory{
	    @Override
	    public Operation getInstance(String animal) throws InvalidOperationException {
	    	String result;
	        switch (animal) {
	            case "DOG":
	            	return new AddOperation();
	                break;
	            case "CAT":
	            	return new MulOperation();
	                break;
	            default:  // should be unreachable!
	                throw new IllegalStateException("Invalid Operation");
	        }
	        return result;
	    }

	    public static void main(String[] args) {
	    // create opeartion instance based on user choice
	   OperationFactory operationFactory = new OperationFactoryImpl();
	    }
	}