import java.util.ArrayList;

public class Perceptron {

	private ArrayList<Perceptron> prevPerceptrons;
	private ArrayList<Integer> weights;
	
	
	public Perceptron(ArrayList<Perceptron> pP) {
		randomsuly();
		setPreviouses(pP);
	}
	
	
	public Perceptron(ArrayList<Perceptron> pP, ArrayList<Integer> w ) {
		weights = w;
		setPreviouses(pP);
	}
	
	private void randomsuly() {
		//weights = aa;
	}
	
	private void setPreviouses( ArrayList<Perceptron>) {
		
	}
	
}
