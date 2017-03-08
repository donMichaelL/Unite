package com.unite.predictors;

public abstract class AbstractPredictor implements Predictor {
	protected double[] data;
	
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
}
