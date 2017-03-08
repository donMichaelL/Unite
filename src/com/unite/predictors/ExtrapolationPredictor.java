package com.unite.predictors;

public class ExtrapolationPredictor extends AbstractPredictor{
	private static int MINIMUM_TABLE_SIZE = 2;
	
	ExtrapolationPredictor(double[] data) {
		super(data);
	}

	/**
	 * throws NullPointerException
	 */
	public double getResult() {
		if (size() < MINIMUM_TABLE_SIZE) 
			return data[size() - 1];
		return (2.0 * data[size()-1] - data[size()-2]);
	}
}
