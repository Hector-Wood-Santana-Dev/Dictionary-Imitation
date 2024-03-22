package Dictionary;

import java.util.Arrays;

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
    public Dictionary(int sizeDictionary) {
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
     * Method for inserting an Dictionary.Element in the dictionary and checks if the size of the dictionary is greater than the
     * charge factor.
     *
     * @param key Key of the element that we want to insert
     * @param value Value of the element that we want to insert
     */
    public void insertElement(Object key, Object value){
        //Calling the resize method for checking the charge factor of the dictionary and expanding it if needed.
        resize();

        int hashKey;
        try {
            hashKey = key.hashCode();
        } catch (Exception e){
            System.out.println("The key cannot be null. Please enter a valid type.");
            return;
        }

        int positionElement = hashKey % table.length;

        //Checking if the space is free or liberated
        if (table[positionElement].flag == 0 || table[positionElement].flag == 2) {
            table[positionElement] = new Element(key, value, 1);
            size++;
        } else {
            for (int i = positionElement; i < table.length; i++) {
                if (table[i].flag == 1 && key.equals(table[i].getKey())){
                    table[i].setValue(value);
                    break;
                } else {
                    table[i] = new Element(key, value, 1);
                    size++;
                }
            }
            for (int i = positionElement; i > 0; i--) {
                if (table[i].flag == 1 && key.equals(table[i].getKey())){
                    table[i].setValue(value);
                    break;
                } else {
                    table[i] = new Element(key, value, 1);
                    size++;
                }
            }
        }

    }

    /**
     * Method for deleting and element from the dictionary, by marking the flag to 2 (liberated).
     * @param key Key of the object that we want to delete.
     */
    public void deleteElement(Object key){
        int hashKey;
        try {
            hashKey = key.hashCode();
        } catch (Exception e){
            System.out.println("The key cannot be null. Please enter a valid type.");
            return;
        }
        int positionElement = hashKey % table.length;
        if (table[positionElement].flag == 1) {
            table[positionElement].setFlag(2);
            size--;
        }
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
     * Method that returns an Array of Objects that are the keys stored in the dictionary.
     * @return Keys stored in the dictionary, stored in an Array of Objects.
     */
    public Object[] returnKeys(){
        Object[] list = new Object[size];
        for (int i = 0; i < size; i++) {
            if (table[i].flag == 1) {
                list[i] = table[i].getKey();
            }
        }
        return list;
    }

    /**
     * Method that return an Array of Objects that are the values stored in the dictionary.
     * @return Values stored in the dictionary, stored in an Array of Objects.
     */
    public Object[] returnValues(){
        Object[] list = new Object[size];
        for (int i = 0; i < size; i++) {
            if (table[i].flag == 1) {
                list[i] = table[i].getValue();
            }
        }
        return list;
    }

    /**
     * Method that returns a value based of a key that is given.
     * Returns the given byDefault value if the key is not found.
     * Returns NULL if the given key if null, a not valid type.
     * @param key Key of the key-value pair for searching the value.
     * @param byDefault Value that is returned by default if the key is not found.
     * @return Returns the value that is the pair from the given key.
     */
    public Object getDictionaryValue(Object key, Object byDefault){
        int hashKey;
        try {
            hashKey = key.hashCode();
        } catch (Exception e){
             System.out.println("The key cannot be null. Please enter a valid type.");
             return null;
        }
        int positionElement = hashKey % table.length;
        if (key.equals(table[positionElement].getKey())) {
            return table[positionElement].getValue();
        } else{
            for (int i = positionElement; i < table.length; i++) {
                if (key.equals(table[positionElement].getKey())) {
                    return table[positionElement].getValue();
                }
            }
            for (int i = positionElement; i > 0; i--) {
                if (key.equals(table[positionElement].getKey())) {
                    return table[positionElement].getValue();
                }
            }
        }
        return byDefault;
    }

    //TODO: dict.items(): Returns a view of all key-value pairs in the dictionary as tuples.
    //TODO: dict.get(key[, default]): Returns the value associated with the given key. If the key is not found, it returns the default value (or None if not provided).
    //TODO: dict.setdefault(key[, default]): Returns the value associated with the key. If the key is not found, it inserts the key with the default value (or None if not provided) and returns the default value.
    //TODO: dict.update(other_dict): Updates the dictionary with key-value pairs from another dictionary or iterable.
    //TODO: dict.pop(key[, default]): Removes the key and returns its value. If the key is not found, it returns the default value (or raises KeyError if not provided).
    //TODO: dict.popitem(): Removes and returns an arbitrary key-value pair as a tuple. Useful for FIFO operations.
    //TODO: dict.clear(): Removes all items from the dictionary.
    //TODO: dict.copy(): Returns a shallow copy of the dictionary.
    //TODO: len(dict): Returns the number of items in the dictionary.
    //TODO: key in dict: Returns True if the key exists in the dictionary, otherwise False.
    //TODO: dict.fromkeys(iterable[, value]): Returns a new dictionary with keys from an iterable and values set to a default value.
    //TODO: dict.items(): Returns a view object that displays a list of a dictionary's key-value tuple pairs.

    @Override
    public String toString() {
        return "Dictionary.Dictionary{" +
                ",\n size=" + size +
                ",\n chargeFactor=" + chargeFactor +
                ", \n table=" + Arrays.toString(table) +
                '}';
    }
}