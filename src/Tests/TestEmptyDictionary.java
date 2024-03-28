package Tests;

import org.junit.*;
import static org.junit.Assert.*;
import Dictionary.*;

import static java.lang.Boolean.*;

/**
 * Test Class for an empty dictionary.
 */
public class TestEmptyDictionary {

    private Dictionary dictionary;

    /**
     * Initializing the table with 0 elements.
     * The table length must be 10 (10 null elements).
     */
    @Before
    public void init(){
        dictionary = new Dictionary();
    }

    /**
     * <pre>
     * Tests if the dictionary initializes correctly.
     * The length of the dictionary must be 10.
     * The size of the dictionary must be 0.
     * </pre>
     */
    @Test
    public void testLenAndSize() {
        int lenDictionary = dictionary.lenDictionary();
        int sizeDictionary = dictionary.sizeDictionary();
        assertEquals("The length must be 10.", 10, lenDictionary);
        assertEquals("The size must be 0.", 0, sizeDictionary);
    }

    /**
     * Test that insert a valid element.
     * Also verifies that with the passed key it returns its value.
     */
    @Test
    public void testInsertElementValid() {
        assertEquals("It must return TRUE if the insert was successful", TRUE, dictionary.insertElement("Bacon", "egg"));
        assertEquals("The value of the key 'Bacon' must be 'egg'.", "egg", dictionary.getDictionaryValue("Bacon"));
    }

    /**
     * Test that insert a null element.
     * Also verifies that with the passed key it returns an Exception.
     */
    @Test
    public void testInsertElementNull(){
        assertEquals("The key cannot be null", FALSE, dictionary.insertElement(null, 1));
    }

    /**
     * Test that verifies that given a key, it returns its attributed value.
     */
    @Test
    public void testGetDictionaryValue(){
        dictionary.insertElement("Bacon", "egg");
        assertEquals("The value of the key 'Bacon' must be 'egg'.", "egg", dictionary.getDictionaryValue("Bacon"));
        assertEquals("The value of the key 'Test' must be default.", "default", dictionary.getDictionaryValue("Test", "default"));
    }

    /**
     *     Test that delete a null Element.
     *     Returns an Exception because the key is null.
     */
    @Test
    public void testDeleteElementNull() {
        assertEquals("The key cannot be null.", FALSE, dictionary.deleteElement(null));
    }

    /**
     *     Test that delete a valid Element.
     *     Also verifies that the element was delete.
     *     Returns the default param
     */
    @Test
    public void testDeleteElementValid() {
        dictionary.insertElement("Bacon", "egg");
        dictionary.deleteElement("Bacon");
        assertNull("The value of the key 'Bacon' does not exist.", dictionary.getDictionaryValue("Bacon"));
    }


    /**
     * <prev>
     *     Test that checks if the array of objects is correct.
     *     Having the current keys in the array.
     * </prev>
     */
    @Test
    public void testReturnKeys(){
        assertNull("It should return nothing.", dictionary.returnKeys());
    }

    /**
     * <prev>
     *     Test that checks if the array of objects is correct.
     *     Having the current Values in the array.
     * </prev>
     */
    @Test
    public void testReturnValues(){
        assertNull("it should return nothing.", dictionary.returnValues());
    }

    /**
     * Test that pops a value given a key.
     */
    @Test
    public void testPopValue(){
        Object var = dictionary.popDictionaryValue("Food");
        assertNull("The value of the pop should be null", var);
        assertEquals("The size of the dictionary should be 0",0, dictionary.sizeDictionary());
    }

    /**
     * Test that copies a dictionary.
     */
    @Test
    public void testCopyDictionary(){

    }

    /**
     * Test that checks if the dictionary has been cleared. It must have size = 0. and all flags to 0 or 2.
     */
    @Test
    public void testClearDictionary(){
        dictionary.clearDictionary();
        assertEquals("The amount of key-value pairs in the dictionary must be 0", 0, dictionary.sizeDictionary());
    }

    /**
     * Test that checks if the key is in the dictionary.
     */
    @Test
    public void testKeyInDictionary(){
        assertEquals("It must return TRUE if the key is in the dictionary and FALSE if it is not.", FALSE, dictionary.keyInDictionary("Food"));
    }

    /**
     * Test the resize of the dictionary once it passes the charge factor.
     */
    @Test
    public void testResizeDictionary(){
        assertEquals("The length of the dictionary should be 10.",10, dictionary.lenDictionary());
        dictionary.insertElement("Test1", 1);
        dictionary.insertElement("Test2", 2);
        dictionary.insertElement("Test3", 3);
        dictionary.insertElement("Test4", 4);
        dictionary.insertElement("Test5", 5);
        dictionary.insertElement("Test6", 6);
        dictionary.insertElement("Test7", 7);
        dictionary.insertElement("Test8", 8);
        assertEquals("The length of the dictionary should be 10.",10, dictionary.lenDictionary());
        dictionary.insertElement("Test9", 9);
        assertEquals("The length of the dictionary should be 20.", 20, dictionary.lenDictionary());
    }
}
