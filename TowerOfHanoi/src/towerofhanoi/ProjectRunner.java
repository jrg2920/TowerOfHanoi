/**
 * 
 */
package towerofhanoi;

/**
 * @author jhanavi ghadia
 * @version 2019.10.19
 * ProjectRunner with main method
 */
public class ProjectRunner {
    /**
     * main method that calls two classes
     * @param args of String type
     */
    public static void main(String[] args) {
        int disks = 5;
        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        HanoiSolver game = new HanoiSolver(disks);
        new PuzzleWindow(game);
    }

}
