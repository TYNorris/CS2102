
public class WordCount {
	String word;
	int count;
	
	public WordCount(String word){
		this.word = word;
		this.count=1;
	}
	boolean countIsMoreThan(WordCount wc){
		return this.count>wc.count;
	}
	
	boolean isEqual(WordCount wc){
		return this.word.equals(wc.word);
	}
	
}
