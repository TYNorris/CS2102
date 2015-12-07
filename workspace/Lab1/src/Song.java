
public class Song {
	  String title ;
	  int lenInSeconds ;  // duration of the song
	  Album onAlbum;
	 
	  Song (String title, Integer lenInSeconds, Album onAlbum) {
	    this.title = title ;
	    this.lenInSeconds = lenInSeconds ;
	    this.onAlbum = onAlbum;
	  }
	  
	  boolean onSameAlbum(Song song1, Song song2) {
		return (song1.onAlbum == song2.onAlbum);
	  }
	 
	  boolean overFourMinutes(){
		return lenInSeconds>240;  
	  }
}
