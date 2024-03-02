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
     * @param key of the element
     * @param value of the element
     */
    public void insertElement(Object key, Object value){
        //Checking the charge factor of the dictionary and expanding it

        // TODO: HAY QUE METER EL IF EN EL METODO RESIZE
        resize();

        //TODO: ALGO SIGUE FALLANDO CUANDO TIENE QUE HACER RESIZE.

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
                } else {
                    table[i] = new Element(key, value, 1);
                    size++;
                }
            }
            for (int i = positionElement; i > 0; i--) {
                if (table[i].flag == 1 && key.equals(table[i].getKey())){
                    table[i].setValue(value);
                } else {
                    table[i] = new Element(key, value, 1);
                    size++;
                }
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

            for (int i = 0; i < table.length; i++) {
                exchangeDictionary.insertElement(table[i].getKey(), table[i].getValue());
            }
            this.table = exchangeDictionary.table;
            this.size = exchangeDictionary.size;
        }
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "table=" + Arrays.toString(table) +
                ",\n size=" + size +
                ",\n chargeFactor=" + chargeFactor +
                '}';
    }
}