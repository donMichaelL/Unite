package com.unite.predictors;

public class LinearPredictor implements Predictor {
	private double[] data;
	
	public void initialize(double[] a){
		data = a;
	}
	
	public double getResult() {
		if (data==null) return 0;
		double[] dat = new double[data.length + 1];
		for (int i = 0; i < data.length; i ++)
			dat[i] = data[i];
		double[] coeffs = new double[data.length + 1];
		double[] result = levinsondurbin(dat, data.length, coeffs);
		
		double sum = 0;
		for (int i = 0;i < result.length - 1; i ++)
			sum += result[i] * data[i];
		return sum;
	}
	
	//it returns the coefficients table
	private static double[] levinsondurbin (double[] r, int m, double[] coeffs) {
		int i;
		int j; int k;
		double gap;
		double gamma;
		double e[] = new double[m + 1];
		double l[][] = new double[m + 1][m + 1];
		/* compute recursion  */
		for (i = 0; i <= m; i++) {
			for (j = i + 1; j <= m; j++) {
				l[i][j] = 0.;
			}
		}
		l[0][0] = 1.;
		l[1][1] = 1.;
		l[1][0] = -r[1] / r[0];
		e[0] = r[0];
		e[1] = e[0] * (1. - l[1][0] * l[1][0]);
		for (i = 2; i <= m; i++) {
			gap = 0.;
			for (k = 0; k <= i - 1; k++) {
				gap += r[k + 1] * l[i - 1][k];
			}
			gamma = gap / e[i - 1];
			l[i][0] = -gamma;
			for (k = 1; k <= i - 1; k++) {
				l[i][k] = l[i - 1][k - 1] - gamma * l[i - 1][i - 1 - k];
    		}
			l[i][i] = 1.;
			e[i] = e[i - 1] * (1. - gamma * gamma);
		}
		/* extract length-m whitening filter coefficients  */
		coeffs[0] = 1.;
		for (i = 1; i <= m; i++) {
			coeffs[i] = l[m][m - i];
		}
	 	double sum = 0.;
		for (i = 0; i < m; i++) {
			sum += coeffs[i];
	  	}
		for (i = 0; i < m; i++) {
	     	coeffs[i] = coeffs[i] / sum;
	  	}
	return coeffs;
	}
}
