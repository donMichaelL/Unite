package com.unite.predictors;


public class RoundedAveragePredictor extends AbstractPredictor {
	private  int period;

	RoundedAveragePredictor(double[] data, int period) {
		super(data);
    	if (period>size())	{this.period=size();}
    	else {this.period = period;}
	}
	    
    /**
     * Iterating to the last period elements of the table
     * @return double moving average predictor
     * throws NullPointerException
     * throws IllegalArgumentException
     */
    public double getResult() {
    	return Math.round(super.calculateAverage(data, period));
    }  
}
