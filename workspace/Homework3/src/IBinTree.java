import java.util.LinkedList;

public interface IBinTree {
		 // determines whether element is in the tree
		 boolean hasElt(DataBT e);
		 // returns number of nodes in the tree; counts duplicate elements as separate items
		 int size();
		 // returns depth of longest branch in the tree
		 int height();
		 
		 boolean isHeap();
		 
		 boolean dataBiggerThan(int num);
		 
		 boolean hasEveryEltOf(IBinTree subTree);
		 
		 LinkedList<Integer> toList();
		 
		 		 
}
