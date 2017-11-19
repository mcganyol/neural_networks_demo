import java.util.ArrayList;
import java.util.Random;

public class Perceptron implements IPerceptron {

	private ArrayList<IPerceptron> prevPerceptrons;
	private ArrayList<Double> weights;   // last para is always the bias
	private Double outputValue;
	private boolean linearPerceptron;
	
	
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
		double inputValue = 0;
		for (int i = 0; i < prevPerceptrons.size(); ++i) {
			inputValue += prevPerceptrons.get(i).getOutput() * weights.get(i);
		}
		inputValue += 1 * weights.get(weights.size() - 1); //it is always 1 on "bias leg" multiplied by it's own weight
		if (linearPerceptron) {
			outputValue = inputValue;	
		}
		else {
			outputValue = Math.max(0.0,inputValue);
		}
				
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


	@Override
	public void setWeight(ArrayList<Double> arrayList) {
		weights = arrayList;
	}


	@Override
	public void setOutput(Double value) {
		// makes no sense if not inputPerceptron
	}


	@Override
	public void setLinear(boolean lastLayer) {
		linearPerceptron = lastLayer;
		
	}
	
	

}
