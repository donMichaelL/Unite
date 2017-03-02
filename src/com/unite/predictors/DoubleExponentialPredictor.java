package com.unite.predictors;

public class DoubleExponentialPredictor implements Predictor{
	//TODO What is this PARAMETER
	private static final double PARAMETER = 0.6;
	private double[] data;
	
	
	public void initialize(double[] a) {
		data=a;
	}

	public double getResult() {
		int length;
		double[] forecasts_table1,forecasts_table2;
  
		forecasts_table1=exponential(data, PARAMETER);
		forecasts_table2=exponential(forecasts_table1, PARAMETER);
		length=forecasts_table2.length;	
		return forecasts_table2[length-1];
	}

  	private static double[] exponential(double[] data, double a) {
  		int i;
  		double[] forecasts=new double[data.length+1];
  		forecasts[0]=data[0];
  		for(i=1;i<=data.length;i++) {
  			forecasts[i]=a*data[i-1]+(1-a)*forecasts[i-1];
  		}
		  return forecasts;
	  }
}
