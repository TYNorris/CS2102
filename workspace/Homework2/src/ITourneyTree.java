
public interface ITourneyTree {
	boolean winnerMatches(IContestant team);
	boolean winnersAlwaysAdvanced();
	
	int countUnderdogWins();
	
	public IContestant winner();
}
