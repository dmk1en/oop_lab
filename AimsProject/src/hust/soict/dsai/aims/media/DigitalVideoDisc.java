package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;
    
	public DigitalVideoDisc(int id, String title, String category, float cost, float length, String director) {
		super(id, title, category, cost, length, director);
		// TODO Auto-generated constructor stub
	}

	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	
	
}



