/**
 * 
 */
package towerofhanoi;

/**
 * @author jhanavi ghadia
 * @version 2019.10.20
 *          Test class for tower
 */
public class TowerTest extends student.TestCase {
    private Tower tower1;
    private Tower tower2;
    private Tower tower3;
    private Disk disk1;
    private Disk disk2;
    private Disk disk3 = null;


    /**
     * test method for a class
     */
    public void setUp() {
        tower1 = new Tower(Position.LEFT);
        tower2 = new Tower(Position.MIDDLE);
        tower3 = new Tower(Position.RIGHT);
        disk1 = new Disk(1);
        disk2 = new Disk(2);
    }


    /**
     * test method for a class
     */
    public void testPosition() {
        assertEquals(Position.LEFT, tower1.position());
        assertEquals(Position.MIDDLE, tower2.position());
        assertEquals(Position.RIGHT, tower3.position());
    }


    /**
     * test method for a class
     */
    public void testPush() {
        

        Exception exception1 = null;
        try {
            tower1.push(disk3);
            fail("push() should throw an exception when null");
        }
        catch (Exception exception) {
            exception1 = exception;

        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception1 instanceof IllegalArgumentException);

        tower1.push(disk2);
        tower1.push(disk1);

        assertEquals(2, tower1.size());

        Exception exception2 = null;
        try {
            tower1.push(disk2);
            tower1.push(disk1);

            fail("push() should throw an exception");
        }
        catch (Exception exception) {
            exception2 = exception;
        }
        assertFalse("push() is throwing the wrong type of exceptions",
            exception2 instanceof IllegalArgumentException);

    }

}
