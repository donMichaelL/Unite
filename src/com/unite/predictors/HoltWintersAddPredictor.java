package com.unite.predictors;

public class HoltWintersAddPredictor implements Predictor {
	private double[] data;
	private int k;
	private double Ls;
	private double Bs;
	private double[] Si;
	
	public void initialize(double[] a) {
		data = a;
	}
	
	public double getResult() {
		if (data==null) return 0;
		double result = 0.0;
		//choose parameters
		int s = data.length;// / 2;
		Ls = initializeLs(data, s);
		Bs = initializeBs(data, s);
		Si = getSi(data, s);
		//TODO PARAMETERS OR CONSTANTS ?
		double a = 0.9;  //<--------- check for random [0,1]
		double b = 0.9;  //<--------- check for random [0,1]
		double c = 0.9;  //<--------- check for random [0,1]
		double Lt;
		double Lt1;
		double Bt1;
		double Bt;
		double St;
		double Ft1 = 0.0;
		Bt1 = Bs;
		Lt1 = Ls;
		for (int i = s; i < data.length; i ++) {
			//int i = data.length;
			//calculate just the next round Forecast. If you want more predictions just change  
			Lt = a * (data[i - 1] - Si[i - s]) + (1.0 - a) * (Lt1 - Bt1);
			Bt = b * (Lt - Lt1) + (1.0 - b) * Bt1;
			St = c * (data[i - 1] - Lt) + (1.0 - c) * Si[i - s];
			Ft1 = Lt + Bt + Si[i + 1 - s];
		}
		return Ft1;
	}
	
	private double initializeLs(double[] data, int s) {
		double sum = 0.0;
		for (int i = 0; i < s; i ++)
			sum += data[i];
		return sum / Double.parseDouble(Integer.toString(s));
	}
	
	private double initializeBs(double[] data, int s) {
		double sum = 0.0;
		int middle = s / 2;
		//System.out.println("Middle : " + middle + " Last : " + data.length);
		for (int i = 0; i < middle; i ++)
			sum += ((data[middle + i] - data[i]) / (Double.parseDouble(Integer.toString(s))));		
			
		return sum / Double.parseDouble(Integer.toString(s));
	}
	
	private double[] getSi(double[] data, int s) {
		double[] Si = new double[s];
		for (int i = 0; i < s; i ++)
			Si[i] = data[i] - Ls;
		return Si;
	}

}
