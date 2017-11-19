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
		int length = d.size();
		for (int a = 0; a < length - 1; ++a) {
			System.out.printf("%f," , d.get(a));
		}
		System.out.printf("%f\n" , d.get(length - 1));
		
	}
	
	
	public void writeIntValue(int i) {
		System.out.printf("%d\n" , i);
	}
	

	public void writeIntValues(ArrayList<Double> i) {
		int length = i.size();
		for (int a = 0; a < length - 1; ++a) {
			System.out.printf("%.0f," , i.get(a));
		}	
		System.out.printf("%.0f\n" , i.get(length - 1));
		
	}
	
}
