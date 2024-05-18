package hust.soict.dsai.aims.media.sort;

import hust.soict.dsai.aims.media.Media;
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        return Comparator.comparing(Media::getTitle)
                         .thenComparing(Media::getCost, Comparator.reverseOrder())
                         .compare(o1, o2);
    }
}
