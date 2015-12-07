// a RugbyResult is new RugbyResult(int, int)
public class RugbyResult implements IResult {
	int team1points;
	int team2points;
	
	 RugbyResult(int team1points, int team2points) {
	     this.team1points = team1points;
	     this.team2points = team2points;
	  }
	 //RugbyResults are valid if both scores are below 150
	 public boolean isValid(){
		 return team1points <= 150 && team2points <= 150;
	 }
	 
	 //Winner of rugby result is whoever has more points
	 public IContestant winner(IContestant team1, IContestant team2){
		 if (team1points > team2points)
		 	return team1;
		 else if (team1points < team2points)
			 return team2;
		 else
			 return null;
	 }
}
