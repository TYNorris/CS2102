import tester.Tester;

class ExamplesQueue {
	
	 public void testFront(Tester t){
		 	IQueue q1 = new Queue().enqueue(5).enqueue(4);
		    t.checkExpect(q1.front(),5);
		  }
	 
	 public void testEnqueVsDeque(Tester t){
		IQueue q1 = new Queue().enqueue(5).enqueue(4).enqueue(3);
		IQueue q2 = new Queue().enqueue(4).enqueue(3);
		t.checkExpect(q1.dequeue(),q2);
	 }
	
	 public void testDequeToIsEmpty(Tester t){
			IQueue q2 = new Queue().enqueue(4).enqueue(3);
			t.checkExpect(q2.dequeue().dequeue().isEmpty(),true);
		 }
	
	 public void testDequeToFront(Tester t){
		 IQueue q2 = new Queue().enqueue(4).enqueue(3);
		 t.checkExpect(q2.dequeue().front(),3);
	 }
	 
	 public void testIsEmpty(Tester t){
			IQueue q3 = new Queue();
			 t.checkExpect(q3.isEmpty(),true);
		 }
	 
	 public void testFrontAfterDeque(Tester t){
			IQueue q1 = new Queue().enqueue(5).enqueue(4).enqueue(3).dequeue();
		    t.checkExpect(q1.front(),4);
		  }

	 public void testEnqueToIsEmpty(Tester t){
			IQueue q2 = new Queue().enqueue(4).enqueue(3);
			 t.checkExpect(q2.isEmpty(),false);
		 }
}
