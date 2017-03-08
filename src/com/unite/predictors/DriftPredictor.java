package com.unite.predictors;

public class DriftPredictor extends AbstractPredictor {
	private static int MINIMUM_TABLE_SIZE = 1;
	
    DriftPredictor(double[] data){
    	super(data);
    }

    /**
     * throws NullPointerException
     */
	public double getResult() {
		double parameter;
		if(size()>MINIMUM_TABLE_SIZE) {
			parameter=(data[size()-1]-data[0])/(size());
		} else {
			parameter=0;
		}
		return (parameter * (size()+1)) + data[0];
	}
}
