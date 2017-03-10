package com.unite.predictors;

public abstract class AbstractPredictor implements Predictor {
	protected double[] data;
	
	public AbstractPredictor(){
	}
	
	public AbstractPredictor(double[] data) {
		super();
		initialize(data);
	}
	
	public double[] getData() {
		return data;
	}

	public void initialize(double[] a) {
		data = a;
	}
	
	public int size(){
		return data.length;
	}
	
	public static double calculateAverage(double[] data, int period){
		int size = data.length;
    	if (period<=0) throw new IllegalArgumentException();
    	if (size==1) return data[size-1];
    	
    	double total=0;
    	for(int i=(size-1);i>(size-period-1);--i){
    		total += data[i];
    	}
    	return total/period;		
	}
}
