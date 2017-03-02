package com.unite.predictors;

public class ParabolicMovingAveragePredictor implements Predictor {
	private double[] data;
		
	    
	public void initialize(double[] a) {
    	data=a;
	}

	public double getResult() {
		// TODO IS THIS CONSTANT
		double trend=0.02;
		double forecast;
		forecast=exponential(data,trend);
		return forecast;
	}

	private static double exponential(double[] data, double trend) {
		 int i;
		 double[] sar=new double[data.length+1];
		 sar[0]=data[0];
		 double high,low;
		 high=data[0];
		 low=data[0];
		
		 for(i=1;i<=data.length;i++) {
			 if(data[i-1]>high) {
				 sar[i]=data[i-1]+trend*Math.abs(high-data[i-1]);
				 high=data[i-1];
				 trend=trend+0.02;
			 } else if (data[i-1]<high && data[i-1]>low ) {
				 sar[i]=data[i-1]+trend*Math.abs(high-data[i-1]);
			 } else {
				 sar[i]=data[i-1]+trend*Math.abs(low-data[i-1]);
				 low=data[i-1];
				 trend=trend+0.02;
			 }
		 }
		 return sar[data.length];
	 }
}
