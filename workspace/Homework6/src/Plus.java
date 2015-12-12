// Class for addition formulas

class Plus implements IFormula {
  IFormula left;
  IFormula right;
  String thisCell;
  
  Plus(IFormula left, IFormula right) {
    this.left = left;
    this.right = right;
    thisCell = "";
  }
  
  // does formula reference other cells?
  public boolean noRefs() {
    return this.left.noRefs() && this.right.noRefs();
  }
  
  // compute value of formula
  public int valueOf(){

    return this.left.valueOf() + this.right.valueOf();
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
	  return true;
  }	

}