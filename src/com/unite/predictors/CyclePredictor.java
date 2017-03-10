package com.unite.predictors;

public class CyclePredictor extends AbstractPredictor{
	private int period;
	
	public CyclePredictor(double[] data, int period) {
		super(data);
		this.period = period;
	}

	/**
	 * throws NullPointerException
	 * throws IllegalArgumentException
	 */
	public double getResult() {
		if (size() - period >= 0 && period>=0)
			return data[size() - period];
		else
			throw new IllegalArgumentException();
	}
}
