import java.util.ArrayList;

public class NeuralNetwork {
	
	private ArrayList<ILayer> nnLayers;
	private Double finalOutput;  // it should be an ArrayList<Double> if not a single output
	private Double target;
	private Double learningRate;
	private MyTuple atlagosNegyzetesHiba;
	
	
	public NeuralNetwork() {
		nnLayers = new ArrayList<ILayer>();
		atlagosNegyzetesHiba = new MyTuple();
	}
	
	
	public void addLayer(ILayer toadd) {
		nnLayers.add(toadd);
	}
	
	
	public ArrayList<Double> compute(ArrayList<Double> inputValues) {
		nnLayers.get(0).setOutput(inputValues); // we set the input layer values to the input
		for (int b = 0; b < this.getWidth(); ++b) {
			nnLayers.get(b).compute();
		}
		finalOutput = nnLayers.get(nnLayers.size()-1).getOutput().get(0);  // the final output must be an ArrayList<Double> if not a single value
		return nnLayers.get(nnLayers.size()-1).getOutput(); // the last layers output is the output of the neural network
	}


	public void finalizeStructure() {  // we make a double-chained list from the Layers
		int length = nnLayers.size();
		nnLayers.get(0).setNextLayer(nnLayers.get(1));
		if (length == 2) {
			nnLayers.get(1).setPrevLayer(nnLayers.get(0));	
		}
		else {
			for (int i = 1; i < length - 1; ++i) {
				nnLayers.get(i).setNextLayer(nnLayers.get(i+1));
				nnLayers.get(i).setPrevLayer(nnLayers.get(i-1));
			}	
		}
		nnLayers.get(length-1).setPrevLayer(nnLayers.get(length-2));
		nnLayers.get(length-1).setLastLayer(true); // because our last layer acts differently :( the perceptrons function to determine the output is different
		//now we have set all the Layers, we finalize the perceptrons with invoking the corresponding Layer function
		for (ILayer il : nnLayers) {
			il.finalizeStructure();
		}
	}


	public ArrayList<Double> getStructure() {
		ArrayList<Double> retval = new ArrayList<Double>();
		for(int i = 0; i < nnLayers.size(); ++i) {
			retval.add((double) nnLayers.get(i).getDepth());
		}
		return retval;
	}


	public int getWidth() { //number of layers
		return nnLayers.size();
	}
	
	
	public ILayer getLayer(int num) {
		return nnLayers.get(num);
	}
	

	public void setTarget(Double t) {
		target = t;
	}


	public void calculateDerivative() {
		//Double ErrorTotalDerivate = finalOutput - target;  // here we dont need error
		//System.out.println("output: " + finalOutput + " target:" + target);
		for (int a = nnLayers.get(this.getWidth() - 1).getDepth() - 1; a >= 0; --a) { //we need the i-th layer perceptrons in backward order
			nnLayers.get(this.getWidth() - 1).getPerceptron(a).calculateDerivative(1.0);
		}
	}


	public void setLearningRate(Double double1) {
		learningRate = double1;
	}


	public void modifyWeights() {
		for (int a = 0; a < this.getWidth(); ++a) { //we need the i-th layer perceptrons in backward order
			for (int i = 0; i < this.getLayer(a).getDepth(); ++i) {
				nnLayers.get(a).getPerceptron(i).modifyWeights(learningRate * (target - finalOutput) * 2);
			}
			
		}
		
	}
	
	public void MergeNegyzetesHiba() {
		atlagosNegyzetesHiba.addValue(finalOutput, target);
	}
	
	public Double getAtlagosNegyzetesHiba() {
		return atlagosNegyzetesHiba.getValue();
	}

}
