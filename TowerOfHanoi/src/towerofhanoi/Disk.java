/**
 * 
 */
package towerofhanoi;

import java.awt.Color;
import java.util.Random;
import CS2114.Shape;

/**
 * @author jhanavi ghadia
 * @version 2019.10.20
 *          class that gives and compares dimensions of the disk
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * A constructor that calls the super class
     * @param width
     *            width of the disk
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT, new Color(new Random()
            .nextInt(255), new Random().nextInt(255), new Random().nextInt(
                255)));
    }


    /**
     * a method that compares the dimensions of the disks
     * @return the results of comparison
     * @throws Exception when a null disk is passed
     */
    @Override
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        return getWidth() - otherDisk.getWidth();
    }


    /**
     * to-string method that gives a proper output
     * @return String version of the output
     */
    public String toString() {
        return "" + this.getWidth();
    }


    /**
     * equals method for disk
     * @return boolean variable
     * @param obj
     * of the type Object
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return obj.getClass().equals(Disk.class) && this
            .getWidth() == ((Disk)obj).getWidth();
    }
}
