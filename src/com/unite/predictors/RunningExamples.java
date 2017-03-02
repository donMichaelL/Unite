package com.unite.predictors;

public class RunningExamples {

	public static void main(String[] args) {
		/**
		 * Moving Average Predictor
		 */
		int period = 2; // 2 4 5 7 
		MovingAveragePredictor movingAveragePredictor = new MovingAveragePredictor(period);
		double[] a = {11, 13 ,13, 10};
		movingAveragePredictor.initialize(a);
		System.out.println(movingAveragePredictor.getResult());
		
		/**
		 * Cycle Predictor
		 */
		period = 5; // 3 5 6 8
		CyclePredictor cyclePredictor = new CyclePredictor(period);
		cyclePredictor.initialize(a);
		System.out.println(cyclePredictor.getResult());
		/**
		 * Round Average Predictor
		 */
		period = 2; // 2 4 5 7
		RoundedAveragePredictor roundedAveragePredictor = new RoundedAveragePredictor(2);
		roundedAveragePredictor.initialize(a);
		System.out.println(roundedAveragePredictor.getResult());
		/**
		 * SeasonalNaivePredictor
		 */
		SeasonalNaivePredictor seasonalNaivePredictor = new SeasonalNaivePredictor(2);
		seasonalNaivePredictor.initialize(a);
		System.out.println(seasonalNaivePredictor.getResult());
		
	}

}

