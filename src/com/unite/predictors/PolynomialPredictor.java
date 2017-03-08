package com.unite.predictors;

public class PolynomialPredictor implements Predictor{
	private static double TINY = 1.0e-99; 
	//It uses the Rational Function approach
	private double[] yy;
	
	public void initialize(double[] a){
		yy = a;
	}
	
	public double getResult() {
		if (yy==null) throw new IllegalArgumentException();
		double x= 11;
		double dy;
		double[] xx = new double[yy.length];
		for (int i=0; i<yy.length; i++)
			xx[i] = i+1;
	    int mm = xx.length;
		int jl = 0;
		int m,i,ns=0;
		double y  ,w,t,hh,h,dd;
		double[] xa = xx, ya = yy;
		double[] c = new double[mm],d = new double[mm];
		hh=Math.abs(x-xa[0]);
		for (i=0;i<mm;i++) {
			h=Math.abs(x-xa[i]);
			if (h == 0.0) {
				dy=0.0;
			} 
			else if (h < hh) {
				ns=i;
				hh=h;
			}
			c[i]=ya[i];
			d[i]=ya[i]+TINY;
		}
		y=ya[ns--];
		for (m=1;m<mm;m++) {
			for (i=0;i<mm-m;i++) {
				w=c[i+1]-d[i];
				h=Math.abs(xa[i+m]-x); 
				t=(xa[i]-x)*d[i]/h;
				dd=t-c[i+1];
				if (dd == 0.0) 
					throw new IllegalArgumentException();
				dd=w/dd;
				d[i]=c[i+1]*dd;
				c[i]=t*dd;
			}
			y = y + (dy=(2*(ns+1) < (mm-m) ? c[ns+1] : d[ns--]));
		}
		
		return y;  
	}

}
