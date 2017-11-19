import java.util.ArrayList;

public class NeuralNetwork {
	
	private ArrayList<ILayer> nnLayers;
	
	
	public NeuralNetwork() {
		nnLayers = new ArrayList<ILayer>();
	}
	
	
	public void addLayer(ILayer toadd) {
		nnLayers.add(toadd);
	}
	
	
	public ArrayList<Double> compute(ArrayList<Double> inputValues) {
		return null;
	}


	public void finalizeStructure() {  // we make a double-chained list from the Layers
		int length = nnLayers.size();
		nnLayers.get(0).setNextLayer(nnLayers.get(1));
		if (length == 2) {
			nnLayers.get(1).setPrevLayer(nnLayers.get(0));	
		}
		else {
			for (int i = 1; i < length - 1; ++i) {
				nnLayers.get(i).setNextLayer(nnLayers.get(i+1));
				nnLayers.get(i).setPrevLayer(nnLayers.get(i-1));
			}	
		}
		nnLayers.get(length-1).setPrevLayer(nnLayers.get(length-2));
		//now we have set all the Layers, we finalize the perceptrons with invoking the corresponding Layer function
		for (ILayer il : nnLayers) {
			il.finalizeStructure();
		}

		
		
	}


	public ArrayList<Double> getStructure() {
		ArrayList<Double> retval = new ArrayList<Double>();
		for(int i = 0; i < nnLayers.size(); ++i) {
			retval.add((double) nnLayers.get(i).getDepth());
		}
		return retval;
	}


	public int getWidth() { //number of layers
		return nnLayers.size();
	}
	
	public ILayer getLayer(int num) {
		return nnLayers.get(num);
	}

}
