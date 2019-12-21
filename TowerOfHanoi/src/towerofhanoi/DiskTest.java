/**
 * 
 */
package towerofhanoi;

/**
 * @author jhanavi ghadia
 * @version 2019.10.19
 *          Test class for disk
 */
public class DiskTest extends student.TestCase {
    private Disk disk1;
    private Disk disk2;
    private Disk disk3;


    /**
     * set up method to set initialize the variables
     */
    public void setUp() {
        disk1 = new Disk(3);
        disk2 = new Disk(4);
        disk3 = new Disk(4);
    }


    /**
     * test method for a disk class
     */
    public void testCompareTo() {
        assertEquals(1, disk2.compareTo(disk1));
        assertEquals(-1, disk1.compareTo(disk2));
        Exception thrown = null;
        try {
            disk1.compareTo(null);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }


    /**
     * test method for a class
     */
    public void testToString() {
        assertEquals("3", disk1.toString());
    }
    
    
    /**
     * test method for a class
     */
    public void testEquals() {
        Disk diskn = null;
        String u = "x";
        assertTrue(disk1.equals(disk1));
        assertFalse(disk1.equals(diskn));
        assertFalse(disk1.equals(disk2));
        assertTrue(disk3.equals(disk2));
        assertFalse(disk3.equals(u));
    }
}
