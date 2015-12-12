// three easy test cases to make sure you've implemented
//   the right interface for autograding.  Add your
//   test cases to this class.

import tester.*;

class Examples {
  
  Examples(){}
  
  // test that we can add two cell refs
  ISpreadsheet setup1() throws EmptyCellException,CyclicFormulaException{
      ISpreadsheet s = new Spreadsheet();
	      s.editContents("a10", new Num(5));
	      s.editContents("b10", new Num(3));
	      s.editContents("c10", new Plus(new CellRef("a10"), 
	                                     new CellRef("b10")));	  
      return s;	  
  }
  
  boolean testSimplePlusCellRefs(Tester t) {
    try {
      ISpreadsheet s = setup1();
      return t.checkExpect(s.lookupValue("c10"),
                           8);
    } catch (CyclicFormulaException e) {
      return t.checkExpect(false, true);
    } catch (EmptyCellException e) {
      return t.checkExpect(false, true);
    }
  }

  // test that cell refs grab current value of cells
  boolean testUpdateCellRefs(Tester t) {
    try {
      ISpreadsheet s = setup1();
      s.editContents("a10", new Num(9));
      return t.checkExpect(s.lookupValue("c10"),
                           12);
    } catch (CyclicFormulaException e) {
      return t.checkExpect(false, true);
    } catch (EmptyCellException e) {
    	System.out.printf("EmptyCell : %s %n",e.cellname);
      return t.checkExpect(false, true);
    }
  }
  
  // test a cycle through 
  boolean testCycle(Tester t) {
	  try{
		  ISpreadsheet s = setup1();
		  s.editContents("a10", new CellRef("c10"));
		  return t.checkException(new CyclicFormulaException("a10"), s, "lookupValue", "a10");
	  } catch (CyclicFormulaException e) {
		  return t.checkExpect(false, true);
	  } catch (EmptyCellException e) {
		  return t.checkExpect(false, true);
	  }
  }
	  
	  
  boolean testCycleToSelf(Tester t) {
		  try{
			  ISpreadsheet s = setup1();
			  s.editContents("a10", new CellRef("a10"));
			  return t.checkException(new CyclicFormulaException("a10"), s, "lookupValue", "a10");
		  } catch (CyclicFormulaException e) {
			  return t.checkExpect(false, true);
		  } catch (EmptyCellException e) {
			  return t.checkExpect(false, true);
		  }
  }  
  
}