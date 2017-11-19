import java.util.ArrayList;

public class Layer implements ILayer {
	
	ArrayList<IPerceptron> perceptrons;
	ILayer nextLayer;
	ILayer prevLayer;
	int depth;
	
	
	public Layer(int percNum) {
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
		// TODO Auto-generated method stub
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

}
