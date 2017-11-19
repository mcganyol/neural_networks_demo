import java.util.ArrayList;

//singleton
public class Bias implements IPerceptron {
	
	private static Bias instance = null;
	private final Double outputValue = 1.0;

	protected Bias( ) {	
	}
	
	public static Bias getInstance() {
		if(instance == null) {
			instance = new Bias();
		}
	   return instance;
	}
	
	@Override
	public Double getOutput() {
		return outputValue;
	}

	@Override
	public void compute() {
		
	}

	@Override
	public void finalizeStructure(ArrayList<IPerceptron> perceptronList) {
		
	}

	@Override
	public ArrayList<Double> getWeights() {
		return null;
	}

	@Override
	public void setWeight(ArrayList<Double> arrayList) {
	
	}

	@Override
	public void setOutput(Double double1) {
	}

	@Override
	public void setLinear(boolean lastLayer) {
	}

	@Override
	public void calculateDerivative(Double errorTotalDerivate) {
	
	}

	@Override
	public ArrayList<Double> getDerivatives() {
		return null;
	}

	@Override
	public void modifyWeights(Double x) {
		// TODO Auto-generated method stub
		
	}

	
}
