import tester.* ;
  
class Main {
  static Examples E = new Examples () ;
  static BankingService B;
  
  public static void main(String[] args) {
    //Tester.runReport (E, false, false) ;

	  Customer gompeiCust = new Customer("gompei", 1865);
	  Account gAccount = new Account(150,12.0);
	  AcctSet allAccounts = new AcctSet();
	  CustSet allCusts = new CustSet();
	  allCusts.addCust(gompeiCust);
	  //allAccounts.
	  B = new BankingService(new AcctSet(), allCusts);
	  B.loginScreen();
  
  }
}