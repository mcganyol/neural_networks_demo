import java.util.ArrayList;

public class Layer implements ILayer {
	
	ArrayList<IPerceptron> perceptrons;
	ILayer nextLayer;
	ILayer prevLayer;
	int depth;
	private boolean lastLayer;
	
	
	public Layer(int percNum) {
		lastLayer = false;
		perceptrons = new ArrayList<IPerceptron>();
		depth = percNum;
		for (int i=0; i < depth; ++i) {
			perceptrons.add(new Perceptron());
		}
	}
	
	
	public void setPrevLayer(ILayer prev) {
		prevLayer = prev;
	}
	
	
	public void setNextLayer(ILayer next) {
		nextLayer = next;
	}


	@Override
	public ILayer getPrevLayer() {
		return prevLayer;
	}


	@Override
	public ILayer getNextLayer() {
		return nextLayer;
	}


	@Override
	public void compute() {
		for (int i = 0; i < depth; ++i) {
			perceptrons.get(i).compute();
		}
	}


	@Override
	public int getDepth() {
		return depth;
	}


	@Override
	public void finalizeStructure() {
		//we have to connect for each perceptron all the previous layer's perceptrons
		if (prevLayer != null) { // in fact it can not be null, unless it is an InputLayer which is a separate class...
			for (IPerceptron ip : perceptrons) {
				ip.finalizeStructure(prevLayer.getPerceptronList());
			}
		}
	}


	@Override
	public ArrayList<IPerceptron> getPerceptronList() {
		return perceptrons;
	}


	@Override
	public IPerceptron getPerceptron(int num) {
		return perceptrons.get(num);
	}


	@Override
	public void setOutput(ArrayList<Double> readValues) {
		// makes no sense if it is not input layer
		
	}


	@Override
	public ArrayList<Double> getOutput() {
		ArrayList<Double> retval = new ArrayList<Double>();
		for (int i = 0; i < depth; ++i) {
			retval.add(perceptrons.get(i).getOutput());
		}
		return retval;
	}


	@Override
	public void setLastLayer(boolean isit) {
		lastLayer = isit;
		for (int i = 0; i < depth; ++i) {
			perceptrons.get(i).setLinear(lastLayer);
		}
		
	}

}
