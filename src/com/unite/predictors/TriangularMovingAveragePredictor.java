package com.unite.predictors;

public class TriangularMovingAveragePredictor  implements Predictor {
	private double[] data;
	private  int period;
	
	public void initialize(double[] a) {
		data=a;
		period=a.length;
	}
	 
	public double getResult() {
		if (data==null) return 0;
		int i;
		double sum,forecast;
		sum = 0;
		forecast = 0;
		for(i = 1; i <= period ; i++) {
			sum = sum + triangularMA(data, i);
		}	
		forecast = sum/period;
		return forecast;
	}
	
	private static double triangularMA(double[] datatable, int period) {
		int i,length;
		double sum,forecast;
		sum = 0;
		forecast = 0;
		length = datatable.length-period;
		
		for(i = datatable.length-1; i >= length ; i--) {
			if(i >= 0) {
				sum = sum+datatable[i];
			 }
		 }
		 forecast = sum/period;
		 return forecast;
	  }
}
