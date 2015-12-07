import tester.*;
import java.util.LinkedList;

class EarthquakeExamples {
  IEarthquakeProbs E;
  LinkedList<Double> givenData = new LinkedList<Double>();
  
  LinkedList<Double> trickyData = new LinkedList<Double>();
 
  EarthquakeExamples(IEarthquakeProbs E) {
    this.E = E;
    givenData.add(20151004.);
    givenData.add(200.);
    givenData.add(150.);
    givenData.add(175.);
    givenData.add(20151005.);
    givenData.add(0.002);
    givenData.add(0.03);
    givenData.add(20151007.);
    givenData.add(40.);
    // Challenging Data set
    trickyData.add(19960101.);  //Test different month before
    trickyData.add(500.);  
    trickyData.add(0.);
    trickyData.add(19960501.);  //Test different year than 2015|Gives [1,500]
    trickyData.add(500.);       //Test data extremes
    trickyData.add(0.);  
    trickyData.add(100.0);
    trickyData.add(19960503.);  //Test different month          Gives [3,0.003]
    trickyData.add(0.002);      //Test nums < 1
    trickyData.add(0.003);
    trickyData.add(19960512.);                                //Gives [12, 0.04]
    trickyData.add(0.04);       //Test 1 data entry
    trickyData.add(19960531.);  //Test 31st day                 Gives [31, 335.1]
    trickyData.add(335.0);      //Test difference of <1;
    trickyData.add(335.1);
    trickyData.add(19961003.);  //Test month that is a multiple of actual month
    trickyData.add(1.24);       
    trickyData.add(19961005.);  
    trickyData.add(0.01);
    trickyData.add(0.05);
    trickyData.add(0.04);

    
  }
  
  
  
  boolean testGiven (Tester t) {
	  LinkedList<MaxHzReport> expected = new LinkedList<MaxHzReport>();
	  expected.add(new MaxHzReport(4,200.));
	  expected.add(new MaxHzReport(5,0.03));
	  expected.add(new MaxHzReport(7,40.));
    return t.checkExpect(E.dailyMaxForMonth(givenData,10), expected);
  }
 
  boolean testTricky(Tester t){
	  LinkedList<MaxHzReport> expected = new LinkedList<MaxHzReport>();
	  expected.add(new MaxHzReport(1,500));
	  expected.add(new MaxHzReport(3,0.003));
	  expected.add(new MaxHzReport(12,0.04));
	  expected.add(new MaxHzReport(31,335.1));
	  
	  return t.checkExpect(E.dailyMaxForMonth(trickyData,5), expected);
	  
  }
}

