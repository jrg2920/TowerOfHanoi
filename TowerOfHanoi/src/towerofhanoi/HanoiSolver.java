/**
 * 
 */
package towerofhanoi;

import java.util.Observable;

/**
 * @author jhanavi ghadia
 * @version 2019.10.18
 *  Class that deals with the towers and the recursive part
 */
@SuppressWarnings("deprecation")
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower middle;
    private Tower right;
    private int numDisks;


    /**
     * A constructor that instantiates all three towers
     * 
     * @param numDisk
     *            number of disks
     */
    public HanoiSolver(int numDisk) {
        this.numDisks = numDisk;
        left = new Tower(Position.LEFT);
        right = new Tower(Position.RIGHT);
        middle = new Tower(Position.MIDDLE);
    }


    /**
     * disk method of type integer
     * @return the number of disks
     */
    public int disks() {
        return numDisks;
    }


    /**
     * this method calls the tower based on its position
     * 
     * @param pos
     *            A position parameter
     * @return Tower at the particular position
     */
    public Tower getTower(Position pos) {
        switch (pos) {
            case LEFT:
                return left;
            case RIGHT:
                return right;
            case MIDDLE:
                return middle;
            default:
                return middle;
        }

    }


    /**
     * a to-string method to display the string in a proper format
     * 
     * @return string version of the output
     */
    public String toString() {
        return left.toString() + middle.toString() + right.toString();
    }


    /**
     * a method that moves the disk from one tower to another
     * 
     * @param source
     *            tower from which the disk gets removed
     * @param destination
     *            tower on which disk is added
     */
    private void move(Tower source, Tower destination) {
        destination.push(source.pop());
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * a recursive method that solves the puzzle
     * 
     * @param currentDisks
     *            number of disks
     * @param startPole
     *            pole from where the disks gets removed
     * @param tempPole
     *            a temporary pole for the arrangement
     * @param endPole
     *            pole where disk is placed finally
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * a method that calls the solveTowers method
     */
    public void solve() {
        solveTowers(numDisks, right, middle, left);
    }

}
