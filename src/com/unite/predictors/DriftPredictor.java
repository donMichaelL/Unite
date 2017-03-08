package com.unite.predictors;

public class DriftPredictor extends AbstractPredictor {

    DriftPredictor(double[] data){
    	super(data);
    }

    /**
     * throws NullPointerException
     */
	public double getResult() {
		double parameter;
		if(size()>1) {
			parameter=(data[size()-1]-data[0])/(size());
		} else {
			parameter=0;
		}
		return (parameter * (size()+1)) + data[0];
	}
}
