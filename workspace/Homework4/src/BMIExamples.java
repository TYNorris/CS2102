import tester.*;
import java.util.LinkedList;

class BMIExamples {
  IBMIProbs B;
  
  
  PHR domingo = new PHR("Domingo",5, 750,100); // obese
  PHR cam = new PHR("Cam",2, 74, 130); //healthy
  PHR shaun = new PHR("Shaun", 2, 100,100); // over
  PHR meghan = new PHR("Meghan", 1, 18.4,160); //under
  PHR cj = new PHR("CJ", 2.2, 100,220); //healthy

  LinkedList<PHR> gi = new LinkedList<PHR>();

  
  BMIExamples(IBMIProbs b) {
    this.B = b;
    
    gi.add(domingo);
    gi.add(cam);
    gi.add(shaun);
    gi.add(meghan);
    gi.add(cj);
    
  }
  
  boolean testAllCutoffs (Tester t) {
	  LinkedList<String> under = new LinkedList<String>();
	  under.add("Meghan");
	  LinkedList<String> healthy = new LinkedList<String>();
	  healthy.add("Cam");
	  healthy.add("CJ");
	  LinkedList<String> over = new LinkedList<String>();
	  over.add("Shaun");
	  LinkedList<String> obese = new LinkedList<String>();
	  obese.add("Domingo");
    return t.checkExpect(B.bmiReport(gi), new BMISummary(under, healthy,over,obese));
  }
  
  boolean testEmptyLists (Tester t){
	  gi.remove(0);
	  LinkedList<String> under = new LinkedList<String>();
	  under.add("Meghan");
	  LinkedList<String> healthy = new LinkedList<String>();
	  healthy.add("Cam");
	  healthy.add("CJ");
	  LinkedList<String> over = new LinkedList<String>();
	  over.add("Shaun");
	  return t.checkExpect(B.bmiReport(gi), new BMISummary(under, healthy,over,new LinkedList<String>()));
	  
  }
}