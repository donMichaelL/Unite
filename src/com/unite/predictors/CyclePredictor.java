package com.unite.predictors;

public class CyclePredictor implements Predictor{
	private double[] data;
	private int period;
	
	public CyclePredictor(int period) {
		this.period = period;
	}
	
	public void initialize(double[] a) {
		data = a;
	}
	
	public double getResult() {
		if (data==null)
			return 0;
		if (data.length - period >= 0)
			return data[data.length - period];
		else if (data.length - 1 >= 0)
			return data[data.length - 1];
		else
			return 0.0;
	}
}
