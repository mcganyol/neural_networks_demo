import java.util.ArrayList;

public class InputLayer implements ILayer{

	ArrayList<IPerceptron> perc;
	ILayer nextLayer;
	int depth;
	
	public InputLayer(int inputDimension) {
		perc = new ArrayList<IPerceptron>();
		depth = inputDimension;
		for (int a = 0; a < depth; ++a) {
			perc.add(new InputPerceptron());
		}
	}
	
	
	@Override
	public int getDepth() {
		return depth;
	}


	@Override
	public ILayer getPrevLayer() {
		return null;
	}


	@Override
	public ILayer getNextLayer() {
		return nextLayer;
	}


	@Override
	public void compute() {
		// input does not compute		
	}


	@Override
	public void setPrevLayer(ILayer prev) {
		// it makes no sense for an input layer ...
	}


	@Override
	public void setNextLayer(ILayer next) {
		nextLayer = next;
	}


	@Override
	public void finalizeStructure() {
		// in the input layer we don't have to connect previous layer's perceptrions so we have nothing to do here
		
	}


	@Override
	public ArrayList<IPerceptron> getPerceptronList() {
		return perc;
	}


	@Override
	public IPerceptron getPerceptron(int num) {
		return perc.get(num);
	}
	
}
