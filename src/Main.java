import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import Tests.*;


 @RunWith(Suite.class)
 @SuiteClasses({
         TestEmptyDictionary.class,
         TestOneElementDictionary.class,
         TestTwoElementsDictionary.class,
 })

public class Main {
    public static void main(String[] args){
        org.junit.runner.JUnitCore.main("Main");
    }
 }