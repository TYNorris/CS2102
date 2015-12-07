import tester.*;

/*
 *     Travis Norris
 *     Homework 1
 * 
 */

class Examples {
	
	/*
	 *   ROBOTICS TOURNAMENT BREAKDOWN
	 *                                                   Robonauts    vs OP Robotics [w]
	 *                                                     /                         \
	 *                         CheesyPoofs vs Robonauts[w]                             Simbotic vs OP Robotics [w]
	 *                            /                   \                                 /                          \
	 *CheesyPoofs [w] vs Team Appreciate      Texas Torque vs Robonoauts [w]   Robowranglers vs Simbotic [w]    OP Robotics [w] vs Hawaiian Kids 
	 *
	 * (2 Underdog Wins)
	*/
	
	
	//Dummy Robotics Teams
	RoboticsTeam cheesyPoofs = new RoboticsTeam("Bellarmine College Prep", "Is Always Really Really Good", 1);
	RoboticsTeam teamAppreciate = new RoboticsTeam("Westlake High School", "Swag", 18);
	RoboticsTeam texasTorque = new RoboticsTeam("The Woodlands", "One time world champs", 3);
	RoboticsTeam robonauts = new RoboticsTeam("NASA", "NASA engineers",2);
	RoboticsTeam robowranglers = new RoboticsTeam("Greenville?", "VEX is helpful", 4);
	RoboticsTeam simbotic = new RoboticsTeam("Canada somewhere", "Always partner with OP", 5);
	RoboticsTeam opRobotics = new RoboticsTeam("Canada nearby somehwere", "Has never lost a regional", 6);
	RoboticsTeam hawaiianKids = new RoboticsTeam("On an Island", "KING KAMAYHAMAYHA", 7);
	
	//Dummy Robotics Results
	RoboticsResult oRes1 = new RoboticsResult(12,5,false, 7,2,true); //t1 wins
	RoboticsResult oRes2 = new RoboticsResult(4,1,false, 8,3,false); //t2 wins
	RoboticsResult oRes3 = new RoboticsResult(5,3,true, 10,7,false); //t2 wins
	RoboticsResult oRes4 = new RoboticsResult(10,7,false, 2,1, true);//t1 wins
	RoboticsResult oRes5 = new RoboticsResult(3,2,true, 4,4,false);  //t2 wins
	RoboticsResult oRes6 = new RoboticsResult(5,6,false, 10,6,false);//t2 wins
	RoboticsResult oRes7 = new RoboticsResult(7,7,false, 10,7,false);//t2 wins

	//Dummy Robotics Matches
	Match oMatch1 = new Match(cheesyPoofs,teamAppreciate,oRes1); //t1 wins, expected
	Match oMatch2 = new Match(texasTorque, robonauts, oRes2); //t2 wins, underdog
	Match oMatch3 = new Match(robowranglers,simbotic, oRes3); //t2 wins, expected
	Match oMatch4 = new Match(opRobotics, hawaiianKids, oRes4); //t1 wins, expected
	Match oMatch5 = new Match(cheesyPoofs, robonauts, oRes5); //t2 wins, underdog
	Match oMatch6 = new Match(simbotic, opRobotics, oRes6); //t2 wins,  expected
	Match oMatch7 = new Match(robonauts, opRobotics, oRes6); // t2 wins, expected
	
	// ITourneyTree Objects
	InitMatch oQF1 = new InitMatch(oMatch1);
	InitMatch oQF2 = new InitMatch(oMatch2);
	InitMatch oQF3 = new InitMatch(oMatch3);	
	InitMatch oQF4 = new InitMatch(oMatch4);
	AdvanceMatch oSF1 = new AdvanceMatch(oMatch5, oQF1,oQF2);
	AdvanceMatch oSF2 = new AdvanceMatch(oMatch6, oQF3,oQF4);
	AdvanceMatch oTournament = new AdvanceMatch(oMatch7, oSF1,oSF2);

	
	
	/*___________________________________________________________________________
	 * 
	 * 
	 * RUGBY TOURNAMENT BREAKDOWN
	 *                            newZealand [w] vs WPI
	 *                            /                   \
	 *               canada vs newZealand [w]      austalia vs WPI [w]
	 * 
	 * (1 underdog win)
	 */
	
	//Dummy Rugby Data
	RugbyTeam canada = new RugbyTeam("Canada","Red",false,7,4);
	RugbyTeam newZealand = new RugbyTeam("New Zealand","Black",true,7,1);
	RugbyTeam australia = new RugbyTeam("Australia", "Blue", true,15,2);
	RugbyTeam wpi = new RugbyTeam("WPI", "Maroon", false, 6,5);

	//Dummy Rugby Results
	RugbyResult uRes1 = new RugbyResult(45,86); // t2 wins
	RugbyResult uRes2 = new RugbyResult(56,58); // t2 wins
	RugbyResult uRes3 = new RugbyResult(40,16); // t1 wins
	
	//Rugby Matches
	Match uMatch1 = new Match(canada,newZealand,uRes1); // t2 wins, expected
	Match uMatch2 = new Match(australia, wpi, uRes2); // t2 wins, underdog
	Match uMatch3 = new Match(newZealand, wpi, uRes3); //t1 wins, expected
	
	//ITourneyTree objects
	InitMatch uSF1 = new InitMatch(uMatch1);
	InitMatch uSF2 = new InitMatch(uMatch2);
	AdvanceMatch uTournament = new AdvanceMatch(uMatch3, uSF1, uSF2);



	//Check to see if Rugby Underdogs count correctly
	 public void testRugbyUnderdogs(Tester t){
		 t.checkExpect(uTournament.countUnderdogWins(), 1);
	 }
	 

	//Check to see if Robotics Underdogs count correctly
	 public void testRoboticsUnderdogs(Tester t){
		 t.checkExpect(oTournament.countUnderdogWins(), 2);
	 }

	//Check to see if Rugby Winners advance correctly
	 public void testRugbyWinnersAdvance(Tester t){
		 t.checkExpect(uTournament.winnersAlwaysAdvanced(),true);
	 }

	//Check to see if Robotics winners advance correctly
	 public void testRoboticsWinnersAdvance(Tester t){
		 t.checkExpect(oTournament.winnersAlwaysAdvanced(),true);
	 }

	//Check to see if rugby winners fail correctly
	 public void testRugbyWinnersAdvanceFalse(Tester t){
		 Match falseMatch = new Match(australia, newZealand, uRes3);
		 AdvanceMatch falseUTourney = new AdvanceMatch(falseMatch, uSF1, uSF2);
		 t.checkExpect(falseUTourney.winnersAlwaysAdvanced(),false);
	 }

		//Check to see if Robotics winners fail correctly
	 public void testRoboticsWinnersAdvanceFalse(Tester t){
		 Match falseMatch = new Match(teamAppreciate,robonauts, oRes5);
		 AdvanceMatch falseOTourney = new AdvanceMatch(falseMatch, oQF1, oQF2);
		 t.checkExpect(falseOTourney.winnersAlwaysAdvanced(),false);
	 }

}
