import java.util.LinkedList;

class BMI2 implements IBMIProbs {
  BMI2(){}
  
  public BMISummary bmiReport(LinkedList<PHR> phrs) {
	  
	  LinkedList<String> under = new LinkedList<String>();
	  LinkedList<String> healthy = new LinkedList<String>();
	  LinkedList<String> over = new LinkedList<String>();
	  LinkedList<String> obese = new LinkedList<String>();

	  for(PHR phr : phrs){      //for every record
		  double bmi = phr.getBMI();
		  if(bmi>0 && bmi<18.5)     //find the correct bmi range and add it to the right list
			  under.add(phr.name);
		  else if(bmi<25)
			  healthy.add(phr.name);
		  else if(bmi<30)
			  over.add(phr.name);
		  else if(bmi>=30)
			  obese.add(phr.name);
	  }
    return new BMISummary(under,healthy,over,obese);   //return the lists
  }
}