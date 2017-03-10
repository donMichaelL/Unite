package com.unite.predictors;

public class PolynomialPredictor extends AbstractPredictor{
	private static double TINY = 1.0e-99; 

	PolynomialPredictor(double[] data){
		super(data);
	}
	

	public double getResult() {
		double x= 11, dy;
		double[] xx = new double[size()];
		for (int i=0; i<size(); i++)
			xx[i] = i+1;
	    int mm = size(), jl=0, m,i,ns=0 ;
		double y ,w,t,hh,h,dd;
		double[] xa = xx, ya = data;
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
