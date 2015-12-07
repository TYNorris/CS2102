
public class UnknownCandidateException extends Exception {
	String name;
	
	UnknownCandidateException(String name){
		this.name = name;
	}
}