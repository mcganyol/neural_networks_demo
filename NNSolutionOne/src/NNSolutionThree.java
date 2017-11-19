import java.util.ArrayList;

public class NNSolutionThree {

	private INNIo io;
	private NeuralNetwork nn;
	
	public NNSolutionThree() {
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
		
		//target given, calculating derivatives
		nn.setTarget(1.0);  // it was calculated on paper because i have found no trace of it in the input but it is a vital data nevertheless
		nn.calculateDerivative();
		
		
		//output
		
		io.writeIntValues(nn.getStructure());
				
		//derivatives
		
		for (int layer = 1; layer < nn.getWidth(); ++layer) {  //starts from 1 to avoid asking the weights of "input layer" which makes no sense
			ILayer tempL = nn.getLayer(layer);
			for (int x = 0; x < tempL.getDepth(); ++x) {
				io.writeValues(tempL.getPerceptron(x).getDerivatives());
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new NNSolutionThree();
		
	}
	
}
