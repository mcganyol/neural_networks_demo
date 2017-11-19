import java.util.ArrayList;

public class InputPerceptron implements IPerceptron{

	private Double outputValue;
	
	
	public InputPerceptron() {
		
	}
	
	
	public InputPerceptron(Double inputValue) {
		setOutput(inputValue);
	}
	
	
	public void setOutput(Double d) {
		outputValue = d;
	}
	
	
	public Double getOutput() {
		return outputValue;
	}
	
	public void compute() {
		
	}


	@Override
	public void finalizeStructure(ArrayList<IPerceptron> perceptronList) {
		// input has no left-side connection we don't have to do anything here
		
	}


	@Override
	public ArrayList<Double> getWeights() {
		return null;
	}
	
	
}
