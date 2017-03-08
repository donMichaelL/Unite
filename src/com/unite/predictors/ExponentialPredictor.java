package com.unite.predictors;

public class ExponentialPredictor extends AbstractPredictor{
	private double parameter;
	private int timesExponential=1;
	

	ExponentialPredictor(double[] data, double parameter){
		super(data);
		this.parameter = parameter;
	}
	
	public double getResult() {
		for(int i=0;i<timesExponential;i++)
			data=exponential(data, parameter);
		return data[data.length-1];
	}
	
	public int getTimesExponential() {
		return timesExponential;
	}

	public void setTimesExponential(int timesExponential) {
		this.timesExponential = timesExponential;
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
