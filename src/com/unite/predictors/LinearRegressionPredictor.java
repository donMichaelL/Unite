package com.unite.predictors;

import java.text.NumberFormat;

public class LinearRegressionPredictor implements Predictor{
	
	private double[] x;
	private double meanX;
	private double meanY;
	private double slope;
	private double intercept;
	
	public void initialize(double[] a) {
		x = a;
	}
	
	public double getResult() {
		if (x==null) return 0;
		compute();
		return this.calculateX((double)x.length);
	}

	private void compute() {
		double n = x.length;
		double sumy = 0.0,
		sumx = 0.0,
		sumx2 = 0.0,
		sumxy = 0.0;
		for (int i = 0; i < n; i++) {
			sumx += x[i];
			sumx2 += x[i] * x[i];
			sumy += i;
			sumxy += x[i] * i;
		}
		meanX = sumx / n;
		meanY = sumy / n;
		slope = (sumxy - sumx * meanY) / (sumx2 - sumx * meanX);
		intercept = meanY - slope * meanX;
	}
	/**Calculate X given Y.*/
	public double calculateX (double y){
		return (y-intercept)/slope;
	}
}
