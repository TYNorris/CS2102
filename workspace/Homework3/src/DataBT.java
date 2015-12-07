import java.util.LinkedList;
public class DataBT implements IBinTree {
	int data;
	 IBinTree left;
	 IBinTree right;
	 boolean beenUsed;

	 DataBT(int data, IBinTree left, IBinTree right) {
	  this.data = data;
	  this.left = left;
	  this.right = right;
	  this.beenUsed= false;
	 }
	 
	 // an alternate constructor for when both subtrees are empty
	 DataBT(int data) {
	   this.data = data;
	   this.left = new MtBT();
	   this.right = new MtBT();
	   this.beenUsed = false;
	 }

	 // determines whether this node or node in subtree has given element
	 public boolean hasElt(DataBT e) {
		 if(this.data == e.data && !e.beenUsed && !this.beenUsed){
			 e.beenUsed = true;
			 this.beenUsed = true;
			 return true;
		 }
		 else
			 return  this.left.hasElt(e) || this.right.hasElt(e) ;
	 }

	 // adds 1 to the number of nodes in the left and right subtrees
	 public int size() {
	  return 1 + this.left.size() + this.right.size();
	 }

	 // adds 1 to the height of the taller subtree
	 public int height() {
	  return 1 + Math.max(this.left.height(), this.right.height());
	 }
	 
	 public boolean isHeap(){
		 return left.isHeap()&&right.isHeap()&&left.dataBiggerThan(this.data)&&right.dataBiggerThan(this.data);
	 }
	 
	 public boolean dataBiggerThan(int num){
		 return this.data>=num;
	 }
	 
	 public boolean hasEveryEltOf(IBinTree subTree){
		if(subTree.size()==0)
			return true;
		else 
			return this.hasElt((DataBT)subTree)
				 &&this.hasEveryEltOf(((DataBT)subTree).left)
				 &&this.hasEveryEltOf(((DataBT)subTree).right);
	 }
	 
	 public LinkedList<Integer> toList(){
		 LinkedList<Integer> output = new LinkedList<Integer>();
		 output.add(data);
		 output.addAll(this.left.toList());
		 output.addAll(this.right.toList());
		 return output;
	 }
	
	 
}
