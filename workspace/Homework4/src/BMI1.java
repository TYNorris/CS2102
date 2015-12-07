import java.util.*;

class BMI1 implements IBMIProbs {
	
  BMI1(){}
  
  public BMISummary bmiReport(LinkedList<PHR> phrs) {
	  
	  LinkedList<String> under;
	  LinkedList<String> healthy;
	  LinkedList<String> over;
	  LinkedList<String> obese;

	  under = phrsInBMIRange(phrs, 0, 18.5);    //filter and map for various ranges of BMI
	  healthy = phrsInBMIRange(phrs,18.5,25);
	  over = phrsInBMIRange(phrs,25,30);
	  obese = phrsInBMIRange(phrs,30, Double.POSITIVE_INFINITY);
	  
	  BMISummary summary = new BMISummary(under,healthy,over,obese);
	
    return summary;
  }
  
  private LinkedList<String> phrsInBMIRange(LinkedList<PHR> phrs, double lower, double upper){

	  LinkedList<String> output = new LinkedList<String>();
	  phrs.stream()
	  	  .filter((PHR phr) -> phr.getBMI() < upper && phr.getBMI() >= lower)  //filter all BMIs within range
	  	  .map((PHR phr) -> phr.name)          //convert to names
	  	  .forEach(phr -> output.add(phr));    //convert stream to LinkedList
	  
	  return output;
  }
}