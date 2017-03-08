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
    	if (period==0)throw new IllegalArgumentException();
    	//TODO 
    	if (size()==1) return data[size()-1];
    	
    	double total=0;
    	for(int i=(size()-1);i>(size()-period-1);--i){
    		total += data[i];
    	}
    	return Math.round(total/period);
    }  
}
