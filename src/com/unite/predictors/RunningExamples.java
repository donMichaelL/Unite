package com.unite.predictors;

public class RunningExamples {

	public static void main(String[] args) {
		MovingAveragePredictor movingAveragePredictor = new MovingAveragePredictor();
		double[] a = {11, 13 ,13, 10};
		movingAveragePredictor.initialize(a);
		System.out.println(movingAveragePredictor.getResult());

	}

}

