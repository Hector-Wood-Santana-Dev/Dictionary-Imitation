package Tests;

import org.junit.*;

import static org.junit.Assert.*;
import Dictionary.*;
import static java.lang.Boolean.*;

//TODO: CHECKEAR LOS TESTS, ESTAN MAL PLANTEADOS
/**
 * Test Class for a one item on dictionary.
 */
public class TestOneElementDictionary {
    private Dictionary dictionary;

    /**
     * <pre>
     * Initializing the table with 1 element.
     * The table length must be 10 (9 null elements, 1 valid element).
     * </pre>
     */
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
     * Because there is one element inside the dictionary.
     * </pre>
     */
    @Test
    public void testLenAndSize() {
        int lenDictionary = dictionary.lenDictionary();
        int sizeDictionary = dictionary.sizeDictionary();
        assertEquals("The length must be 10.", 10, lenDictionary);
        assertEquals("The size must be 1.", 1, sizeDictionary);
    }

    /**
     * Test that verifies that given a key returns its attributed value.
     */
    @Test
    public void testGetDictionaryValue() {
        assertEquals("The value of the key 'Food' must be 3.", 3, dictionary.getDictionaryValue("Food"));
    }

    /**
     * <pre>
     * Test that insert a valid element.
     * Also verifies that with the passed key it returns its value.
     * </pre>
     */
    @Test
    public void testInsertElementValid() {
        dictionary.insertElement("Bacon", "egg");
        assertEquals("The value of the key 'Bacon' must be 'egg'.", "egg", dictionary.getDictionaryValue("Bacon"));
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
     *     Returns the default (0)
     * </prev>
     */
    @Test
    public void testDeleteElementValid() {
        dictionary.deleteElement("Bacon");
        assertEquals("The value of the key 'Bacon' does not exist.", null, dictionary.getDictionaryValue("Bacon"));
    }
}
