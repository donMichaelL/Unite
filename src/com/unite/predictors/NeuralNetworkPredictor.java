package com.unite.predictors;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.IterativeLearning;
import org.neuroph.core.learning.SupervisedLearning;
import org.neuroph.core.learning.TrainingSet;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.util.TransferFunctionType;

public class NeuralNetworkPredictor implements Predictor{
	private double[] data;
	private static NeuralNetwork neuralNet ;
	private static double datamin;
	private static double datamax;
	
	public void initialize(double[] a) {
		data = a;
		neuralNet = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, 3, 1);
	}
	
	
	public double getResult() {
		trainNetwork();
		NeuralNetwork neuralNet = new NeuralNetwork();
		double[] xx = {data[data.length - 3], data[data.length - 2], data[data.length - 1]}; // data for 3 inputs
		return getNetworkOutput(xx);
	}
	
	private void trainNetwork() {
		//-------------- Train the Neural Network -------------------------//
		int maxIterations = 100;
		((SupervisedLearning) neuralNet.getLearningRule()).setMaxError(0.0001);
        ((IterativeLearning) neuralNet.getLearningRule()).setLearningRate(0.8);
        ((IterativeLearning) neuralNet.getLearningRule()).setMaxIterations(maxIterations);
        TrainingSet trainingSet = null;
        long startTime = System.currentTimeMillis();
        // get training data from file and add them in to the ArrayList
        ArrayList<Double> data = new ArrayList<Double>();
        FileInputStream fstream;
		try {
			fstream = new FileInputStream("hospitaldata.txt");
			DataInputStream in = new DataInputStream(fstream);
	        BufferedReader br = new BufferedReader(new InputStreamReader(in));
	        String strLine;
	        data.clear();
	        while ((strLine = br.readLine()) != null)   {
	        	String[] str = strLine.split("#");
	        	for (int j = 0; j < str.length; j ++)
	        		data.add(Double.parseDouble(str[j]));
	        	datamax = Double.parseDouble(getMaxValue(data.toArray()));
	        	datamin = Double.parseDouble(getMinValue(data.toArray()));
	            for (int i = 0; i < data.size() - 3; i ++) {
	            		//trainingSet.addElement(new SupervisedTrainingElement(new double[]{getTrainingValue(data.get(i)), getTrainingValue(data.get(i+1)), getTrainingValue(data.get(i+2))}, new double[] {getTrainingValue(data.get(i+3))}));
	            }
	        }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println("## Training Set : " + trainingSet.size());
        //train the network
        neuralNet.learn(trainingSet);
        long endTime = System.currentTimeMillis();
        long mins = (endTime - startTime) / 6000;
        //System.out.println("-> Training Duration: " + mins + " minutes");  
        //-------------------- End of Training --------------------------//
	}
	
	
	private static double getTrainingValue ( double x ) {
		return ((x - datamin) / datamax) ;
	}
	
	
	private static String getMaxValue(Object data[]) {
		double max = -9999999.0D;
		for (int i = 0; i < data.length; i++) {
            if (Double.parseDouble(data[i].toString()) > max) {
                max = Double.parseDouble(data[i].toString());
            }
        }
		return String.valueOf(max);
	}
	private static String getMinValue(Object data[]) {
        double min = 9999999.0D;
		for (int i = 0; i < data.length; i++) {
            if (Double.parseDouble(data[i].toString()) < min) {
                min = Double.parseDouble(data[i].toString());
            }
        }
		return String.valueOf(min);
	}
	private static String getAverageValue(Object data[]) {
		double sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += Double.parseDouble(data[i].toString());
        }
		return String.valueOf(sum / data.length);
	}
	private static double getNetworkOutput (double[] values) {
		neuralNet.setInput(values);
        neuralNet.calculate();
        double[] networkOutput = neuralNet.getOutput();
        double result = datamin - (networkOutput[0] * datamin);// * datamax + datamin - 1;
        return networkOutput[0]; // check this!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}
}
