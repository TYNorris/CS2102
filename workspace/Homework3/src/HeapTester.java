import java.util.LinkedList;
public class HeapTester {

	  boolean addEltTester(IHeap Horig, int elt, IBinTree Hadded) {

		    return Hadded.isHeap() && Hadded.hasEveryEltOf(Horig) && checkDifferentByElt(Hadded.toList(), Horig.toList(), elt);
	  }
	  
	  boolean remMinEltTester(IHeap Horig, IBinTree Hremoved) {
		  if (Horig.size()==0 && Hremoved.size()==0)
			  return true;
		  else
		  	return Hremoved.isHeap() && Horig.hasEveryEltOf(Hremoved) && checkDifferentByElt(Horig.toList(), Hremoved.toList(), ((DataBT)Horig).data) ;
	  }
	  
	  boolean checkDifferentByElt(LinkedList<Integer> listL, LinkedList<Integer> listS, int elt)
	  {
		 if((listL.size()-1)!=listS.size())
			  return false;
		  else{
			  for(Integer s: listS){
				  if(listL.contains(s))
					  listL.removeFirstOccurrence(s);
				  else
					  return false;
			  }
			  return (listL.size()==1 && listL.contains((Integer) elt));
		  }
		  
	  }
}
