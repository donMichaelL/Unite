package com.unite.predictors;


public class SeasonalNaivePredictor extends AbstractPredictor{
	private  int period;
	
	public SeasonalNaivePredictor(double[] data, int period) {
		super(data);
		this.period = period;
	}

	/**
	 * throws NullPointerExceptions
	 */
	public double getResult(){
		if (period>data.length) throw new IllegalArgumentException();
		double result = data[0];
		for(int i=period-1; i<data.length; i+=period){
			result = data[i];
		}
		return result;
	}
}
