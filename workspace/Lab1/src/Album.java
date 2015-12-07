
public class Album {
// An album is new Album(string string);
	String artist;
	String genre;
	
	Album(String artist,String genre){
		this.artist = artist;
		this.genre = genre;
	}
	
	boolean hasRockMusic() {
	    return genre.equals("rock");
	}
	
	// inGenre(String) -> boolean
	// checks if the given genre matches the album genre
	boolean inGenre(String genre){
		return this.genre.equals(genre);
	}
}
