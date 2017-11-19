import java.util.ArrayList;

public interface INNIo {

	public ArrayList<Double> readValues();
	
	public void writeValues(ArrayList<Double> d);
	
	public void writeIntValues(ArrayList<Double> i);

	public void writeIntValue(int i);
	
}
