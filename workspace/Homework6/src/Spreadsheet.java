import java.util.HashMap;
import java.util.LinkedList;
// you will need to throw the CyclicFormulaException and 
// the EmptyCellException from one of these methods, but can
// leave the header of the other unchanged.

class Spreadsheet implements ISpreadsheet {
  HashMap<String,IFormula> data = new HashMap<String,IFormula>();
  Spreadsheet(){}
  
  // associates the given cellname with the given formula
  //   such that subsequent references to the cell yield the formula
  public void editContents(String cellname, IFormula expr) {
	  expr.setCell(cellname);
	  data.put(cellname, expr);
  }
  
  // compute the current value of the named cell
  public Integer lookupValue(String forcell) throws EmptyCellException, CyclicFormulaException{
	  IFormula theCell = data.get(forcell);
	  if(theCell != null){
	  return lookupValueWithCycles(data.get(forcell), new LinkedList<String>());
	  }
	  else
		  throw new EmptyCellException(forcell);
  }

	  
  private Integer lookupValueWithCycles(IFormula theCell, LinkedList<String> referenced) throws EmptyCellException, CyclicFormulaException{
	  if(theCell != null){
		  if(theCell.noRefs()){
			  return new Integer(theCell.valueOf());
		  }
		  else if (theCell.isPlus())
		  {
			  Plus plus = ((Plus)theCell);
			  return new Integer(lookupValueWithCycles(plus.right, referenced).intValue() + 
					  			 lookupValueWithCycles(plus.left, referenced).intValue());
		  }
		  else if(theCell.isRef())
		  {
			  String nextCell = ((CellRef)theCell).refCell;
			  if(referenced.contains(nextCell)) {
				  throw new CyclicFormulaException(nextCell);
			  }
			  else{
				  referenced.add(nextCell);
				  IFormula nextFormula = data.get(nextCell);
				  if(nextFormula != null){  
				  return lookupValueWithCycles(nextFormula, referenced);
				  }
				  else{
					  throw new EmptyCellException(nextCell);
				  }
			  }
		  }
	  }

		  throw new EmptyCellException(theCell.getCell());
  }
  
		  
		  
	  


  
}