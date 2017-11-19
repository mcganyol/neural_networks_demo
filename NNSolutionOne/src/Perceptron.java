import java.util.ArrayList;
import java.util.Random;

public class Perceptron implements IPerceptron {

	private ArrayList<IPerceptron> prevPerceptrons;
	private ArrayList<Double> weights;   // last para is always the bias
	private Double outputValue;
	
	
	public Perceptron()  {
		prevPerceptrons = new ArrayList<IPerceptron>();
	}
	
	
	void randomWeight() { // package visibility :)
		weights = new ArrayList<Double>();
		Random r = new Random();
		for (int i = 0; i < prevPerceptrons.size(); ++i) {
			Double random = r.nextGaussian()*0.1; 		// 0 varhato erteku, 0.1 szorasu random szamok
			weights.add(random);
		}
		
		weights.add(0.0); //bias initialized as 0
	}
	
	
	public void compute() {
		outputValue = 1.0;
	}
	
	
	public Double getOutput() {
		return outputValue;
	}
	

	@Override
	public void finalizeStructure(ArrayList<IPerceptron> perceptronList) {
		prevPerceptrons = perceptronList;
		if (weights == null) randomWeight();
	}


	@Override
	public ArrayList<Double> getWeights() {
		return weights;
	}
	

}
