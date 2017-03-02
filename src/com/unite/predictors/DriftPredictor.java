package com.unite.predictors;

public class DriftPredictor implements Predictor {
	private double[] data;
    
    public void initialize(double[] a) {
    	data=a;
	}

	public double getResult() {
		if (data==null) return 0;
		double sum=0;
		double a,b;
		int length=data.length;
		if(length>0)	{
			a=(data[length-1]-data[0])/(length);
		} else {
			a=0;
		}
		b=data[0];
		length++;
		sum=a*length+b;
		return sum;
	}
}
