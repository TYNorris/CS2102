
public class DataHeap implements IHeap {

	  int data;
	  IHeap left;
	  IHeap right;

	  DataHeap(int data, IHeap left, IHeap right) {
	   this.data = data;
	   this.left = left;
	   this.right = right;
	  }
	
	

	public IHeap addElt(int e) {
		if(e<data)
			return merge(new DataHeap(e,new MtHeap(),new MtHeap()), this);
		else if (left.size()<right.size()){
				left = left.addElt(e);
				return this;
			}
		else{
				right = right.addElt(e);
				return this;
			}
				
		}
		

	

/*
	public IHeap remMinElt() {
		// TODO Auto-generated method stub
		return null;
	}

*/
	public int size() {
		// Auto-generated method stub
		return 1+left.size()+right.size();
	}


	public IHeap merge(DataHeap heap1, DataHeap heap2)
	{
		if(heap1.data<heap2.data)
		{
			if(heap1.left.isEmpty()){
				heap1.left = heap2;
				return heap1;
			}
			else if(heap1.right.isEmpty()){
				heap1.right = heap2;
				return heap1;
			}
			
			else{
				if (heap1.left.size()<heap1.right.size()){
					return merge(((DataHeap)heap1.left),heap2);
				}
				else{
					return merge(((DataHeap)heap1.right),heap2);
				}
			}
		}
		else
		{
			if(heap2.left.isEmpty()){
				heap2.left = heap1;
				return heap2;
			}
			else if(heap2.right.isEmpty()){
				heap2.right = heap1;
				return heap2;
			}
			else{
				if (heap2.left.size()<heap1.right.size()){
					return merge(heap1, ((DataHeap)heap2.left));
				}
				else{
					return merge(heap1, ((DataHeap)heap2.right));
				}
			}
		}
	}
	
	public boolean isEmpty()
	{
		return false;
	}
}
