import tester.Tester;

class ExamplesStack {
	
	 public void testTop(Tester t){
			IStack s1 = new Stack().push(5).push(4).push(3);
		    t.checkExpect(s1.top(),3);
		  }
	 
	 public void testPushVsPop(Tester t){
			IStack s1 = new Stack().push(5).push(4).push(3);
			 IStack s2 = new Stack().push(5).push(4);
			 t.checkExpect(s1.pop(),s2);
		  }

	 public void testPopVsIsEmpty(Tester t){
			IStack s2 = new Stack().push(5).push(4);
		    t.checkExpect(s2.pop().pop().isEmpty(),true);
		  }
	 
	 public void testPopVsTop(Tester t){
		 IStack s1 = new Stack().push(5).push(4).push(3);
		 t.checkExpect(s1.pop().top(), 4);
	 }
	 
	 public void testIsEmpty(Tester t){
		 IStack s3 = new Stack();
		 t.checkExpect(s3.isEmpty(),true);
	 }

	 public void testPushVsIsEmpty(Tester t){
		 IStack s2 = new Stack().push(5);
		 t.checkExpect(s2.isEmpty(),false);
	 }
	 
}
