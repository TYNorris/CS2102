import java.util.LinkedList;

public class ElectionData {



	  private LinkedList<String> ballot = new LinkedList<String>();
	  private Votes votes = new Votes();
	  	  
	  ElectionData() {
	  }
	  
	  void processVote(String first, String second, String third) throws DuplicateVotesException, UnknownCandidateException{
		  votes.processVote(first, second, third);
	  }
	  
	  public LinkedList<String> getBallot(){
		  return ballot;
	  }
	  
	  public Votes getVotes(){
		  return votes;
	  }
	  
	  public String findWinnerMostFirstVotes(){
		  return  votes.findWinnerMostFirstVotes();
	  }
	  
	  public String findWinnerMostPoints(){
		  return votes.findWinnerMostPoints();
	  }
	  public void addCandidate(String cand) throws CandidateExistsException {
			ballot.add(cand);
			votes.addCandidate(cand);
	  }
	  
	  public void printBallot(){
		  for (String s : ballot) {
			    System.out.println(s);
			 }
	  }

	  
	  
	  
}
