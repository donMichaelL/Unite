package com.unite.predictors;

public class RunningExamples {

	public static void main(String[] args) {
		/**
		 * Moving Average Predictor
		 */
		int period = 2;
		MovingAveragePredictor movingAveragePredictor = new MovingAveragePredictor(period);
		double[] a = {11, 13 ,13, 10};
		movingAveragePredictor.initialize(a);
		System.out.println(movingAveragePredictor.getResult());
		
		/**
		 * CyclePredictor
		 */
		
		
		

	}

}

