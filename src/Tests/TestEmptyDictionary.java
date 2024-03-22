package Tests;

import org.junit.*;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.*;
import Dictionary.*;

/**
 * Test Class for an empty dictionary.
 */
public class TestEmptyDictionary {

    private Dictionary dictionary;

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
        assertEquals("La longitud debe ser 10.", 10, lenDictionary);
        assertEquals("El tamaño debe ser 0.", 0, sizeDictionary);
    }

    @Test
    public void testInsertKeyValuePair(){
        dictionary.insertElement("Test", 1);
        assertEquals("El valor de la clave 'Test' debe ser 1.", 1, dictionary.getDictionaryValue("Test", 0));
    }



}
