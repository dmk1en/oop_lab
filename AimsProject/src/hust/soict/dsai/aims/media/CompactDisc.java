package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks;
	
	public CompactDisc(int id, String title, String category, float cost, float length, String director, String artist) {
		super(id, title, category, cost, length, director);
		this.artist = artist;
		
	}
	
	public void play() {
		for (Track track : tracks) {
			track.play();
		}
	}
	
	public String getArtist() {
		return this.artist;
	}


	
	public float getLength() {
		int sum = 0;
		for (Track track : tracks) {
			sum += track.getLength();
		}
		return sum;
	}
	
	
	
	public void addTrack(Track addTrack) {
		if (!tracks.contains(addTrack)){
			tracks.add(addTrack);
			System.out.println("added");	
		}
	}
	
	public void removeTrack(Track addTrack) {
		if (tracks.contains(addTrack)){
			tracks.remove(addTrack);
			System.out.println("removed");	
		}
	}
	
    public String toString(){
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + ": " + String.valueOf(getCost()) + " $";
    }
	

}
