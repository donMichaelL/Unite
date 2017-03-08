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
		if (size() - period >= 0)
			return data[size() - period];
		// TODO throw IllegalArgumentException 
		else if (size() - 1 >= 0)
			return data[size() - 1];
		else
			throw new IllegalArgumentException();
	}
}
