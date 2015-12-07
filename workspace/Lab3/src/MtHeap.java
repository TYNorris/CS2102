
public class MtHeap implements IHeap {


	public IHeap addElt(int e) {
		
		return new DataHeap(e,new MtHeap(), new MtHeap());
	}
/*
	@Override
	public IHeap remMinElt() {
		// TODO Auto-generated method stub
		return null;
	}

*/
	public int size() {
		return 0;
	}

	public boolean isEmpty()
	{
		return true;
	}
}
