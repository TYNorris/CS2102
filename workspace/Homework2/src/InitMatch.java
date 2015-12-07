// an InitMatch is new InitMatch(Match)
public class InitMatch implements ITourneyTree {

	Match theMatch;
	
	InitMatch(Match theMatch){
		this.theMatch = theMatch;
	}
	
	//since there are no previous winners, just return true
	public boolean winnersAlwaysAdvanced(){
		return true;
	}
	
	// tells if the winner of the match corresponds to a given contestant
	public boolean winnerMatches(IContestant team){
		return this.theMatch.winnerMatches(team);
	}
	
	// if underdog won, then add 1, if not, then just return 0
	public int countUnderdogWins(){
		if (theMatch.underdogWon())
			return 1;
		else
			return 0;
	}
	
	//returns the winner of the played match
	public IContestant winner(){
		return theMatch.winner();
	}
}
