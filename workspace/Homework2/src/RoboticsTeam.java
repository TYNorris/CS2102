// a RoboticsTeam is new RoboticsTeam(String, String, int)
public class RoboticsTeam implements IContestant {
	String school;
	String specialFeature;
	int rank;
	
	RoboticsTeam(String school, String specialFeature, int rank){
		this.school = school;
		this.specialFeature = specialFeature;
		this.rank = rank;
	}
		
	// a robotics team is expevted to win if their specialFeature has a longer name
	public boolean expectToBeat(IContestant other){
		return this.specialFeature.length() > ((RoboticsTeam)other).specialFeature.length();
	}
	
	public boolean contestantMatches(IContestant team){
		return this.school.equals(((RoboticsTeam)team).school)&&
				this.specialFeature.equals(((RoboticsTeam)team).specialFeature)&&
				this.rank==((RoboticsTeam)team).rank;
	}
}
