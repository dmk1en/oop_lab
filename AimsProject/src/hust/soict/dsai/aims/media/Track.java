package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	
	
		
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
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
