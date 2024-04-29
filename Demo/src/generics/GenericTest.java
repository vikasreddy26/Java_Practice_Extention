package generics;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) throws InterruptedException, AWTException {
        Generic<Integer> integerGeneric = new Generic<>(10);
        integerGeneric.print();
        Generic<String> stringGeneric = new Generic<>("Vikas");
        stringGeneric.print();
        GenericMethods genericMethods = new GenericMethods();
        System.out.println(genericMethods.add(20,30));
        String[] strings = {"apple", "banana", "cat", "dog", "elephant", "banana", "dog"};
        genericMethods.printArray(strings);
        Generic<String> generic = new Generic<>("vikas");
        List<String> list = Arrays.asList("apple", "banana", "cat", "dog", "elephant", "banana", "dog");
        System.out.println("********************************************");
        System.out.println(generic.get(list,2));

       while(true){
            new Robot().mouseMove(500,500);
            Thread.sleep(9000);
        }
    }
}
