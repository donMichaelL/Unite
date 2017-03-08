package com.unite.predictors;

public class GeometricMovingAveragePredictor extends AbstractPredictor{
	private  int period;
	
	GeometricMovingAveragePredictor(double[] data, int period){
		super(data);
		this.period = period;
	}
	

	public double getResult() {
	 	return geometricMA(data,period);
	}
	
	/**
	 * throws NullPointerException
	 * @param datatable
	 * @param period
	 * @return
	 */
	private static double geometricMA(double[] datatable, int period) {
		double sum= 0;
		int limit = datatable.length - period;
		if (limit < 0) throw new IllegalArgumentException();
		for(int i = datatable.length-1; i >= limit ; i--) {
				sum += Math.log(datatable[i]);
		}
		return Math.exp(sum/period);
	}
}
