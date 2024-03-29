package Dictionary;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Boolean.*;

/**
 * Class that imitates the function of a Dictionary.Dictionary from Python.
 */
public class Dictionary {
    /**
     * Array that stores the elements with the key-value pair
     */
    private Element[] table;
    /**
     * Variable that stores how many elements are in the dictionary
     */
    private int size;
    /**
     * Charge Factor for incrementing the dictionary's size
     */
    private final double chargeFactor;

    /**
     * Basic Constructor for the Dictionary.Dictionary
     */
    public Dictionary() {
    table = new Element[10];
        init_table(table);
        size = 0;
        chargeFactor = 0.75;
    }

    /**
     * Parametrized Constructor for creating a custom size Dictionary.Dictionary
     */
    private Dictionary(int sizeDictionary) {
        table = new Element[sizeDictionary];
        init_table(table);
        size = 0;
        chargeFactor = 0.75;
    }

    /**
     * Method for initializing the table with empty elements with flag to 0 (Free)
     *
     * @param table The array that emulates the dictionary
     */
    private void init_table(Element[] table){
        for (int i = 0; i < table.length; i++){
            table[i] = new Element(null, null, 0);
        }
    }

    /**
     * Method that returns the length of the dictionary.
     * @return Returns the length of the dictionary.
     */
    public int lenDictionary(){
       return table.length;
    }

    /**
     * Method that returns the size of the dictionary.
     * The Size is the amount of key-value pairs in the dictionary.
     * @return Returns the amount of key-value pairs in the dictionary
     */
    public int sizeDictionary(){
        return size;
    }

    /**
     * Method for resizing the dictionary.
     */
    private void resize(){
        if ((double) size / table.length >= chargeFactor) {
            int newSize = table.length*2;
            Dictionary exchangeDictionary = new Dictionary(newSize);

            for (Element element : table) {
                exchangeDictionary.insertElement(element.getKey(), element.getValue());
            }
            this.table = exchangeDictionary.table;
            this.size = exchangeDictionary.size;
        }
    }

    /**
     * Method for inserting a Dictionary.Element in the dictionary and checks if the size of the dictionary is greater than the
     * charge factor.
     *
     * @param key   Key of the element that we want to insert
     * @param value Value of the element that we want to insert
     * @return Returns TRUE if the element is inserted correctly, FALSE if the key is null and NULL if nothing happens.
     */
    public Boolean insertElement(Object key, Object value){
        //Calling the resize method for checking the charge factor of the dictionary and expanding it if needed.
        resize();

        int hashKey;
        try {
            hashKey = key.hashCode();
        } catch (Exception e){
            return FALSE;
        }

        int positionElement = hashKey % table.length;

        //Checking if the space is free or liberated
        if (table[positionElement].flag == 0 || table[positionElement].flag == 2) {
            table[positionElement] = new Element(key, value, 1);
            size++;
            return TRUE;
        } else {
            for (int i = positionElement; i < table.length; i++) {
                if (table[i].flag == 1 && key.equals(table[i].getKey())){
                    table[i].setValue(value);
                    return TRUE;
                } else {
                    table[i] = new Element(key, value, 1);
                    size++;
                    return TRUE;
                }
            }
            for (int i = positionElement; i > 0; i--) {
                if (table[i].flag == 1 && key.equals(table[i].getKey())){
                    table[i].setValue(value);
                    return TRUE;
                } else {
                    table[i] = new Element(key, value, 1);
                    size++;
                    return TRUE;
                }
            }
        }
        return null;
    }

    /**
     * Method for deleting an element from the dictionary, by marking the flag to 2 (liberated).
     * @param key Key of the object that we want to delete.
     * @return Returns TRUE if the element is deleted correctly, FALSE if the key is null and NULL if nothing happens.
     */
    public Boolean deleteElement(Object key){
        int hashKey;
        try {
            hashKey = key.hashCode();
        } catch (Exception e){
            return FALSE;
        }
        int positionElement = hashKey % table.length;
        if (table[positionElement].flag == 1) {
            table[positionElement].setFlag(2);
            size--;
            return TRUE;
        }
        return null;
    }

    /**
     * Method that returns an Array of Objects that are the keys stored in the dictionary.
     * @return Keys stored in the dictionary, stored in an Array of Objects.
     */
    public Object[] returnKeys(){
        if (size != 0){
            Object[] list = new Object[size];
            int j = 0;
            for (int i = 0; i < table.length; i++) {
                if (table[i].flag == 1 && list[j] == null) {
                    list[j] = table[i].getKey();
                    j++;
                }
            }
            return list;
        } else {
            return null;
        }
    }

    /**
     * Method that return an Array of Objects that are the values stored in the dictionary.
     * @return Values stored in the dictionary, stored in an Array of Objects.
     */
    public Object[] returnValues(){
        if (size != 0){
            Object[] list = new Object[size];
            int j = 0;
            for (int i = 0; i < table.length; i++) {
                if (table[i].flag == 1 && list[j] == null) {
                    list[j] = table[i].getValue();
                    j++;
                }
            }
            return list;
        } else {
            return null;
        }
    }

    /**
     * Method that returns a value based of a key that is given.
     * @param params The first parameter is the key of the value we want. The second one is the one that is returned if the key is not found.
     * @return The value of the key-value pair if found. Returns the given byDefault option or null if the is no option given.
     */
     public Object getDictionaryValue(Object... params){
        Object key = params[0];
        int hashKey;
        try {
            hashKey = key.hashCode();
        } catch (Exception e){
             System.out.println("The key cannot be null. Please enter a valid type.");
             return null;
        }
        int positionElement = hashKey % table.length;
        if (key.equals(table[positionElement].getKey()) && table[positionElement].getFlag() == 1) {
            return table[positionElement].getValue();
        } else{
            for (int i = positionElement; i < table.length; i++) {
                if (key.equals(table[positionElement].getKey()) && table[positionElement].getFlag() == 1) {
                    return table[positionElement].getValue();
                }
            }
            for (int i = positionElement; i > 0; i--) {
                if (key.equals(table[positionElement].getKey()) && table[positionElement].getFlag() == 1) {
                    return table[positionElement].getValue();
                }
            }
        }
        if (params.length != 1) {
            return params[1];
        } else {
            return null;
        }
    }

    /**
     * Method that removes the key and returns its value. If the key is not found, it returns the default value.
     * @param params The first parameter is the key of the value we want. The second one is the one that is returned if the key is not found.
     * @return The value of the key-value pair if found. Returns the given byDefault option or null if the is no option given.
     */
    public Object popDictionaryValue(Object... params) {
         Object key = params[0];
         Object value = getDictionaryValue(key);
         deleteElement(key);
         return value;
    }

    /**
     * Method that gives a random value and removes the key.
     * @return The value of the key-value pair if found. Returns null if the key does not exist.
     */
    public Object popArbitraryDictionaryValue(){
        Random random = new Random();
        Object randomNumber = random.ints(0,size).findFirst().getAsInt();
        return popDictionaryValue(randomNumber);
    }

    /**
     * Method for copying a dictionary.
     * @return Returns a copy of the dictionary.
     */
    public Dictionary copyDictionary() {
        int newSize = table.length;
        Dictionary dictionary2 = new Dictionary(newSize);
        for (Element element : table) {
            if (element.getKey() != null) {
                dictionary2.insertElement(element.getKey(), element.getValue());
            }
        }
        return dictionary2;
    }

    /**
     * Method that deletes all elements of the dictionary. It sets the flags to liberated (2).
     */
    public void clearDictionary(){
        for (int i = 0; i < table.length; i++) {
            if(table[i].getFlag() == 1){
                table[i].setFlag(2);
                size--;
            }
        }
    }

    /**
     * Method that looks for a key in the dictionary and returns TRUE if it finds it.
     * @param key key that we are looking for.
     * @return TRUE if the key is in the dictionary and FALSE if it isn't.
     */
    public boolean keyInDictionary(Object key){
        for (int i = 0; i < table.length; i++) {
            if (table[i].getKey() == key){
                return TRUE;
            }
        }
        return FALSE;
    }

    @Override
    public String toString() {
        return "Dictionary.Dictionary{" +
                ",\n size=" + size +
                ",\n chargeFactor=" + chargeFactor +
                ", \n table=" + Arrays.toString(table) +
                '}';
    }
}