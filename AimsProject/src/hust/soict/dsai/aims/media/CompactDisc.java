package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.CostException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.exception.TitleException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks;
	
	public CompactDisc(int id, String title, String category, float cost, float length, String director, String artist) throws IllegalArgumentException, TitleException, CostException {
		super(id, title, category, cost, length, director);
		this.artist = artist;
		
	}
	
	public String play() throws PlayerException {
		StringBuffer result = new StringBuffer();
		if(this.getLength() > 0) {
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while(iter.hasNext()) {
				nextTrack = (Track) iter.next();
				try {
					result.append(nextTrack.play());
				}catch(PlayerException e) {
					throw e;
				}
			}
			}else {
				throw new PlayerException("ERROR: CD length is non-positive!");
		}

		return result.toString();
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
