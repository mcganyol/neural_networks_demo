import java.util.ArrayList;

public interface IPerceptron {

	public Double getOutput();
	public void compute();
	public void finalizeStructure(ArrayList<IPerceptron> perceptronList);
	public ArrayList<Double> getWeights();
	
}
