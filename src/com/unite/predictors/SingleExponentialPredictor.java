package com.unite.predictors;

public class SingleExponentialPredictor  implements Predictor {

	private double[] data;
	
	public void initialize(double[] a) {
		data=a;
	}

	public double getResult() {
		if (data==null) return 0;
		double a=0.6;
		double forecast;
		forecast=exponential(data,0.6);
		return forecast;
	}

	private static double exponential(double[] data, double a) {
		int i;
		double[] forecasts=new double[data.length+1];
		forecasts[0]=data[0];
		for(i=1;i<=data.length;i++) {
			forecasts[i]=a*data[i-1]+(1-a)*forecasts[i-1];
			//System.out.println(data[i-1]+" "+forecasts[i-1]);
		}
		//System.out.println(" "+forecasts[i-1]);
		return forecasts[data.length]; 
	 }
}
