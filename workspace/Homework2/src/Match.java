// a match is new Match(IContestant, IContestant, IResult)
public class Match {
	

	IContestant team1;
	IContestant team2;
	IResult result;
	
	Match(IContestant team1, IContestant team2, IResult result){
		this.team1 = team1;
		this.team2 = team2;
		this.result = result;
	}
	
	// winner() -> IContestant
	// returns the winner of the match
	//      or null if a tie
	public IContestant winner(){
		return result.winner(team1,team2);
		
					
	}
	
	// underdogWon() -> boolean
	// tells if the team that was not expected to win makes an upset
	public boolean underdogWon(){
		return (team1.expectToBeat(team2)&&result.winner(team1,team2).contestantMatches(team2))||
				(team2.expectToBeat(team1)&&result.winner(team1,team2).contestantMatches(team1));
	}
	
	boolean winnerMatches(IContestant team){
		return result.winner(team1,team2).contestantMatches(team);
	}
}
