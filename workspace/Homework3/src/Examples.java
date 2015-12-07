import tester.Tester;
public class Examples {
HeapTester HT = new HeapTester();

	// check to see remove works on empty heaps
	public void testRemoveHandlesEmpty(Tester t){
		t.checkExpect(HT.remMinEltTester(new MtHeap(), new MtBT()),true);
	}
	
	
	public void testAddHandlesDuplicates(Tester t){
		DataHeap dh = new DataHeap(4,new DataHeap(6, new DataHeap(7), new DataHeap(8)),new DataHeap(5, new DataHeap(6), new MtHeap()));
		/*        4
		 *     /    \
		 *    6      5
		 *   / \    /
		 *  7   8  6
		 *  
		 */
		DataBT db = new DataBT(4,new DataBT(6, new DataBT(7), new DataBT(8)),new DataBT(5, new DataBT(6), new DataBT(8)));

		/*        4
		 *     /    \
		 *    6      5
		 *   / \    / \
		 *  7   8  6   8
		 *  
		 */
		t.checkExpect(HT.addEltTester(dh, 8, db));
	}
	
	public void testRemoveHandlesDuplicates(Tester t){
		DataHeap dh = new DataHeap(4,new DataHeap(6, new DataHeap(7), new DataHeap(8)),new DataHeap(5, new DataHeap(6), new DataHeap(8)));
		/*        4
		 *     /    \
		 *    6      5
		 *   / \    / \
		 *  7   8  6   8
		 *  
		 */
		DataBT db = new DataBT(5,new DataBT(6, new DataBT(7), new DataBT(8)),new DataBT(6, new DataBT(8), new MtBT()));

		/*        5
		 *     /    \
		 *    6      6
		 *   / \    / 
		 *  7   8   8
		 *  
		 */
		t.checkExpect(HT.remMinEltTester(dh, db), true);
	}
	
	public void testAddHandlesRootAdd( Tester t){
		DataHeap dh = new DataHeap(4,new DataHeap(6, new DataHeap(7), new DataHeap(8)),new DataHeap(5, new DataHeap(6), new MtHeap()));
		/*        4
		 *     /    \
		 *    6      5
		 *   / \    /
		 *  7   8  6
		 *  
		 */
		DataBT db = new DataBT(2,new DataBT(6, new DataBT(7), new DataBT(8)),new DataBT(4, new DataBT(5, new DataBT(6), new MtBT()), new MtBT()));

		/*        2
		 *     /    \
		 *    6      4
		 *   / \    / 
		 *  7   8  5   
		 *        /
		 *       6 
		 */
		t.checkExpect(HT.addEltTester(dh, 2, db), true);
	}
	
	public void testRemovingOnlyElt(Tester t){
		DataHeap dh = new DataHeap(77);
	    MtBT db = new MtBT();
	    t.checkExpect(HT.remMinEltTester(dh, db),true);
		
	}
	
	public void testAddingToEmpty(Tester t){
		MtHeap dh = new MtHeap();
		DataBT db = new DataBT(35);
		t.checkExpect(HT.addEltTester(dh, 35, db));
	}
	
}