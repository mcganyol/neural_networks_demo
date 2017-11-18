import java.util.ArrayList;
import java.util.Scanner;

public class StandardIO implements INNIo {

	Scanner scan=new Scanner(System.in);
	
	
	public ArrayList<Double> readValues() {
		ArrayList<Double> lista = new ArrayList<Double>();
		String line = scan.nextLine();
		String[] splittedLine = line.split(",");
		
		for(String value : splittedLine){
    		lista.add(Double.parseDouble(value));
    	}
		
		return lista;
	}
	

	public void writeValues(ArrayList<Double> d) {
		for(Double value : d) {
			System.out.printf(value+",");	
		}
		
		
	}
	

	public void writeIntValues(ArrayList<Double> i) {
		for(Double value : i) {
			
			System.out.printf("%.0f,", value);	
		}
	}
	
}
