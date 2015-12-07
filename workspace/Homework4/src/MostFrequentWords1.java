import java.util.LinkedList;
import java.util.Collections;

class MostFrequentWords1 implements IFreqWordsProbs {
	  LinkedList<WordCount> allCounts;
  MostFrequentWords1(){
	  allCounts = new LinkedList<WordCount>();
  }
  
  public LinkedList<String> frequentWords(LinkedList<String> words) {

	  for(String word : words){                               //convert list of strings into list of WordCounts and count them
		 if(!handleCount(word))
			 allCounts.add(new WordCount(word));
	  }
	  
	  
	  Collections.sort(allCounts, (WordCount word1, WordCount word2)->{      //sort all words by the number of counts (or size if tied)
		  							if(word1.count!= word2.count)
		  								return word1.count - word2.count;
	  								else
	  									return -1*(word1.word.length()-word2.word.length()); });
	  									
	  LinkedList<String> output = new LinkedList<String>();
	  for(int i = allCounts.size()-1; i>allCounts.size()-4;i--){
		  output.add(allCounts.get(i).word);                          //output only the 3 highest count words
	  }
    return output;
  }

 public boolean handleCount(String word){
	 for(WordCount countWord : this.allCounts){
		 if(countWord.word.equals(word)){
			 countWord.count++;
			 return true;
		 }
	 }
	 return false;
 }
}

