import tester.*;

public class Examples {

	Shark babyShark = new Shark(4,0);
	Shark jaws = new Shark(400, 400);
	Boa evilBoa = new Boa("Vampire", 12, "people");
	Boa niceBoa = new Boa("Daisy", 8, "carrots");
	Fish nemo = new Fish(4,3.5);
	
	// tests to see if shark.isNormalSize() calls fish version
	public void testSharkSmallSize(Tester t){
	    t.checkExpect(babyShark.isNormalSize(), false);
	}
	   
	// makes sure shark properly measures size
	public void testSharkNormalSize(Tester t){
		t.checkExpect(jaws.isNormalSize(), true);
	}
	
	// shark with many attacks is dangerous
	public void testSharkDangerTrue(Tester t){
		t.checkExpect(jaws.isDangerToPeople(),true);
	}
	
	// shark with no attacks is not dangerous
	public void testSharkDangerFalse(Tester t){
		t.checkExpect(babyShark.isDangerToPeople(),false);
	}
	
	//  boa that eats people is dangerous
	public void testBoaDangerTrue(Tester t){
		t.checkExpect(evilBoa.isDangerToPeople(),true);
	}
	
	// boa that doesn't eat people is safe
	public void testBoaDangerFalse(Tester t){
		t.checkExpect(niceBoa.isDangerToPeople(),false);
	}
	
	// harmless animal is safe
	public void testHarmlessAnimalDanger(Tester t)
	{
		t.checkExpect(nemo.isDangerToPeople(),false);
	}
	
	// normal size fish uses fish not shark parameters
	public void testFishNormalSize(Tester t)
	{
		t.checkExpect(nemo.isNormalSize(),true);
	}
}
