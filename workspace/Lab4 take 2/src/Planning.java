import java.util.*;
import java.util.stream.*;
public class Planning {
	
	
	//it took 30 minutes to get Java 8 actually running, but now it works
	public double rainfall(List<Integer> readings){
		long count = 0;
		double sum = 0;
		IntStream readingStream = readings.subList(0, readings.indexOf(-999)).stream().mapToInt(num -> num);
		sum = readingStream.filter(num -> num > 0).sum();
		count = readingStream.filter(num -> num > 0).count();
		
		if(count>0)
			return sum/count;
		else
			return -1;
	}
}
