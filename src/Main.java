import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import Tests.*;

import java.util.Arrays;


@RunWith(Suite.class)
 @SuiteClasses({
         TestEmptyDictionary.class,
         TestOneElementDictionary.class,
         TestTwoElementsDictionary.class,
         TestMoreThanHalfElements.class,
 })

public class Main {
    public static void main(String[] args){
        org.junit.runner.JUnitCore.main("Main");

    }
 }