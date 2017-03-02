package com.unite.predictors;

public class ExtrapolationPredictor implements Predictor{
	private double[] data;
	
	public void initialize(double[] a) {
		data = a;
	}
	
	public double getResult() {
		if (data.length >= 2) 
			return (2.0 * data[data.length - 1] - data[data.length - 2]);
		else
			return data[data.length - 1];
	}
}
