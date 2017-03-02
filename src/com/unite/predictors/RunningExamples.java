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
		 * Seasonal Naive Predictor
		 */
		SeasonalNaivePredictor seasonalNaivePredictor = new SeasonalNaivePredictor(2);
		seasonalNaivePredictor.initialize(a);
		System.out.println(seasonalNaivePredictor.getResult());
		/**
		 * Double Exponential Predictor
		 */
		DoubleExponentialPredictor doubleExponentialPredictor = new DoubleExponentialPredictor();
		doubleExponentialPredictor.initialize(a);
		System.out.println(doubleExponentialPredictor.getResult());
		/**
		 * Drift Predictor
		 */
		DriftPredictor driftPredictor = new DriftPredictor();
		driftPredictor.initialize(a);
		System.out.println(driftPredictor.getResult());
		/**
		 * Extrapolation Predictor
		 */
		ExtrapolationPredictor extrapolationPredictor = new ExtrapolationPredictor();
		extrapolationPredictor.initialize(a);
		System.out.println(extrapolationPredictor.getResult());
		/**
		 * Geometric Moving Average Predictor
		 */
		GeometricMovingAveragePredictor geometricMovingAveragePredictor = new GeometricMovingAveragePredictor();
		geometricMovingAveragePredictor.initialize(a);
		System.out.println(geometricMovingAveragePredictor.getResult());
		/**
		 * Holt Winters Add Predictor
		 */
		HoltWintersAddPredictor holtWintersAddPredictor = new HoltWintersAddPredictor();
		holtWintersAddPredictor.initialize(a);
		// TODO Prints 0
		System.out.println(holtWintersAddPredictor.getResult());
		
	}

}

