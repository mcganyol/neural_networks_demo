import java.util.ArrayList;

public interface IPerceptron {

	public Double getOutput();
	public void compute();
	public void finalizeStructure(ArrayList<IPerceptron> perceptronList);
	public ArrayList<Double> getWeights();
	public void setWeight(ArrayList<Double> arrayList);
	public void setOutput(Double double1);
	public void setLinear(boolean lastLayer);
	public void calculateDerivative(Double errorTotalDerivate);
	
}
