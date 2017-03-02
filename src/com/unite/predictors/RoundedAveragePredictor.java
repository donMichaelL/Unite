package com.unite.predictors;

import java.util.LinkedList;
import java.util.Queue;

public class RoundedAveragePredictor {
	private  Queue<Double> window = new LinkedList<Double>();
	private  int observations;
	private double sum;
	private double[] data;
	
	RoundedAveragePredictor(int observation) {
		this.observations = observation;
	}
	    
	public void initialize(double[] a) {
		 data=a;
	}
	    

	private void newNum(double num) {
	    	 sum += num;
		     window.add(num);
		    if (window.size() > observations) {
		    	double rm=window.remove();
		    	//System.out.println(rm);
		    	sum -= rm;
	    	}
	 }
	 
	 private double Average() {
		 if (window.isEmpty()) return 0; // technically the average is undefined
		 return Math.round(sum / window.size()) ;
	 }
	 
	    
	public double getResult() {
		if (data == null) {
			return 0;
		}
		int i;
		for(i=0;i<data.length;i++) {
		
			newNum(data[i]);
		}
		return Average();
	}
}
