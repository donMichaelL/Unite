package com.unite.predictors;

import java.util.LinkedList;
import java.util.Queue;

public class SeasonalNaivePredictor implements Predictor{
	private  Queue<Double> window = new LinkedList<Double>();
	private  int steps; //steps are 1,2,3,4,5
	private double[] data;
	
	public SeasonalNaivePredictor(int steps) {
		this.steps = steps;
	}


	public void initialize(double[] a) {
	    data=a;
	}

	private void newNum(double num) {
	    window.add(num);
	    if (window.size() > 1) {
	    	double rm=window.remove();
	    }
	}

	private double Naive() {
		if (window.isEmpty()) return 0; // technically the average is undefined
		return window.element() ;
	}


	public double getResult() {
		if (data==null) return 0;
		int i;
		i=0;
		newNum(data[i]);
		i=i+steps-1;
		while(i<data.length) {	
			newNum(data[i]);
			//System.out.println(data[i]);
			i=i+steps;
		}
		return Naive();	
	}
}
