/**
 * 
 */
package towerofhanoi;

/**
 * @author jhanavi ghadia
 * @version 2019.10.19
 * A class to store disk on top of towers
 */
public class Tower extends LinkedStack<Disk> {
    // a position variable of type position
    private Position position;


    /**
     * A constructor that calls the super class
     * @param position Position of the tower
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * Position method that returns the position of a tower
     * @return position of the tower
     */
    public Position position() {
        return position;
    }


    /**
     * push method adds the disks on the top of tower
     * @throws Exception when disk is null
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (size() == 0 || peek().compareTo(disk) > 0) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }

    }

}
