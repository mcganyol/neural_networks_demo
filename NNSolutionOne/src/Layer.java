import java.util.ArrayList;

public class Layer {
	
	ArrayList<Perceptron> lPerceptrons;
	Layer prevLayer;
	
	public Layer(int percNum, Layer pLayer) {
		prevLayer = pLayer;
		for (int i=0; i<percNum; ++i) {
			lPerceptrons.add(new Perceptron());
		}
	}

}
