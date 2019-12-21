/**
 * 
 */
package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author jhanavi ghadia
 * @version 2019.10.18
 * A class that deals with the entire window
 */
@SuppressWarnings("deprecation")
public class PuzzleWindow implements Observer {
    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    private Button solve;
    public static final int WIDTH_FACTOR = 27;
    public static final int DISK_GAP = 2;
    public static final int DISK_HEIGHT = 13;


    /**
     * Updates the back end according to the front end
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            moveDisk((Position)arg);
            sleep();
        }
    }


    /**
     * A sleep method that was given
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * method that gets called when a button is clicked
     * @param button is passed to the clickedSolve
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * A method that moves disks on the tower
     * @param position
     * to specify the position of the disk
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;
        switch (position) {
            case LEFT:
                currentPole = left;
                break;
            case RIGHT:
                currentPole = right;
                break;
            case MIDDLE:
                currentPole = middle;
                break;
            default:
                currentPole = middle;
        }
        currentDisk.moveTo(currentPole.getX() + (currentPole.getWidth()
            - currentDisk.getWidth()) / 2, currentPole.getY() + currentPole
                .getHeight() - game.getTower(position).size() * (DISK_HEIGHT
                    + DISK_GAP));
    }


    /**
     * Constructor that adds shapes and buttons to the window
     * @param game of HanoiSolver type
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window();
        window.setTitle("Towers Of Hanoi");
        left = new Shape(100, 200, 3, 100, Color.blue);
        middle = new Shape(300, 200, 3, 100, Color.black);
        right = new Shape(500, 200, 3, 100, Color.cyan);
        for (int i = game.disks(); i > 0; i--) {
            Disk disk = new Disk(i * WIDTH_FACTOR);
            window.addShape(disk);
            game.getTower(Position.RIGHT).push(disk);
            moveDisk(Position.RIGHT);
        }
        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        this.solve = new Button("Solve");
        window.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this, "clickedSolve");
    }

}
