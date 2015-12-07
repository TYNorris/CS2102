
public interface IContestant {
	// expectToBeat(IContestant) -> boolean
	// takes a Contestant and returns if the referenced contestant will win
	boolean expectToBeat(IContestant other);
}
