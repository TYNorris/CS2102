
public class Triples {
	int num1;
	int num2;
	int num3;
	
	public Triples(int num1, int num2, int num3){
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}
	
	public double average(){
		return (num1 + num2 + num3)/3.0;
	}
}
