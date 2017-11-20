import java.util.ArrayList;

public class NNSolutionFive {

	private INNIo io;
	private NeuralNetwork nn;
	private Double learningPercentage;
	private int epoch;
	
	public NNSolutionFive() {
		//init
		io = new StandardIO();
		nn = new NeuralNetwork();
		
		ArrayList<Double> learningParams = io.readValues(); //learning params
		setEpoch(learningParams.get(0));
		nn.setLearningRate(learningParams.get(1));
		learningPercentage = learningParams.get(2);
		
		ArrayList<Double> networkStructure = io.readValues();  // architecture

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
		
		
		Double numberOfInputs = io.readValues().get(0);
		int numberOfInputsInt = numberOfInputs.intValue(); // how many input lines will follow

		int learningSampleNr = (int) Math.floor( numberOfInputs*learningPercentage );
		
		for (int x = 0; x < learningSampleNr; ++x) { // we read inputs compute it and store the outputs
			ArrayList<Double> readInput = io.readValues(); 
			
			nn.setTarget(readInput.get(readInput.size()-1));
			readInput.remove(readInput.size()-1);
			
			nn.compute(readInput);
			nn.calculateDerivative();
			nn.modifyWeights();
		}
		
		for (int x = learningSampleNr; x < numberOfInputsInt; ++x) { // we read inputs compute it and store the outputs
			ArrayList<Double> readInput = io.readValues(); 
			
			nn.setTarget(readInput.get(readInput.size()-1));
			readInput.remove(readInput.size()-1);
			
			nn.compute(readInput);
			nn.MergeNegyzetesHiba();
		}
		
		
		//output
		
		ArrayList<Double> negyzetesH = new ArrayList<Double>();
		negyzetesH.add(nn.getAtlagosNegyzetesHiba());
		io.writeValues(negyzetesH);
		
		io.writeIntValues(nn.getStructure());
				
		//derivatives
		
		for (int layer = 1; layer < nn.getWidth(); ++layer) {  //starts from 1 to avoid asking the weights of "input layer" which makes no sense
			ILayer tempL = nn.getLayer(layer);
			for (int x = 0; x < tempL.getDepth(); ++x) {
				io.writeValues(tempL.getPerceptron(x).getWeights());
			}
		}
		
		
	}
	
	public void setEpoch(Double double1) {
		epoch = (int) Math.round(double1);
	}
	
	public static void main(String[] args) {
		new NNSolutionFive();
		
	}
	
}
