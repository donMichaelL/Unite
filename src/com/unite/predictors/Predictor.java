package com.unite.predictors;

public abstract interface Predictor {
	
	void initialize(double[] a);
	
	double getResult();
}
