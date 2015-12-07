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
		if (result.winner().equals("Team 1"))
			return team1;
		else if (result.winner().equals("Team 2"))
			return team2;
		else 
			return null;
		
					
	}
	
	// underdogWon() -> boolean
	// tells if the team that was not expected to win makes an upset
	public boolean underdogWon(){
		return (team1.expectToBeat(team2)&&result.winner().equals("Team 2"))||
				(team2.expectToBeat(team1)&&result.winner().equals("Team 1"));
	}
}
