// an Advance match is new AdvanceMatch(Match, ITourneyTree, ITourneyTree)
public class AdvanceMatch implements ITourneyTree {

	Match theMatch;
	ITourneyTree feederMatch1;
	ITourneyTree feederMatch2;
	
	AdvanceMatch(Match theMatch, ITourneyTree feederMatch1, ITourneyTree feederMatch2){
		this.theMatch = theMatch;
		this.feederMatch1 = feederMatch1;
		this.feederMatch2 = feederMatch2;
	}
	
	//checks if the contestants in this match were the winners of the previous two
	public boolean winnersAlwaysAdvanced(){
		return feederMatch1.winnerMatches(this.theMatch.team1) && feederMatch2.winnerMatches(this.theMatch.team2);
	}
	
	//checks to see if the winner of this match corresponds to a given contestant
	public boolean winnerMatches(IContestant team){
		return this.theMatch.winnerMatches(team);
	}
	
	//if the underdog won, than add one and check the previous matches,
	// else just check the previous matches
	public int countUnderdogWins(){
		if (theMatch.underdogWon())
			return 1 + feederMatch1.countUnderdogWins() + feederMatch2.countUnderdogWins();
		else
			return feederMatch1.countUnderdogWins() + feederMatch2.countUnderdogWins();
	}
	
	// gives the winner of the match
	public IContestant winner(){
		return theMatch.winner();
	}
}
