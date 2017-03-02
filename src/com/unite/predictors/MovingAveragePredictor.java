package com.unite.predictors;

import java.util.LinkedList;
import java.util.Queue;


public class MovingAveragePredictor implements Predictor {

    private  Queue<Double> window = new LinkedList<Double>();
    private  int period;
    private double sum;
    private double[] data;

    public void initialize(double[] a) {
       this.period=2;
       data=a;
	}
 
    private void newNum(double num) {
        sum += num;
        window.add(num);
        if (window.size() > period) {
        	double rm=window.remove();
            sum -= rm;
        }
    }
 
    private double SMA() {
        if (window.isEmpty()) return 0; // technically the average is undefined
        return sum / window.size();
    }
 
    
    public double getResult() {
    	int i;
    	if (data==null){
    		return 0;
    	}
    	for(i=0;i<data.length;i++) {
    		newNum(data[i]);
    	}
    	return SMA();	
	}

}
