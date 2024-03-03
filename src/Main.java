public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary(3);
        System.out.println(dictionary.toString());


        dictionary.insertElement(12,"meeee");
        System.out.println(dictionary.toString());
        dictionary.insertElement(13,"JAJAJAJAJ");
        System.out.println(dictionary.toString());
        dictionary.insertElement(14,"BUUUUU");
        System.out.println(dictionary.toString());
        dictionary.insertElement(12,"TEST");
        System.out.println(dictionary.toString());
        dictionary.deleteElement(13);
        System.out.println(dictionary.toString());
        dictionary.insertElement(13, "tetetet");
        System.out.println(dictionary.toString());
    }
}