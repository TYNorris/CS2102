import tester.Tester;

class ExamplesPQ {

	public void testAddVsGetMin(Tester t){
		IPriorityQueue pq1 = new PriorityQueue().addElt(5).addElt(3).addElt(4);
		t.checkExpect(pq1.getMinElt(),3);
	}
	
	public void testAddVsRem(Tester t){
		IPriorityQueue pq1 = new PriorityQueue().addElt(5).addElt(3).addElt(4);
		IPriorityQueue pq2 = new PriorityQueue().addElt(4).addElt(5);
		t.checkExpect(pq1.remMinElt(),pq2);
	}
	
	public void testAddVsIsEmpty(Tester t){
		IPriorityQueue pq2 = new PriorityQueue().addElt(4).addElt(5);
		t.checkExpect(pq2.isEmpty(),false);
	}
	
	public void testRemVsGetMin(Tester t){
		IPriorityQueue pq1 = new PriorityQueue().addElt(5).addElt(3).addElt(4);
		t.checkExpect(pq1.remMinElt().getMinElt(),4);
	}
	
	public void testRemVsIsEmpty(Tester t){
		IPriorityQueue pq2 = new PriorityQueue().addElt(4).addElt(5);
		t.checkExpect(pq2.remMinElt().remMinElt().isEmpty(),true);
	}
	
	public void testIsEmpty(Tester t){
		IPriorityQueue pq3 = new PriorityQueue();
		t.checkExpect(pq3.isEmpty(), true);
	}
}
