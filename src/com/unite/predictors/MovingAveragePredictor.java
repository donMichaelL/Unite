package com.unite.predictors;


public class MovingAveragePredictor extends AbstractPredictor {

    private int period;
    
    public MovingAveragePredictor(double[] data, int period) {
    	super(data);
    	if (period>size())	{this.period=size();}
    	else {this.period = period;}
	}


    public double getResult() {
    	Integer[] dataObject = new Integer[size()];
    	for (int i=0; i<size(); i++){
    		dataObject[i]= (int) data[i];
    	}
    	return MovingAveragePredictor.calculateAlgorithm(dataObject, period);
    }
    
    /**
     * Iterating to the last period elements of the table
     * @return double moving average predictor
     * throws NullPointerException
     * throws IllegalArgumentException
     */
    public static <E extends Number> double calculateAlgorithm(E[] input, int period){
    	if (period<=0) throw new IllegalArgumentException();
    	int size = input.length;
    	if (size==1) return input[size-1].doubleValue();
    	
    	double total= new Double(0);
    	for(int i=(size-1);i>(size-period-1);--i){
    		total += input[i].doubleValue();
    	}
		return  total/period;
    }
    
}
