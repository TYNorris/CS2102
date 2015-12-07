
public class Shark extends Fish {
    int attacks;
  
    Shark (int length, int attacks) {
     super( length , 3.75);
      this.attacks = attacks;
    }
    
    // determines if shark is bigger than 6
    public boolean isNormalSize(){
    	return this.length >= 6;
    }
  
    // determines if shark has ever attacked anyone
    public boolean isDangerToPeople(){
    	return this.attacks >= 1;
    }
}
