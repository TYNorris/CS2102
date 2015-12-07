import java.util.Collections;
import java.util.LinkedList;

class Earthquake1 implements IEarthquakeProbs {
  Earthquake1(){}
  
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                                  int month) {
	  LinkedList<LinkedList<Double>> allDays = new LinkedList<LinkedList<Double>>();  //create a new list for all of the days of the month
	  LinkedList<MaxHzReport> output = new LinkedList<MaxHzReport>();    //create a list to hold the output
	  for(int i = 0; i<data.size();){      //for every number in Data
			  if(data.get(i)>500.){ 		//data is a date
				  String thisDate = data.get(i).toString();
				 if(Integer.parseInt(thisDate.substring(5,7))==month){ 		//date is in this month
				  MaxHzReport report = new MaxHzReport(Integer.parseInt(thisDate.substring(7,9)), 0.0); //get day
				  LinkedList<Double> thisDateFreqs = new LinkedList<Double>();
				  i++;
				  while(i<data.size()&&data.get(i)<=500){   //record all frequencies for the day
					  thisDateFreqs.add(data.get(i));
					  i++;
				  }
				  output.add(report);        //add date and all frequencies to the list
				  allDays.add(thisDateFreqs);
				  }
				 else
					 i++;
			  }
			  else
				  i++;
	  }
	 for(int i = 0; i<output.size()&&i<allDays.size();i++){  //find greatest frequency
		Collections.sort(allDays.get(i));
		output.get(i).maxReading = allDays.get(i).getLast();
	  }
    return output;
  }

}  
