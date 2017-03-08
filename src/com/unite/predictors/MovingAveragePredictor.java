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
    	//TODO negative check second if
    	if (period==0) throw new IllegalArgumentException();
    	if (size()==1) return data[size()-1];
    	
    	double total=0;
    	for(int i=(size()-1);i>(size()-period-1);--i){
    		total += data[i];
    	}
    	return total/period;
    }
}
