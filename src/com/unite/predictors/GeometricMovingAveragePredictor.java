package com.unite.predictors;

public class GeometricMovingAveragePredictor implements Predictor{
	private double[] data;
	private  int period;
	
   
	public void initialize(double[] a) {
		data=a;
		//TODO CHECK THIS PARAMETER
		period=a.length;
	}

	public double getResult() {
	 	double forecasts;
	 	forecasts=geometricMA(data,period);
	 	return forecasts;
	}

	 private static double geometricMA(double[] datatable, int period) {
		int i,length;
		double sum,forecast,f1;
		f1 = 0;
		sum = 0;
		forecast = 0;
		length = datatable.length-period;
		for(i = datatable.length-1; i >= length ; i--) {
			if(i >= 0) {
				sum = sum+Math.log(datatable[i]);
			} 
		}
		f1 = sum/period;
		forecast = Math.exp(f1);
		return forecast;
	}
}
