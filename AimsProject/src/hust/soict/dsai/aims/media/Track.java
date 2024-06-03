package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;
	
	
		
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public String play() throws PlayerException {
		if (this.getLength() > 0) {
			return "Playing track: " + this.getTitle() + ". Track length: " + this.getLength() + "\n";
		} else{
			throw new PlayerException("ERROR: Track length is non-positive");
		}
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public boolean isTrue(Track track) {
		if (track.getTitle().equals(this.title) && track.getLength() == this.length) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Track track = (Track) obj;
		return track.getTitle() == this.title && track.getLength() == this.length;
	}
	
}
