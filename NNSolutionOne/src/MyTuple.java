
public class MyTuple { 
  private int szamlalo; 
  private Double ertek; 
  	public MyTuple() { 
	  szamlalo = 0;
	  ertek = 0.0;
  	}
  
  
  public void addValue(Double output, Double target) {
	  if (szamlalo == 0) {
		  ertek = Math.pow(target - output, 2);
		  szamlalo++;
	  }
	  else {
		  Double temp = szamlalo * ertek;
		  temp = temp + Math.pow(target - output, 2);;
		  szamlalo++;
		  ertek = temp / szamlalo;
	  }
  }
  
  public Double getValue() {
	  return ertek;
  }
} 