import java.util.ArrayList;

public interface ILayer {
	
	
	
	public ILayer getPrevLayer();
	public void setPrevLayer(ILayer prev);
	public ILayer getNextLayer();
	public void setNextLayer(ILayer next);
	public void compute();
	public int getDepth();
	public void finalizeStructure();
	public ArrayList<IPerceptron> getPerceptronList();
	public IPerceptron getPerceptron(int num);

}
