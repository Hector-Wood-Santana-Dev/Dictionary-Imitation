import Dictionary.*;

import java.util.Arrays;
 import org.junit.runner.RunWith;
 import org.junit.runners.Suite;
 import org.junit.runners.Suite.SuiteClasses;
 import Tests.*;


 @RunWith(Suite.class)
 @SuiteClasses({
         Tests.TestEmptyDictionary.class,

 })

public class Main {
    public static void main(String[] args){
        Dictionary dictionary = new Dictionary();
        System.out.println(dictionary.toString());

        //dictionary.insertElement(12,"meeee");
        //System.out.println(dictionary.toString());
        //dictionary.insertElement(13,"JAJAJAJAJ");
        //System.out.println(dictionary.toString());
        //dictionary.insertElement(14,"BUUUUU");
        //System.out.println(dictionary.toString());
        //dictionary.insertElement(12,"TEST");
        //System.out.println(dictionary.toString());
        //dictionary.deleteElement(13);
        //System.out.println(dictionary.toString());
        //dictionary.insertElement(13, "tetetet");
        //System.out.println(dictionary.toString());
        //dictionary.insertElement(null,null);
        //System.out.println(dictionary.toString());
        //Object[] var = dictionary.returnKeys();
        //System.out.println(Arrays.toString(var));
        //Object[] var2 = dictionary.returnValues();
        //System.out.println(Arrays.toString(var2));
        //Object var3 = dictionary.getDictionaryValue(77, "NO HAY");
        //System.out.println(var3);
    }
 }