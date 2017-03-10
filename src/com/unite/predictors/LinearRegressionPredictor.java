package com.unite.predictors;

public class LinearRegressionPredictor extends AbstractPredictor{
	LinearRegressionPredictor(double[] data){
		super(data);
	}

	
	public double getResult() {
		return compute();
	}

	private double compute() {
		double sumy = 0.0, sumx = 0.0, sumx2 = 0.0, sumxy = 0.0;
		for (int i = 0; i < size(); i++) {
			sumx += data[i];
			sumx2 += data[i] * data[i];
			sumy += i;
			sumxy += data[i] * i;
		}
		double meanX = sumx / size();
		double meanY = sumy / size();
		double slope = (sumxy - sumx * meanY) / (sumx2 - sumx * meanX);
		double intercept = meanY - slope * meanX;
		return (size()-intercept)/slope;
	}
}
