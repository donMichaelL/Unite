package com.unite.predictors;

import java.util.LinkedList;
import java.util.Queue;


public class MovingAveragePredictor implements Predictor {

    private Queue<Double> window = new LinkedList<Double>();
    private int period;
    private double sum;
    private double[] data;
    
    public MovingAveragePredictor(int period) {
		this.period = period;
	}

    public void initialize(double[] a) {
       data=a;
       if (this.period>data.length) this.period=data.length;
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
    	if (data==null)return 0;
    	
    	for(i=0;i<data.length;i++) {
    		newNum(data[i]);
    	}
    	return SMA();	
	}
    
    /**
     * Iterating to the last period elements of the table
     * @return double moving average predictor
     */
    public double getResultsWithoutIteratingAllArray() {
    	if (data==null || period==0) return 0;
    	if (data.length==1) return data[data.length-1];
    	
    	double total=0;
    	for(int i=(data.length-1);i>(data.length-period-1);--i){
    		total += data[i];
    	}
    	
    	return total/period;
    }
}
