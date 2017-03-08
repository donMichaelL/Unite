package com.unite.predictors;

public class ParabolicMovingAveragePredictor extends AbstractPredictor {
	private double trend;
	
	ParabolicMovingAveragePredictor(double[] data, double trend) {
		super(data);
		this.trend = trend;
	}
	    
	public double getResult() {
		return exponential(data, trend);
	}

	private static double exponential(double[] data, double trend) {
		 double[] sar=new double[data.length+1];
		 sar[0]=data[0];
		 double high=data[0];
		 double low=data[0];
		
		 for(int i=1;i<=data.length;i++) {
			 if(data[i-1] > high) {
				 sar[i] = data[i-1] + trend*Math.abs(high-data[i-1]);
				 high = data[i-1];
				 // TODO what is 0.02
				 trend= trend+ 0.02;
			 } else if (data[i-1]<high && data[i-1]>low ) {
				 sar[i]=data[i-1]+trend*Math.abs(high-data[i-1]);
			 } else {
				 sar[i]=data[i-1]+trend*Math.abs(low-data[i-1]);
				 low=data[i-1];
				 // TODO what is 0.02
				 trend=trend+0.02;
			 }
		 }
		 return sar[data.length];
	 }
}
