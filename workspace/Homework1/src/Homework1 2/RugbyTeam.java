// a RugbyTeam is new RugbyTeam(String, String, boolean, int, int)
public class RugbyTeam implements IContestant{
	String country;
	String jerseyColor;
	boolean hasRitual;
	int wins;
	int losses;
	
	RugbyTeam(String country, String jerseyColor, boolean hasRitual, int wins, int losses){
		this.country = country;
		this.jerseyColor = jerseyColor;
		this.hasRitual = hasRitual;
		this.wins = wins;
		this.losses = losses;
	}
	
	//a rugby team is expected to win if
	//    - it has a ritual and the other team doesnt
	//    - neither team has a ritual, and the team has a better W/L record
	public boolean expectToBeat(IContestant other){
		RugbyTeam otherTeam = ((RugbyTeam) other);
		return !(otherTeam.hasRitual && !this.hasRitual) &&
					((this.hasRitual && !otherTeam.hasRitual) ||
					(((double)this.wins)/this.losses) > (((double) otherTeam.wins)/otherTeam.losses));
	}
}
