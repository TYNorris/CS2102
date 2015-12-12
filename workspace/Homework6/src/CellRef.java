// class for capturing references to cells in formulas

class CellRef implements IFormula {
  String refCell;
  String thisCell;
  
  CellRef(String cellname) {
    this.refCell = cellname;
    this.thisCell = "";
  }
  
  // does formula reference other cells?
  public boolean noRefs() {
    return false;
  }
  
  // compute value of formula
  public int valueOf() {
    // replace or edit the next line as part of your work
    throw new RuntimeException("Unresolved cell reference");
  }

  public String getCell() {
	  return thisCell;
  }

  public void setCell(String cellname) {
	  this.thisCell = cellname;
	
  }

  public boolean isRef() {
	  return true;
  }

  public boolean isPlus() {
	  return false;
  }	
}
