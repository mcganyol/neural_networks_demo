import java.util.ArrayList;

public class NNSolutionOne {

	private INNIo io;
	private NeuralNetwork nn;
	
	public NNSolutionOne() {
		io = new StandardIO();
		ArrayList<Double> networkStructure = io.readValues();
		io.writeIntValues(networkStructure);
		//ArrayList<Integer> convertedS;
		
		
		nn = new NeuralNetwork(2, new ArrayList<Integer>()); // bemenetek szama, percepek szama retegenkent egy tombben
		
	}
	
	public static void main(String[] args) {
		new NNSolutionOne();
		
	}
	
	

}
