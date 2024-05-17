package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks;
	
	public CompactDisc(int id, String title, String category, float cost, float length, String director, String artist, ArrayList<Track> tracks) {
		super(id, title, category, cost, length, director);
		this.artist = artist;
		this.tracks = tracks;
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
		for (Track track : tracks) {
			if (track.isTrue(addTrack)){
				tracks.add(addTrack);
				System.out.println("added");
				break;
			}
		}
	}
	
	public void removeTrack(Track addTrack) {
		for (Track track : tracks) {
			if (track.isTrue(addTrack)){
				tracks.remove(track);
				System.out.println("removed");
				break;
			}
		}
	}
	

}
