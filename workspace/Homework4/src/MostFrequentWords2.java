import java.util.LinkedList;
import java.util.Collections;

class MostFrequentWords2 implements IFreqWordsProbs {

	  LinkedList<WordCount> allCounts;
	  MostFrequentWords2(){
	  allCounts = new LinkedList<WordCount>();
}
  
  public LinkedList<String> frequentWords(LinkedList<String> words) {
	  LinkedList<WordCount> topCounts = new LinkedList<WordCount>();  //maintain a current list of top 3 counted words
	  LinkedList<String> output = new LinkedList<String>();
	  for(String word : words){
		  	
			 WordCount thisWord = handleCount(word);              // convert list of strings into list of WordCounts
			 if(topCounts.size()<3)
				 topCounts.add(thisWord);                       //populate the list with 3 words
			 else if(topCounts.contains(thisWord)){
				 Collections.sort(topCounts, (WordCount word1, WordCount word2)->{    //if the word is already there, just res-sort
					 
						if(word1.count!= word2.count)                               // I had some difficulty with Collections.sort()
							return word1.count - word2.count;                       //returning the list sorted in reverse
						else                                                        //this happened on other parts of the homework as well
							return -1*(word1.word.length()-word2.word.length()); });//and I didn't have time to fix it properly.
				 WordCount temp = topCounts.getFirst();
				 topCounts.set(0, topCounts.getLast());                             //Instead, I just flip the list around.
				 topCounts.set(2, temp);
			 }
			 
			 else if(thisWord.countIsMoreThan(topCounts.get(0))){     //if word belongs in the top 3, insert it
				 topCounts.add(0,thisWord);
				 topCounts.remove(3);                                 //remove the last word
			 }
			 else if(thisWord.countIsMoreThan(topCounts.get(1))){
				 topCounts.add(1,thisWord);
				 topCounts.remove(3);
			 }
			 else if(thisWord.countIsMoreThan(topCounts.get(2))){
				 topCounts.add(2,thisWord);
				 topCounts.remove(3);
			 }
		  }
	  for(WordCount wc : topCounts){            //format into a list of strings
		  output.add(wc.word);
	  }
	  return output;
  }
  
  public WordCount handleCount(String word){
		 for(WordCount countWord : this.allCounts){
			 if(countWord.word.equals(word)){
				 countWord.count++;
				 return countWord;
			 }
		 }
		 WordCount output = new WordCount(word);
		 allCounts.add(output);
		 return output;
	 }
}