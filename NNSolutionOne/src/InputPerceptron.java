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


	@Override
	public void setWeight(ArrayList<Double> arrayList) {
		// this makes no sense here
	}


	@Override
	public void setLinear(boolean lastLayer) {
		
	}


	@Override
	public void calculateDerivative(Double errorTotalDerivate) {
		//pointless
		
	}


	@Override
	public ArrayList<Double> getDerivatives() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void modifyWeights(Double x) {
		// TODO Auto-generated method stub
		
	}
	
	
}
