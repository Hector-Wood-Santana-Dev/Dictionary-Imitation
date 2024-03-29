package Tests;

import org.junit.*;
import static org.junit.Assert.*;
import Dictionary.*;

import static java.lang.Boolean.*;

/**
 * Test Class for
 */
public class TestMoreThanHalfElements {

    private Dictionary dictionary;

    /**
     * Initializing the table with more than half of the capacity of the dictionary.
     * The table length must be 10 (2 null elements, 8 valid element).
     */
    @Before
    public void init(){
        dictionary = new Dictionary();
        dictionary.insertElement("Test1", 1);
        dictionary.insertElement("Test2", 2);
        dictionary.insertElement("Test3", 3);
        dictionary.insertElement("Test4", 4);
        dictionary.insertElement("Test5", 5);
        dictionary.insertElement("Test6", 6);
        dictionary.insertElement("Test7", 7);
        dictionary.insertElement("Test8", 8);
    }

    /**
     * <pre>
     * Test if the dictionary initializes correctly.
     * The length of the dictionary must be 10.
     * The size of the dictionary must be 8.
     * Because there is one element inside the dictionary.
     * </pre>
     */
    @Test
    public void testLenAndSize() {
        int lenDictionary = dictionary.lenDictionary();
        int sizeDictionary = dictionary.sizeDictionary();
        assertEquals("The length must be 10.", 10, lenDictionary);
        assertEquals("The size must be 1.", 8, sizeDictionary);
    }

    /**
     * Test that verifies that given a key returns its attributed value.
     */
    @Test
    public void testGetDictionaryValue() {
        assertEquals("The value of the key 'Test1' must be 1.", 1, dictionary.getDictionaryValue("Test1"));
        assertEquals("The value of the 'Red' must be default.", "default", dictionary.getDictionaryValue("Red", "default"));
    }

    /**
     * Test that insert a valid element.
     * Also verifies that with the passed key it returns its value.
     */
    @Test
    public void testInsertElementValid() {
        dictionary.insertElement("Bacon", "egg");
        assertEquals("The value of the key 'Bacon' must be 'egg'.", "egg", dictionary.getDictionaryValue("Bacon"));
        assertEquals("The length of the dictionary must be 20.", 20, dictionary.lenDictionary());
    }

    /**
     * Test that insert a null element.
     * Also verifies that with the passed key it returns an Exception.
     */
    @Test
    public void testInsertElementNull() {
        assertEquals("The key cannot be null.", FALSE, dictionary.insertElement(null, 1));
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
     * <prev>
     *     Test that delete a valid Element.
     *     Also verifies that the element was delete.
     *     Returns the default param
     * </prev>
     */
    @Test
    public void testDeleteElementValid() {
        dictionary.deleteElement("Test1");
        assertNull("The value of the key 'Test1' should not exist.", dictionary.getDictionaryValue("Test1"));
    }

    /**
     * <prev>
     *     Test that delete a valid Element.
     *     Also verifies that the element was delete.
     *     Returns the default param
     * </prev>
     */
    @Test
    public void testDeleteMultipleElementsValid() {
        dictionary.insertElement("Test9", 9);
        dictionary.insertElement("Test10", 10);
        dictionary.insertElement("Test11", 11);
        dictionary.insertElement("Test12", 12);
        dictionary.insertElement("Test13", 13);
        dictionary.insertElement("Test14", 14);

        dictionary.deleteElement("Test14");
        assertNull("The value of the key 'Test14' should not exist.", dictionary.getDictionaryValue("Test14"));

        dictionary.deleteElement("Test1");
        assertNull("The value of the key 'Test1' should not exist.", dictionary.getDictionaryValue("Test1"));
        dictionary.deleteElement("Test15");
        assertNull("The value of the key 'Test15' should not exist.", dictionary.getDictionaryValue("Test15"));
        dictionary.insertElement("Test14", 14);
        dictionary.deleteElement("Test7");
        dictionary.deleteElement("Test14");
        assertNull("The value of the key 'Test7' should not exist.", dictionary.getDictionaryValue("Test7"));
        assertNull("The value of the key 'Test14' should not exist.", dictionary.getDictionaryValue("Test14"));
        dictionary.deleteElement("Test4");
        assertNull("The value of the key 'Test4' should not exist.", dictionary.getDictionaryValue("Test4"));

    }

    /**
     * <prev>
     *     Test that checks if the array of objects is correct.
     *     Having the current keys in the array.
     * </prev>
     */
    @Test
    public void testReturnKeys(){
        Object[] values = new Object[8];
        values[0] = "Test6";
        values[1] = "Test7";
        values[2] = "Test8";
        values[3] = "Test1";
        values[4] = "Test2";
        values[5] = "Test3";
        values[6] = "Test4";
        values[7] = "Test5";
        assertEquals("It should return [Test6,Test7,Test8,Test1,Test2,Test3,Test4,Test5].", values, dictionary.returnKeys());
    }

    /**
     * <prev>
     *     Test that checks if the array of objects is correct.
     *     Having the current Values in the array.
     * </prev>
     */
    @Test
    public void testReturnValues(){
        Object[] values = new Object[8];
        values[0] = 6;
        values[1] = 7;
        values[2] = 8;
        values[3] = 1;
        values[4] = 2;
        values[5] = 3;
        values[6] = 4;
        values[7] = 5;
        assertEquals("It should return [6,7,8,1,2,3,4,5].", values, dictionary.returnValues());
    }

    /**
     * Test that pops a value given a key.
     */
    @Test
    public void testPopValue(){
        assertEquals("The size of the dictionary should be 8",8, dictionary.sizeDictionary());
        Object var = dictionary.popDictionaryValue("Test7");
        assertEquals("The value of the pop should be 7",7, var);
        assertEquals("The size of the dictionary should be 7",7, dictionary.sizeDictionary());
    }

    /**
     * Test that copies a dictionary. It checks if the contents of the copied dictionary are identical to the source dictionary.
     */
    @Test
    public void testCopyDictionary(){
        Dictionary dictionary2 = dictionary.copyDictionary();
        assertEquals("The dictionary must be the same as the previous dictionary", dictionary.toString(), dictionary2.toString());
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
        assertEquals("It must return TRUE if the key is in the dictionary.", TRUE, dictionary.keyInDictionary("Test8"));
    }

    /**
     * Test the resize of the dictionary once it passes the charge factor.
     */
    @Test
    public void testResizeDictionary(){
        assertEquals("The length of the dictionary should be 10.",10, dictionary.lenDictionary());
        dictionary.insertElement("Test9", 9);
        assertEquals("The length of the dictionary should be 20.", 20, dictionary.lenDictionary());
        dictionary.insertElement("Test10", 10);
        dictionary.insertElement("Test11", 11);
        dictionary.insertElement("Test12", 12);
        dictionary.insertElement("Test13", 13);
        dictionary.insertElement("Test14", 14);
        dictionary.insertElement("Test15", 15);
        dictionary.insertElement("Test16", 16);
        assertEquals("The length of the dictionary should be 40.", 40, dictionary.lenDictionary());

    }

}