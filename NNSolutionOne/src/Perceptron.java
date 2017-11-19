import java.util.ArrayList;
import java.util.Random;

public class Perceptron implements IPerceptron {

	private ArrayList<IPerceptron> prevPerceptrons;
	private ArrayList<Double> weights;   // last param is always the bias
	private Double outputValue;
	private boolean linearPerceptron;
	private double doutPerDnet; 
	private ArrayList<Double> derivatives;
	
	
	public Perceptron()  {
		prevPerceptrons = new ArrayList<IPerceptron>();
	}
	
	
	void randomWeight() { // package visibility :)
		weights = new ArrayList<Double>();
		Random r = new Random();
		for (int i = 0; i < prevPerceptrons.size() - 2; ++i) { // -2 because we dont want a random value for bias
			Double random = r.nextGaussian()*0.1; 		// 0 varhato erteku, 0.1 szorasu random szamok
			weights.add(random);
		}
		weights.add(0.0); //bias initialized as with 0 weight
	}
	
	
	public void compute() {
		double inputValue = 0;
		for (int i = 0; i < prevPerceptrons.size(); ++i) {
			inputValue += prevPerceptrons.get(i).getOutput() * weights.get(i);
		}
		if (linearPerceptron) {
			outputValue = inputValue;
			doutPerDnet = 1.0; // linear perceptron x derivate is 1
		}
		else {
			outputValue = Math.max(0.0,inputValue);
			if (inputValue > 0) {
				doutPerDnet = 1.0;
			}
			else doutPerDnet = 0.0;
		}
				
	}
	
	
	public Double getOutput() {
		return outputValue;
	}
	

	@Override
	public void finalizeStructure(ArrayList<IPerceptron> perceptronList) {
		for (IPerceptron ip : perceptronList) {
			prevPerceptrons.add(ip);
		}
		prevPerceptrons.add(Bias.getInstance());
		
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


	@Override
	public void calculateDerivative(Double errorTotalDerivate) {
		derivatives = new ArrayList<Double>();  // calculate his own derivatives
		for (int i = 0; i < weights.size(); ++i) {
			derivatives.add(prevPerceptrons.get(i).getOutput() * errorTotalDerivate * doutPerDnet);
		}
		// and propagate his w to his left-side perceptrons to calculate
		for (int i = 0; i < prevPerceptrons.size() -1; ++i) { // -1 because we dont need to call it for bias direcly as it is not a real perspectron...
			prevPerceptrons.get(i).calculateDerivative(weights.get(i)*errorTotalDerivate);
		}
		
	}


	@Override
	public ArrayList<Double> getDerivatives() {
		return derivatives;
	}


	@Override
	public void modifyWeights(Double learningRate) {
		for (int i = 0; i < weights.size(); ++i) {
			System.out.println(weights.size() + "weights: " + weights.get(i)+ ", der: " + derivatives.get(i)+ " learning: " + learningRate);
			weights.set(i, weights.get(i) - derivatives.get(i) * learningRate); //i-th element is changed to something else
			System.out.println("modosult suly: "+ weights.get(i));
		}
		
	}
	
	

}
