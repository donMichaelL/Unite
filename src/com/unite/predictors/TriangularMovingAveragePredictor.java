package com.unite.predictors;

public class TriangularMovingAveragePredictor  extends AbstractPredictor {
	private  int period;
	
	TriangularMovingAveragePredictor(double[] data, int period){
		super(data);
		this.period = period;
	}
	 
	public double getResult() {
		double sum = 0;
		for(int i = 1; i <= period ; i++) {
			sum = sum + triangularMA(data, i);
		}	
		return sum/period;
	}
	
	private static double triangularMA(double[] datatable, int period) {
		double sum = 0;
		int limit = datatable.length-period;
		if (limit < 0) limit=0;
		
		for(int i = datatable.length-1; i >= limit ; i--) {
			sum = sum+datatable[i];
		 }
		 return sum/period;
	  }
}
