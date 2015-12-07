import tester.*;

/*
 *     Travis Norris
 *     
 * 
 */

public class Examples {
	//Dummy Robotics Data
	RoboticsTeam cheesyPoofs = new RoboticsTeam("Bellarmine College Prep", "Is Really Good", 1);
	RoboticsTeam teamAppreciate = new RoboticsTeam("Westlake High School", "Swag", 18);
	RoboticsResult frcGame = new RoboticsResult(9,4,true, 4,3,false);
	
	//Result with impossible scores
	RoboticsResult frcGameFake = new RoboticsResult(4,2,false, 43,114,false);
	
	//Dummy Robotics Matches
	Match roboticsMatch = new Match(cheesyPoofs,teamAppreciate,frcGame);
	Match roboticsMatchFake = new Match(cheesyPoofs,teamAppreciate,frcGameFake);
	
	//Dummy Rugby Data
	RugbyTeam canada = new RugbyTeam("Canada","Red",false,7,4);
	RugbyTeam newZealand = new RugbyTeam("New Zealand","Black",true,7,1);
	RugbyTeam australia = new RugbyTeam("Australia", "Blue", true,15,2);
	RugbyTeam wpi = new RugbyTeam("WPI", "Maroon", false, 6,5);
	RugbyResult rugbyGame = new RugbyResult(55,48);
	//Result with impossible scores
	RugbyResult rugbyGameFake = new RugbyResult(256,2048);
	
	//Dummy Rugby Matches
	Match rugbyMatch = new Match(canada,newZealand,rugbyGame);
	Match rugbyMatchFake = new Match(canada,newZealand,rugbyGameFake);
	
	//Check to see if RoboticsResult.isValid() properly returns true
	 public void testRoboticsIsValidTrue(Tester t){
		    t.checkExpect(frcGame.isValid(), true);
		  }
	 
	//Check to see if RoboticsResult.isValid() properly returns false
	 public void testRoboticsIsValidFalse(Tester t){
		    t.checkExpect(frcGameFake.isValid(), false);
		  }
	 
	//Check to see if RugbyResult.isValid() properly returns true
	 public void testRugbyIsValidTrue(Tester t){
		    t.checkExpect(rugbyGame.isValid(), true);
		  }
	//Check to see if RugbyResult.isValid() properly returns false
	 public void testRugbyIsValidFalse(Tester t){
		    t.checkExpect(rugbyGameFake.isValid(), false);
		  }
	 
	//Check to see if Match.winner() properly returns team1 win
	 public void testRoboticsWinner(Tester t){
		    t.checkExpect(roboticsMatch.winner(),cheesyPoofs);
		  }
	 
	//Check to see if Match.winner() properly returns team2 win
	 public void testRoboticsWinner2(Tester t){
		    t.checkExpect(roboticsMatchFake.winner(),teamAppreciate);
		  }

	 //Check to see if Match.winner() works for rugby team 1 winning;
	 public void testRugbyWinner(Tester t){
		    t.checkExpect(rugbyMatch.winner(),canada);
		  }

	 //Checks to see if Match.winner() works for rugby team 2 winning
	 public void testRugbyWinner2(Tester t){
		    t.checkExpect(rugbyMatchFake.winner(),newZealand);
		  }
	 
	 //Checks that RoboticsTeam.expectToBeat() returns correct boolean
	 public void testRoboticsExpectTrue(Tester t){
		    t.checkExpect(cheesyPoofs.expectToBeat(teamAppreciate),true);
		  }
	 
	 //Checks that RoboticsTeam.expectToBeat() returns correct boolean
	 public void testRoboticsExpectFalse(Tester t){
		    t.checkExpect(teamAppreciate.expectToBeat(cheesyPoofs),false);
		  }

	 //Checks that RugbyTeam.expectToBeat() returns correct boolean
	 // when one has a ritual
	 public void testRugbyExpectToBeatDifferentRitual(Tester t){
		    t.checkExpect(canada.expectToBeat(newZealand),false);
		  }


	 //Checks that RugbyTeam.expectToBeat() returns correct boolean
	 // when neither has a ritual
	 public void testRugbyExpectToBeatNoRitual(Tester t){
		    t.checkExpect(canada.expectToBeat(wpi),true);
		  }


	 //Checks that RugbyTeam.expectToBeat() returns correct boolean
	 // when both have a ritual
	 public void testRugbyExpectToBeatWithRitual(Tester t){
		    t.checkExpect(australia.expectToBeat(newZealand),true);
		  }
	
}
