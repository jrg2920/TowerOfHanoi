/**
 * 
 */
package towerofhanoi;


/**
 * @author jhanavi ghadia
 * @version 2019.10.19
 * Test class for HanoiSolver
 */
public class HanoiSolverTest extends student.TestCase {
    
    private Tower tower1;
    private Tower tower2;
 // a new object of type HanoiSolver
    private HanoiSolver solver;
    private Disk disk1;


    /**
     * set up method to initialize variables
     */
    public void setUp() {
        solver = new HanoiSolver(3);
        tower1 = new Tower(Position.LEFT);
        tower2 = new Tower(Position.RIGHT);
        disk1 = new Disk(2);
    }


    /**
     * test method for a method
     */
    public void testdisks() {
        tower1.push(disk1);
        assertEquals(3, solver.disks());
    }


    /**
     * test method for a method
     */
    public void testGetTower() {
        tower2.push(disk1);
        assertEquals(0, solver.getTower(Position.LEFT).size());
        assertEquals(0, solver.getTower(Position.MIDDLE).size());
        assertEquals(0, solver.getTower(Position.RIGHT).size());
        assertEquals(0, solver.getTower(Position.DEFAULT).size());
    }


    /**
     * test method for a class
     */
    public void testToString() {
        assertEquals("[][][]", solver.toString());
    }


    /**
     * test method for a class
     */
    public void testSolve() {
        Disk d = new Disk(1);
        Disk d1 = new Disk(2);
        Disk d2 = new Disk(3);
        solver.getTower(Position.RIGHT).push(d2);
        solver.getTower(Position.RIGHT).push(d1);
        solver.getTower(Position.RIGHT).push(d);
        solver.solve();

        assertEquals(solver.toString(), "[1, 2, 3][][]");
    }
}
