import tester.*;
import java.util.LinkedList;

class FreqWordsExamples {
  IFreqWordsProbs F;
  LinkedList<String> words = new LinkedList<String>();
  
  FreqWordsExamples(IFreqWordsProbs F) {
    this.F = F;
    
    words.add("Tomato");          //tests for extra word that is not returned
    words.add("Squash");          // test for highest count
    words.add("REALLYLONGWORD");  //test for tie 
    words.add("shrt");
    words.add("Squash");
    words.add("REALLYLONGWORD");
    words.add("shrt");
    words.add("Squash");
  }
  
  boolean testWords (Tester t) {
	  LinkedList<String> expected = new LinkedList<String>();
	  expected.add("Squash");
	  expected.add("shrt");
	  expected.add("REALLYLONGWORD");
    return t.checkExpect(F.frequentWords(words), expected);
  }
}