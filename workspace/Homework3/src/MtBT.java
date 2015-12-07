import java.util.LinkedList;
public class MtBT implements IBinTree {
	public MtBT(){}

	 // returns false since empty tree has no elements
	 public boolean hasElt(DataBT e) {
	  return false;
	 }

	 // returns 0 since empty tree has no elements
	 public int size() {
	  return 0;
	 }

	 // returns 0 since empty tree has no branches
	 public int height() {
	  return 0;
	 }
	 
	 public boolean isHeap(){
		 return true;
	 }
	 
	 public boolean dataBiggerThan(int num){
		 return true;
	 }
	 
	 public boolean hasEveryEltOf(IBinTree subTree){
		 if (subTree.size()==0)
			 return true;
		 else
			 return false;
	 }
	 
	 public LinkedList<Integer> toList(){
		 return new LinkedList<Integer>();
	 }
}
