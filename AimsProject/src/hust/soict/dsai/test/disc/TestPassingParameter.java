package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    
    public static void main(String[] args) {

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc ("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc ("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }


    public static void swap(Object o1, Object o2) {
        if (!(o1 instanceof DigitalVideoDisc) || !(o2 instanceof DigitalVideoDisc)) {
            return;
        }
        
        DigitalVideoDisc dvd1 = (DigitalVideoDisc) o1;
        DigitalVideoDisc dvd2 = (DigitalVideoDisc) o2;
        
        String tmpTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tmpTitle);
    }


    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc (oldTitle);
    }
}
