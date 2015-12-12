// class for simple formulas consisting of just a single number

class Num implements IFormula {
  int value;
  String thisCell;
  
  Num(int value) {
    this.value = value;
    this.thisCell = "";
  }
  
  // does formula reference other cells?
  public boolean noRefs() {
    return true;
  }
  
  // compute value of formula
  public int valueOf() {
    return this.value;
  }

  public String getCell() {
	  return thisCell;
  }

  public void setCell(String cellname) {
	  this.thisCell = cellname;
	
  }

  public boolean isRef() {
	  return false;
  }

  public boolean isPlus() {
	  return false;
  }	
 
}