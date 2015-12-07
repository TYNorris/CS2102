
public class Fish extends AbsAnimal {
	double salinity;
	  
	Fish(int length, double salinity){
		super(length);
		this.salinity=salinity;
    }
  
	//tells if fish is between 1 and 15 long
    public boolean isNormalSize () {
      return isLenWithin(1,15);
    }
}
