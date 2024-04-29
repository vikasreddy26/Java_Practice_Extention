package generics;

import java.util.List;

public class GenericMethods {

    public <T extends Number,E extends Number> int add(T a, E b) {
        return a.intValue()+b.intValue();
    }

    public  <E> void printArray(E [] arr){
        for(E e : arr){
            System.out.println(e);
        }
    }

    public static <T> T getValue(T[] array, int index) {
            return array[index];
    }

    public int sum(List<? extends Number> list){
        Integer sum =0;
        for(Number number:list){
            sum = sum+number.intValue();
        }
        return sum;
    }
}
