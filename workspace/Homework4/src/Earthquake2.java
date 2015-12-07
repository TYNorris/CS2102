import java.util.LinkedList;

class Earthquake2 implements IEarthquakeProbs {
  Earthquake2(){}
  
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                                  int month) {
	  LinkedList<MaxHzReport> output = new LinkedList<MaxHzReport>();
	  for(int i = 0; i<data.size();){
			  if(data.get(i)>500){ //data is a date
				  String thisDate = data.get(i).toString();
				  if(Integer.parseInt(thisDate.substring(5,7))==month){ //date is in this month
					  MaxHzReport report = new MaxHzReport(Integer.parseInt(thisDate.substring(7,9)), 0.0);
					  i++;
					  while(i<data.size()&&data.get(i)<=500){  //find every frequency
						  if(data.get(i)>report.maxReading)    //if current frequency is greater
							  report.maxReading=data.get(i);   //set max freq to current
						  i++;
					  }
					  output.add(report);			  // add day to output	  
					  }
				  else
					  i++;
			  }
			  else
				  i++;

	  }
    return output;
  }
  

}  