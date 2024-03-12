import java.util.Arrays;

/**
 * Class that imitates the function of a Dictionary from Python.
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
     * Basic Constructor for the Dictionary
     */
    public Dictionary() {
        table = new Element[10];
        init_table(table);
        size = 0;
        chargeFactor = 0.75;
    }

    /**
     * Parametrized Constructor for creating a custom size Dictionary
     */
    public Dictionary(int sizeDictionary) {
        table = new Element[sizeDictionary];
        init_table(table);
        size = 0;
        chargeFactor = 0.75;
    }

    /**
     * Class for initializing the table with empty elements with flag to 0 (Free)
     *
     * @param table The array that emulates the dictionary
     */
    private void init_table(Element[] table){
        for (int i = 0; i < table.length; i++){
            table[i] = new Element(null, null, 0);
        }
    }

    /**
     * Method for inserting an Element in the dictionary and checks if the size of the dictionary is greater than the
     * charge factor.
     *
     * @param key Key of the element that we want to insert
     * @param value Value of the element that we want to insert
     */
    public void insertElement(Object key, Object value){
        //Calling the resize method for checking the charge factor of the dictionary and expanding it if needed.
        resize();

        //TODO: Cambiar esto para hacer uso de bloques try-catch.
        if (key == null){
            System.out.println("The key cannot be null. Please enter a valid type.");
        }else {
            int hashKey = key.hashCode();
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
    }

    /**
     * Method for deleting and element from the dictionary, by marking the flag to 2 (liberated).
     * @param key Key of the object that we want to delete.
     */
    public void deleteElement(Object key){

        if (key == null){
            System.out.println("The key cannot be null. Please enter a valid type.");
        }else {
            int hashKey = key.hashCode();
            int positionElement = hashKey % table.length;
            if (table[positionElement].flag == 1) {
                table[positionElement].setFlag(2);
                size--;
            }
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

    //TODO: COMPROBAR: Hacer que se devuelva en un ARRAY. dict.keys(): Returns a view of all keys in the dictionary.
    /**
     * Method that shows all keys that are stored in the dictionary.
     */
    public void viewKeys(){
        for (Element element : table) {
            if (element.flag == 1) {
                System.out.println(element.getKey());
            }
        }
    }

    //TODO: COMPROBAR: Hacer que se devuelva en un ARRAY. dict.values(): Returns a view of all values in the dictionary.
    /**
     * Method that shows all values that are stored in the dictionary
     */
    public void viewValues(){
        for (Element element : table) {
            if (element.flag == 1) {
                System.out.println(element.getValue());
            }
        }
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
        return "Dictionary{" +
                ",\n size=" + size +
                ",\n chargeFactor=" + chargeFactor +
                ", \n table=" + Arrays.toString(table) +
                '}';
    }
}