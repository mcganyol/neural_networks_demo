import java.util.ArrayList;

public class NNSolutionOne {

	private INNIo io;
	private NeuralNetwork nn;
	
	public NNSolutionOne() {
		
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

		
		//output
		
		io.writeIntValues(nn.getStructure());  // shows the layers and the number of perceptrons
		
		for (int layer = 1; layer < nn.getWidth(); ++layer) {  //starts from 1 to avoid asking the weights of "input layer" which makes no sense
			ILayer tempL = nn.getLayer(layer);
			for (int x = 0; x < tempL.getDepth(); ++x) {
				io.writeValues(tempL.getPerceptron(x).getWeights());
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new NNSolutionOne();
		
	}
	
	

}
