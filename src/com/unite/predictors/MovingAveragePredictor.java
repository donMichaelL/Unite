package com.unite.predictors;


public class MovingAveragePredictor extends AbstractPredictor {
    private int period;
    
    public MovingAveragePredictor(double[] data, int period) {
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
    	return super.calculateAverage(data, period);
    }
}
