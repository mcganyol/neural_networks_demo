import java.util.ArrayList;

public class NNSolutionTwo {

	private INNIo io;
	private NeuralNetwork nn;
	
	public NNSolutionTwo() {
		//init
		io = new StandardIO();
		ArrayList<Double> networkStructure = io.readValues();

		nn = new NeuralNetwork();
		int inputLayerDepth = (int) Math.round(networkStructure.get(0));
		ILayer inL = new InputLayer(inputLayerDepth);
		nn.addLayer(inL);
		networkStructure.remove(0);
		
		while (!networkStructure.isEmpty()) {
			int layerDepth = (int) Math.round(networkStructure.get(0));
			ILayer lay = new Layer(layerDepth);
			nn.addLayer(lay);
			networkStructure.remove(0);
		}
		
		nn.finalizeStructure();
		// so far we are done with initializing the neural network structure from io
		
		
		int numberOfInputWeightLines = 0;   // how many lines of weights will follow
		for (int i = 1; i < nn.getStructure().size(); ++i) {
			numberOfInputWeightLines += nn.getStructure().get(i).intValue();
		}
		
		ArrayList<ArrayList<Double>> readWeights = new ArrayList<ArrayList<Double>>();  // we read all the weights from input
		for (int a = 0; a < numberOfInputWeightLines; ++a) {
			ArrayList<Double> readWeight = io.readValues();
			readWeights.add(readWeight);
		}
		
		for (int i = 1; i < nn.getWidth(); ++i) {   // we set all the weights to the perceptrons in the given order
			for (int a = 0; a <nn.getLayer(i).getDepth(); ++a) {
				IPerceptron p = nn.getLayer(i).getPerceptron(a);
				p.setWeight(readWeights.get(0));
				readWeights.remove(0);
			}
			
		}
		
		int numberOfInputs = io.readValues().get(0).intValue(); // how many input lines will follow
		
		ArrayList<ArrayList<Double>> outputTable = new ArrayList<ArrayList<Double>>();
		for (int x = 0; x < numberOfInputs; ++x) { // we read inputs compute it and store the outputs
			ArrayList<Double> readInput = io.readValues(); 
			ArrayList<Double> results = nn.compute(readInput);
			outputTable.add(results);
		}
		
		//output
		
		io.writeIntValue(numberOfInputs); // how many output lines will be
		
		for (int i = 0; i < outputTable.size(); ++i) {
			io.writeValues(outputTable.get(i));
		}
		
		
	}
	
	public static void main(String[] args) {
		new NNSolutionTwo();
		
	}
	
	

}