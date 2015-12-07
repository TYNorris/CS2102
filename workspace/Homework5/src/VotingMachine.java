import java.util.Scanner;

public class VotingMachine {
	Scanner keyboard = new Scanner(System.in);
	ElectionData ED = new ElectionData();
	
	public void printBallot() {
		 System.out.println("The candidates are ");
		 ED.printBallot();
	   }
	  
	  public void screen() {
	    this.printBallot();
	    System.out.println("Neter your three votes");
	    String first = keyboard.next();
	    String second = keyboard.next();
	    String third = keyboard.next();
	    try{
	    	ED.processVote(first,second,third);
	    }
	    catch (DuplicateVotesException e){
	    	System.out.println("You may not vote for the same person twice. Try again");
	    	System.out.printf("You voted for %s twice %n",e.name);
	    	screen();	
	    }
	    catch (UnknownCandidateException e){
	    	System.out.printf("%s is not on the ballot. Try again.", e.name);
	    	screen();
	    }
	    System.out.println("Thank you for voting");
	  }
}
