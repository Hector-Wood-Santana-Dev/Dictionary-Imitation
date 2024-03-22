package Tests;

import org.junit.*;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.*;
import Dictionary.*;

/**
 * Test Class for a one item on dictionary.
 */
public class TestOneItemDictionary {
    private Dictionary dictionary;

    @Before
    public void init(){
        dictionary = new Dictionary();
        dictionary.insertElement("Food", 3);
    }
    /**
     * <pre>
     * Test if the dictionary initializes correctly.
     * The length of the dictionary must be 10.
     * The size of the dictionary must be 1.
     *
     * </pre>
     */

}
