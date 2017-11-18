import java.util.ArrayList;

public class NeuralNetwork {
	
	private ArrayList<Layer> nnLayers;
	
	public NeuralNetwork(int inputNum, ArrayList<Integer> layers) {
		for (int i : layers) {
			nnLayers.add(new Layer(i));
		}
		
		
	}
	
	public ArrayList<Double> compute(ArrayList<Double> inputValues) {
		return inputValues;
	}
	
}
