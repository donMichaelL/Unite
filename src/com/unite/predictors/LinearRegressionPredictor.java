package com.unite.predictors;

import java.text.NumberFormat;

public class LinearRegressionPredictor implements Predictor{
	
	private double[] x;
	private double[] y;
	private double meanX;
	private double meanY;
	private double slope;
	private double intercept;
	private double stndDevX;
	private double stndDevY;
	//private int k;
	
	public void initialize(double[] a) {
		x = a;
		y = new double[x.length];
		for (int i = 0; i < x.length; i ++)
			y[i] = (double) i + 1;
	}
	
	public double getResult() {
		if (x==null) return 0;
		compute();
		return this.calculateX((double)x.length);
	}

	private void compute() {
		double n = x.length;
		double sumy = 0.0,
		sumx = 0.0,
		sumx2 = 0.0,
		sumy2 = 0.0,
		sumxy = 0.0;
		for (int i = 0; i < n; i++) {
			sumx += x[i];
			sumx2 += x[i] * x[i];
			sumy += y[i];
			sumy2 += y[i] * y[i];
			sumxy += x[i] * y[i];
		}
		meanX = sumx / n;
		meanY = sumy / n;
		slope = (sumxy - sumx * meanY) / (sumx2 - sumx * meanX);
		intercept = meanY - slope * meanX;
		stndDevX = Math.sqrt((sumx2 - sumx * meanX) / (n - 1));
		stndDevY = Math.sqrt((sumy2 - sumy * meanY) / (n - 1));
	}
		
	/**Return approximated Y value, good for a single interpolation, multiple calls are inefficient!*/
	public double interpolateY(double x1, double y1, double x2, double y2, double fixedX ){
		double[] x = {x1, x2};
		double[] y = {y1, y2};
		return this.calculateY(fixedX);
	}
	
	/**Return approximated X value, good for a single interpolation, multiple calls are inefficient!*/
	public double interpolateX(double x1, double y1, double x2, double y2, double fixedY ){
		double[] x = {x1, x2};
		double[] y = {y1, y2};
		return this.calculateX(fixedY);
	}
	
	public double getSlope() {
		return slope;
	}
	public double getIntercept() {
		return intercept;
	}
	public double getRSquared() {
		double r = slope * stndDevX / stndDevY;
		return r * r;
	}
	public double[] getX() {
		return x;
	}
	/**Returns Y=mX+b with full precision, no rounding of numbers.*/
	public String getModel(){
		return "Y= "+slope+"X + "+intercept+" RSqrd="+getRSquared();
	}
	/**Returns Y=mX+b */
	public String getRoundedModel(){
		return "Y= "+formatNumber(slope,3)+"X + "+formatNumber(intercept,3)+" RSqrd="+ formatNumber(getRSquared(),3);
	}
	/**Calculate Y given X.*/
	public double calculateY (double x){
		return slope*x+intercept;
	}
	/**Calculate X given Y.*/
	public double calculateX (double y){
		return (y-intercept)/slope;
	}
	/**Nulls the x and y arrays.  Good to call before saving.*/
	public void nullArrays(){
		x = null;
		y = null;
	}
	public static String formatNumber(double num, int numberOfDecimalPlaces){
		NumberFormat f = NumberFormat.getNumberInstance();
		f.setMaximumFractionDigits(numberOfDecimalPlaces);
		f.setMinimumFractionDigits(numberOfDecimalPlaces);
		return f.format(num);
	}
}
