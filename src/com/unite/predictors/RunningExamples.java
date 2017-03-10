package com.unite.predictors;

public class RunningExamples {
	
	public static void main(String[] args) {
		double[] a = {7, 9, 11, 13, 15};
		/**
		 * Moving Average Predictor
		 */
		int period = 5; // 2 4 5 7 
		MovingAveragePredictor movingAveragePredictor = new MovingAveragePredictor(a, period);
		System.out.println(movingAveragePredictor.getResult());
		/**
		 * Cycle Predictor
		 */
		period = 4; // 3 5 6 8
		CyclePredictor cyclePredictor = new CyclePredictor(a, period);
		System.out.println(cyclePredictor.getResult());
		/**
		 * Round Average Predictor
		 */
		period = 5; // 2 4 5 7
		RoundedAveragePredictor roundedAveragePredictor = new RoundedAveragePredictor(a, period);
		System.out.println(roundedAveragePredictor.getResult());
		/**
		 * Seasonal Naive Predictor
		 */
		SeasonalNaivePredictor seasonalNaivePredictor = new SeasonalNaivePredictor(a, period);
		System.out.println(seasonalNaivePredictor.getResult());

		/**
		 * Double Exponential Predictor
		 */
		ExponentialPredictor doubleExponentialPredictor = new ExponentialPredictor(a, 0.6);
		doubleExponentialPredictor.setTimesExponential(2);
		System.out.println(doubleExponentialPredictor.getResult());
		/**
		 * Drift Predictor
		 */
		DriftPredictor driftPredictor = new DriftPredictor(a);
		System.out.println(driftPredictor.getResult());
		/**
		 * Extrapolation Predictor
		 */
		ExtrapolationPredictor extrapolationPredictor = new ExtrapolationPredictor(a);
		System.out.println(extrapolationPredictor.getResult());
		/**
		 * Geometric Moving Average Predictor
		 */
		GeometricMovingAveragePredictor geometricMovingAveragePredictor = new GeometricMovingAveragePredictor(a, 4);
		System.out.println(geometricMovingAveragePredictor.getResult());
		/**
		 * Holt Winters Add Predictor
		 */
		HoltWintersAddPredictor holtWintersAddPredictor = new HoltWintersAddPredictor();
		holtWintersAddPredictor.initialize(a);
		// TODO Prints 0
		System.out.println(holtWintersAddPredictor.getResult());
		/**
		 * Holt Winters Mul Predictor
		 */
		HoltWintersMulPredictor holtWintersMulPredictor = new HoltWintersMulPredictor();
		holtWintersMulPredictor.initialize(a);
		// TODO Prints 0
		System.out.println(holtWintersMulPredictor.getResult());
		/**
		 * Linear Predictor
		 */
		LinearPredictor linearPredictor = new LinearPredictor(a);
		System.out.println(linearPredictor.getResult());
		/**
		 * Linear Regression Predictor
		 */
		LinearRegressionPredictor linearRegressionPredictor = new LinearRegressionPredictor(a);
		//linearRegressionPredictor.initialize(a);
		System.out.println(linearRegressionPredictor.getResult());
		/**
		 * Parabolic Moving Average Predictor
		 */
		ParabolicMovingAveragePredictor parabolicMovingAveragePredictor = new ParabolicMovingAveragePredictor(a, 0.02, 0.02);
		System.out.println( parabolicMovingAveragePredictor.getResult());
		/**
		 * Polynomial Predictor
		 */
		PolynomialPredictor polynomialPredictor = new PolynomialPredictor(a);
		System.out.println(polynomialPredictor.getResult());
		/**
		 * Single Exponential Predictor
		 */
		ExponentialPredictor singleExponentialPredictor = new ExponentialPredictor(a, 0.6);
		singleExponentialPredictor.setTimesExponential(1);
		System.out.println(singleExponentialPredictor.getResult());
		/**
		 * Triangular Moving Average Predictor
		 */
		TriangularMovingAveragePredictor triangularMovingAveragePredictor = new TriangularMovingAveragePredictor(a, period);
		System.out.println(triangularMovingAveragePredictor.getResult());
		/**
		 * Neural Network Predictor
		 */
		//TODO PROBLEM WITH HOSPITAL DATA + TRAINING SET
		NeuralNetworkPredictor neuralNetworkPredictor = new NeuralNetworkPredictor();
		neuralNetworkPredictor.initialize(a);
		//System.out.println(neuralNetworkPredictor.getResult());
		
	}

}

