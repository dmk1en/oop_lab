package hust.soict.dsai.aims.media;

public class Disc extends Media {
	private float length;
	private String director;

	public float getLength() {
		return this.length;
	}

	public String getDirector() {
		return this.director;
	}
	
	
	public Disc(int id, String title, String category, float cost, float length, String director) {
        super(id, title, category, cost);  // Call to superclass constructor
        this.length = length;
        this.director = director;
	}

}
