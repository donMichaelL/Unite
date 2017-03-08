package com.unite.predictors;

public class DriftPredictor extends AbstractPredictor {
	private static int MINIMUM_TABLE_SIZE = 2;
	
    DriftPredictor(double[] data){
    	super(data);
    }

    /**
     * throws NullPointerException
     */
	public double getResult() {
		double parameter;
		if(size() < MINIMUM_TABLE_SIZE) 
			throw new IllegalArgumentException();
		parameter=(data[size()-1]-data[0])/(size());
		return (parameter * (size()+1)) + data[0];
	}
}
