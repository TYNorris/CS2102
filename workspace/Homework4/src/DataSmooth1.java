import java.util.LinkedList;

class DataSmooth1 implements IDataSmoothProbs {
  DataSmooth1(){}
  
  public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
    LinkedList<Double> output = new LinkedList<Double>();
   if(phrs.size()>0)
    output.add((double)phrs.getFirst().heartRate);   //add first data point
	for(int i = 1; i< phrs.size()-1; i++){
    	int num1= phrs.get(i-1).heartRate;
    	int num2= phrs.get(i).heartRate;           //single loop to average the middles
    	int num3= phrs.get(i+1).heartRate;
    	
    	output.add((num1+num2+num3)/3.0);
    }
	   if(phrs.size()>1)
	    output.add((double)phrs.getLast().heartRate);   //add last
	  return output;
  }
}