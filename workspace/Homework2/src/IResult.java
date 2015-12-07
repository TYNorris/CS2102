
interface IResult {
	
	//isValid() -> boolean
	//tells if the match result is reasonable
	public boolean isValid();
 
	//winner()
	//returns a string based on who won
	// 	-"Team 1" if first team won
	//  -"Team 2" if second team won
	//  -"Tie" if neither team won
	
	public IContestant winner(IContestant team1, IContestant team2);
}
