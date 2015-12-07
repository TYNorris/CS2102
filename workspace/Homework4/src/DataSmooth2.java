import java.util.LinkedList;

class DataSmooth2 implements IDataSmoothProbs {
  DataSmooth2(){}
  
  public LinkedList<Double> dataSmooth(LinkedList<PHR> phrs) {
	  LinkedList<Triples> trips = new LinkedList<Triples>();   //convert to sets of three ints
	  LinkedList<Double> output = new LinkedList<Double>();
	  for(int i=0; i<phrs.size()-2;i++){
		  trips.add(new Triples(phrs.get(i).heartRate
				  ,phrs.get(i+1).heartRate
				  ,phrs.get(i+2).heartRate));
	  }
	  if(phrs.size()>0)
		  output.add((double)phrs.getFirst().heartRate);   //add first
	  for(Triples trip : trips){
		  output.add(trip.average());                      //add average of every set of 3
	  }
	  if(phrs.size()>1)
		 output.add((double)phrs.getLast().heartRate);     //add last
	  
    return output;
  }
}