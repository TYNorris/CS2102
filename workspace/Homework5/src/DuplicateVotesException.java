
public class DuplicateVotesException extends Exception {
	String name;
	
	DuplicateVotesException(String name){
		this.name = name;
	}
}
