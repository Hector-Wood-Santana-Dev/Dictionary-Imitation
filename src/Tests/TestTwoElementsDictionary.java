package Tests;

import org.junit.*;
import static org.junit.Assert.*;
import Dictionary.*;

import static java.lang.Boolean.*;

/**
 * Test Class for two elements on dictionary.
 */
public class TestTwoElementsDictionary {
    private Dictionary dictionary;

    /**
     * Initializing the table with 2 elements.
     * The table length must be 10 (9 null elements, 2 valid element).
     */
    @Before
    public void init(){
        dictionary = new Dictionary();
        dictionary.insertElement("Food", 3);
        dictionary.insertElement("Drink", 2);
    }

    /**
     * <pre>
     * Test if the dictionary initializes correctly.
     * The length of the dictionary must be 10.
     * The size of the dictionary must be 2.
     * Because there is two elements inside the dictionary.
     * </pre>
     */
    @Test
    public void testLenAndSize() {
        int lenDictionary = dictionary.lenDictionary();
        int sizeDictionary = dictionary.sizeDictionary();
        assertEquals("The length must be 10.", 10, lenDictionary);
        assertEquals("The size must be 2.", 2, sizeDictionary);
    }

    /**
     * Test that verifies that given a key returns its attributed value.
     */
    @Test
    public void testGetDictionaryValue() {
        assertEquals("The value of the key 'Food' must be 3.", 3, dictionary.getDictionaryValue("Food"));
        assertEquals("The value of the key 'Drink' must be 2.", 2, dictionary.getDictionaryValue("Drink"));
    }
    /**
     * Test that insert a valid element.
     * Also verifies that with the passed key it returns its value.
     */
    @Test
    public void testInsertElementValid() {
        dictionary.insertElement("Apple", "egg");
        assertEquals("The value of the key 'Apple' must be 'egg'.", "egg", dictionary.getDictionaryValue("Apple"));
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
     *     Test that delete a valid Element.
     *     Also verifies that the element was delete.
     *     Returns the default param
     */
    @Test
    public void testDeleteElementValid() {
        dictionary.deleteElement("Apple");
        assertNull("The value of the key 'Apple' does not exist.", dictionary.getDictionaryValue("Bacon"));
    }

    /**
     *     Test that checks if the array of objects is correct.
     *     Having the current keys in the array.
     */
    @Test
    public void testReturnKeys(){
        Object[] values = new Object[2];
        values[0] = "Food";
        values[1] = "Drink";
        assertEquals("It should return [Food, Drink].", values, dictionary.returnKeys());
    }

    /**
     *     Test that checks if the array of objects is correct.
     *     Having the current Values in the array.
     */
    @Test
    public void testReturnValues(){
        Object[] values = new Object[2];
        values[0] = 3;
        values[1] = 2;
        assertEquals("it should return 3, 2.", values, dictionary.returnValues());
    }

    /**
     * Test that pops a value given a key.
     */
    @Test
    public void testPopValue() {
        Object var = dictionary.popDictionaryValue("Food");
        assertEquals("The value of the pop should be 3", 3, var);
        assertEquals("The size of the dictionary should be 1", 1, dictionary.sizeDictionary());
        Object var1 = dictionary.popDictionaryValue("Drink");
        assertEquals("The value of the pop should be 2", 2, var1);
        assertEquals("The size of the dictionary should be 0", 0, dictionary.sizeDictionary());
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
        assertEquals("It must return TRUE if the key is in the dictionary.", TRUE, dictionary.keyInDictionary("Food"));
        assertEquals("It must return TRUE if the key is in the dictionary.", TRUE, dictionary.keyInDictionary("Drink"));
    }

    /**
     * Test the resize of the dictionary once it passes the charge factor.
     */
    @Test
    public void testResizeDictionary(){
        assertEquals("The length of the dictionary should be 10.",10, dictionary.lenDictionary());
        dictionary.insertElement("Test0", 1);
        dictionary.insertElement("Test2", 2);
        dictionary.insertElement("Test3", 3);
        dictionary.insertElement("Test4", 4);
        dictionary.insertElement("Test5", 5);
        dictionary.insertElement("Test6", 6);
        assertEquals("The length of the dictionary should be 10.",10, dictionary.lenDictionary());
        dictionary.insertElement("Test7", 7);
        assertEquals("The length of the dictionary should be 20.", 20, dictionary.lenDictionary());
    }
}
