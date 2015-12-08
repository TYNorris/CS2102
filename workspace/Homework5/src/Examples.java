import tester.*;
public class Examples {
	
	 // method to set up a ballot and cast votes
	  ElectionData Setup1 () {
	    ElectionData ED = new ElectionData();
	
	    try {
		    // put candidates on the ballot
		  ED.addCandidate("gompei");
		  ED.addCandidate("husky");
		  ED.addCandidate("ziggy");
		  ED.addCandidate("freddy");	
		  ED.addCandidate("steven");	

		    // cast votes
	      ED.processVote("gompei", "husky", "ziggy");    //Gompei Has most 1st
	      ED.processVote("gompei", "freddy", "husky");   //Freddy Has most 2nd
	      ED.processVote("ziggy", "husky", "gompei");    //Ziggy Has most 3rd
	      ED.processVote("husky", "freddy", "ziggy");    //Husky has most points
	      ED.processVote("steven", "freddy", "ziggy");
	    } catch (Exception e) {}
	    return(ED);
	  }
	  
	  ElectionData Setup2(){
		  ElectionData ED = Setup1();
		  try{
		  ED.addCandidate("bill");
		  
		  ED.processVote("husky", "gompei", "bill");
		  ED.processVote("husky", "gompei", "bill");
		  ED.processVote("ziggy", "gompei", "bill");
		  ED.processVote("steven", "gompei", "bill");
		  
		  }
		  catch(Exception e){}
		  
		  return ED;
	  }
	  
	  
	  boolean testMostFirstWinner (Tester t) {
	    return t.checkExpect(Setup1().findWinnerMostFirstVotes(),
	                         "gompei");
	  }
	  
	  boolean testMostFirstWinnerAfterNewCandidateAdded (Tester t) {
		    return t.checkExpect(Setup2().findWinnerMostFirstVotes(),
		                         "husky");
		  }
	  
	  boolean testMostPoints (Tester t) {
		    return t.checkExpect(Setup1().findWinnerMostPoints(),
		                         "husky");
	  }
	  
	  boolean testMostPointsAfterNewCandidateAdded (Tester t) {
		    return t.checkExpect(Setup2().findWinnerMostPoints(),
		                         "gompei");
		  }
	  
	  boolean testAddingExistingCandidate (Tester t) {
		  ElectionData ED = Setup1();
		    return t.checkException(new CandidateExistsException("husky"), ED, "addCandidate",
		                         "gompei");
		  }

	  boolean testUnkonwnFirstWithDuplicateVote (Tester t) {
		  ElectionData ED = Setup1();
		    return t.checkException(new UnknownCandidateException("bob"), ED, "processVote",
		                         "bob","ziggy","ziggy");
		  }

	  boolean testUnkonwnSecondtWithDuplicateVote (Tester t) {
		  ElectionData ED = Setup1();
		    return t.checkException(new UnknownCandidateException("bob"), ED, "processVote",
		                         "ziggy","bob","ziggy");
		  }
	  
	  boolean testUnkonwnThirdWithDuplicateVote (Tester t) {
		  ElectionData ED = Setup1();
		    return t.checkException(new UnknownCandidateException("bob"), ED, "processVote",
		                         "ziggy","ziggy","bob");
		  }
	  
	  boolean testUnkonwnCandidateFirst (Tester t) {
		  ElectionData ED = Setup1();
		    return t.checkException(new UnknownCandidateException("joe"), ED, "processVote",
		                         "joe","ziggy","gompei");
		  }
	  
	  boolean testUnkonwnCandidateSecond (Tester t) {
		  ElectionData ED = Setup1();
		    return t.checkException(new UnknownCandidateException("joe"), ED, "processVote",
		                         "ziggy","joe","gompei");
		  }
	  
	  boolean testUnkonwnCandidateThird (Tester t) {
		  ElectionData ED = Setup1();
		    return t.checkException(new UnknownCandidateException("joe"), ED, "processVote",
		                         "ziggy","gompei","joe");
		  }

}
