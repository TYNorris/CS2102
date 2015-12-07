import tester.*;
//************** Examples *************

class Examples {
Customer gompeiCust = new Customer("gompei", 1865);
 
// method to initialize a banking service with Gompei as the customer
public BankingService setUpGompei() {
 CustSet allCusts = new CustSet();
 allCusts.addCust(gompeiCust);
 return new BankingService(new AcctSet(), allCusts);
}


// a simple test case that gompei can log in
	boolean testValidLogin(Tester t) {
		try{	
			return t.checkExpect(setUpGompei().login("gompei", 1865), gompeiCust);
		} catch (LoginFailedException e){
			return t.checkExpect(false, "testValidLogin failed with exception");
		}
	}
	
	boolean testNonCustomer(Tester t) {
			return t.checkException(new LoginFailedException(), setUpGompei(), "login","Kathi", 123);
	}
	
	boolean testWrongPassword(Tester t){
		return t.checkException(new LoginFailedException(), setUpGompei(), "login", "gompei", 123);
	}

}