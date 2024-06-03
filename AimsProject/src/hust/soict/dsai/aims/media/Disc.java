package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.CostException;
import hust.soict.dsai.aims.exception.TitleException;

public class Disc extends Media {
	private float length;
	private String director;

	public float getLength() {
		return this.length;
	}

	public String getDirector() {
		return this.director;
	}
	
	
	public Disc(int id, String title, String category, float cost, float length, String director) throws IllegalArgumentException, TitleException, CostException {
        super(id, title, category, cost); 
        this.length = length;
        this.director = director;
	}

}
