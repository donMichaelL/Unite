package com.unite.predictors;

public class DoubleExponentialPredictor extends AbstractPredictor{
	//TODO What is this PARAMETER
//	private static final double PARAMETER = 0.6;
	private double parameter;
	
	DoubleExponentialPredictor(double[] data, double parameter){
		super(data);
		this.parameter = parameter;
	}
	
	public double getResult() {
		double[] forecasts_table;
		
		forecasts_table=exponential(data, parameter);
		forecasts_table=exponential(forecasts_table, parameter);
		return forecasts_table[forecasts_table.length-1];
	}

  	private static double[] exponential(double[] input, double param) {
  		double[] forecasts = new double[input.length+1];
  		forecasts[0] = input[0];
  		for(int i=1;i<=input.length;i++) {
  			forecasts[i] = param * input[i-1] + (1-param) * forecasts[i-1];
  		}
		  return forecasts;
	  }
}
