import java.util.LinkedList;
import java.util.HashMap;


public class Votes {
	
	private LinkedList<String> candidates = new LinkedList<String>();
	private HashMap<String,Integer> numFirstVotes = new HashMap<String,Integer>();
	private HashMap<String,Integer> numSecondVotes = new HashMap<String,Integer>();
	private HashMap<String,Integer> numThirdVotes = new HashMap<String,Integer>();
	private boolean initialized = false;
	
	Votes(){
		
	}

	public void processVote(String first, String second, String third) throws DuplicateVotesException,UnknownCandidateException {
		if (initialized){
			if (allValid(first,second,third)){
					addVoteTo(numFirstVotes,first);
					addVoteTo(numSecondVotes,second);
					addVoteTo(numThirdVotes,third);
			}
		}
		else{
			init();
			processVote(first,second,third);
		}
	}
	
	public void addCandidate(String cand) throws CandidateExistsException{
		if(!candidates.contains(cand)){
			candidates.add(cand);
			numFirstVotes.put(cand, new Integer(0));
			numSecondVotes.put(cand, new Integer(0));
			numThirdVotes.put(cand, new Integer(0));	
		}
		else
			throw new CandidateExistsException(cand);
	}
	
	
	public String findWinnerMostFirstVotes(){
		String currentWinner = "";
		int mostVotes = 0;
		for(String cand : candidates){
			if (numFirstVotes.get(cand).intValue()>mostVotes){
				currentWinner = cand;
				mostVotes = numFirstVotes.get(cand).intValue();
			}
		}
		return currentWinner;
	}
	
	public String findWinnerMostPoints(){
		String currentWinner = "";
		int mostPoints = 0;
		for(String cand : candidates){
			int currentPoints = getPoints(cand);
			if (currentPoints > mostPoints){
				currentWinner = cand;
				mostPoints = currentPoints;
			}
		}
		return currentWinner;
	}
	
	public String toString(){
		return candidates.toString();
	}
	//################ HELPER FUNCTIONS ###################
	private void addVoteTo(HashMap<String,Integer> votes, String candidate){
		votes.put(candidate,((Integer)numFirstVotes.get(candidate).intValue()+1));
	}
	
	private void init(){
		if(!initialized){
		for(String cand : candidates){
			numFirstVotes.put(cand, new Integer(0));
			numSecondVotes.put(cand, new Integer(0));
			numThirdVotes.put(cand, new Integer(0));
		}
		initialized = true;
		}
	}
	
	private boolean allValid(String first, String second, String third) throws DuplicateVotesException,UnknownCandidateException {

		if(!candidates.contains(first) && !candidates.contains(second) && !candidates.contains(third)){
			if(!candidates.contains(first)){
				throw new UnknownCandidateException(first);
			}
			else if(!candidates.contains(second)){
				throw new UnknownCandidateException(second);
			}
			else{
				throw new UnknownCandidateException(third);
			}
		} 
		else if(first.equals(second) || second.equals(third) || third.equals(first)){
			if(first.equals(second)){
				throw new DuplicateVotesException(first);
			}
			else{
				throw new DuplicateVotesException(third);
			}
			
		}
		else{
			return true;
		}
	}
	
	private int getPoints(String cand){
		return 3*numFirstVotes.get(cand).intValue() + 2*numSecondVotes.get(cand).intValue() + numThirdVotes.get(cand).intValue();
	}
	
	
	
}
