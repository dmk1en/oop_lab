package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.CostException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.exception.TitleException;

import javax.swing.JOptionPane;

public class DigitalVideoDisc extends Disc implements Playable {
    
	public DigitalVideoDisc(int id, String title, String category, float cost, float length, String director) throws IllegalArgumentException, TitleException, CostException {
		super(id, title, category, cost, length, director);
	}

	public String play() throws PlayerException{
		if (this.getLength() > 0) {
			return "Playing DVD: " + this.getTitle() + "\nDVD length: " + this.getLength();
		} else{
			JOptionPane.showMessageDialog(null, "ERROR: DVD length is non-positive", "Error", JOptionPane.ERROR_MESSAGE);
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
	}
	
    public String toString(){
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + String.valueOf(getCost()) + " $";
    }

	
	
}



