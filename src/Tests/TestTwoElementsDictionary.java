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
     * <pre>
     * Initializing the table with 2 elements.
     * The table length must be 10 (9 null elements, 2 valid element).
     * </pre>
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
     * <pre>
     * Test that insert a valid element.
     * Also verifies that with the passed key it returns its value.
     * </pre>
     */
    @Test
    public void testInsertElementValid() {
        dictionary.insertElement("Apple", "egg");
        assertEquals("The value of the key 'Apple' must be 'egg'.", "egg", dictionary.getDictionaryValue("Apple"));
    }
    /**
     * <pre>
     * Test that insert a null element.
     * Also verifies that with the passed key it returns an Exception.
     * </pre>
     */
    @Test
    public void testInsertElementNull() {
        assertEquals("The key cannot be null.", FALSE, dictionary.insertElement(null, 1));

    }

    /**
     * <prev>
     *     Test that delete a null Element.
     *     Returns an Exception because the key is null.
     * </prev>
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
        dictionary.deleteElement("Apple");
        assertNull("The value of the key 'Apple' does not exist.", dictionary.getDictionaryValue("Bacon"));
    }
    /**
     * <pre>
     * Test that pops a value given a key.
     * </pre>
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
}