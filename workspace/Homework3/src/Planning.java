import java.util.LinkedList;
public class Planning {

	
	//rainfall(LinkedList<Double>) -> double
	//gives the average of positive values, and stops at -999
	public double rainfall(LinkedList<Double> readings){
		double sum= 0;     //data recording variables
		int count = 0;    
		for(double num : readings){  //go through every element
			if(num==-999.0)     //stop at -999
				break;
			else if (num >= 0){ ///if it's positive, add to sum and increase count
				sum += num;
				count++;
			}
		}
		if (count>0)    //if there is data, give average
		return sum/count;
		else            //otherwise, give -1
		return -1;
	}
	
	
	//maxTripleLength(LinkedLast<String>) -> int
	// returns the maximum number of characters in 3 adjacent strings in the list
	public int maxTripleLength(LinkedList<String> elts){
		int max = 0;
		for(int i=0; i<elts.size()-2; i++)   //start at every element except the last two
		{
			int length = elts.get(i).length()+elts.get(i+1).length()+elts.get(i+2).length(); 
			if (length > max)   //if the calculated length is longer, it becomes the new max
				max = length;
		}
		return max;
	}
}
