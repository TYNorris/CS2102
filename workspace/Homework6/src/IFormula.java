// The interface for formulas -- you may change any part of this but the interface name  
interface IFormula {
  // does formula reference other cells?
  boolean noRefs();
  // compute value of formula; starter code throws exception on cellRefs
  int valueOf();
  // tells what cell this formula is associated with
  String getCell();
  // sets the location of the formula to a cell
  void setCell(String cellname);
  // tells what type the cell is
  boolean isRef();
  boolean isPlus();
}





