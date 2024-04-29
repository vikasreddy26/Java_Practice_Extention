import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws AWTException, InterruptedException {
        System.out.println("vikas");
        Predicate <String> p = e->e.contains("v");
        String s ="vikas";

        if(p.test(s)){
            System.out.println("matched");
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.stream().sorted().forEach(e-> System.out.println(e));
        System.out.println("*******************************");
        arrayList.stream().map(e->e>3?e:null).filter(e->e!=null).forEach(e-> System.out.println(e));
        System.out.println("*******************************");
        HashMap<String,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("three",3);
        map.put("two",2);

        map.forEach((k,v)-> System.out.println(k +" | "+v));
        map.entrySet().forEach(e-> System.out.println(e.getKey()+" "+e.getValue()));
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
       //list.sort((e1,e2)->Integer.compare(e1.getValue(),e2.getValue()));
        list.sort(Map.Entry.comparingByValue());
      //list.sort(Comparator.comparing(Map.Entry::getValue));
        list.forEach(e-> System.out.println(e.getKey()+"  | "+e.getValue()));
        System.out.println("*******************************");
        System.out.println(list.stream().iterator().next());
        System.out.println("*******************************");
        fizzBuzz(99);

        IntStream stream = IntStream.range(5, 12);

        System.out.println(Arrays.asList("vikas","mano","reddy").stream()
                .collect(Collectors.toMap(e->e.length(),value->value,(first,second)->first)));

        String[] strings = {"apple", "banana", "cat", "dog", "elephant", "banana", "dog"};
        Stream<String> stringStream= Arrays.asList(strings).stream();
        HashMap<Integer,String> hashMap = new HashMap<>();

        Map<Integer, String> stringMap = Arrays.stream(strings)
                .collect(Collectors.toMap(
                        String::length,// Key mapper function
                       a -> a,(existingValue, newValue) -> existingValue
                ));

        System.out.println(stringMap);
    }

    public void variableArgs(int... a){
        int sum=0;
        for(int value:a){
            sum+=value;
        }
        System.out.println(sum);
    }

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            String output = "";
            if (i % 3 == 0) {
                output += "Fizz";
            }
            if (i % 5 == 0) {
                output += "Buzz";
            }
            System.out.println(output.isEmpty() ? i : output);
        }
    }
}
