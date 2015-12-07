//a RoboticsResult is new RoboticsResult(int, int, boolean, int, int, boolean)
public class RoboticsResult implements IResult{
	int team1points;
	int team2points;
	int team1tasks;
	int team2tasks;
	boolean team1fell;
	boolean team2fell;

	  RoboticsResult(int team1points, int team1tasks,
	                 boolean team1fell,
	                 int team2points, int team2tasks,
	                 boolean team2fell) {
	    this.team1points = team1points;
	    this.team2points = team2points;
	    this.team1tasks  = team1tasks;
	    this.team2tasks  = team2tasks;
	    this.team1fell = team1fell;
	    this.team2fell = team2fell;
	  }
	  
	  //RoboticsResult is valid if both teams score at most 16 points, and attempt at most 8 tasks
	  public boolean isValid(){
		  return (team1points <= 16 && team1tasks <= 8 && team2points <=16 && team2tasks <= 16);
	  }
	  
	  //Robotics Winner is whoever has more points and tasks, but losing 5 points for falling
	 public IContestant winner(IContestant team1, IContestant team2){
		int team1score = team1points + team1tasks - 5*(team1fell? 1:0) ;
		int team2score = team2points + team2tasks - 5*(team2fell? 1:0) ;
		if (team1score > team2score)
		 	return team1;
		 else if (team1score < team2score)
			return team2;
		 else
			return null;
	 }
}
