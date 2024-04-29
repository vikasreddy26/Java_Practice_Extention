package Annotations;

import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void main(String[] args) throws NoSuchMethodException {
        Class<Myclass> myclass = Myclass.class;
        Method method = myclass.getMethod("something");

        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);//getting annotation instance
        String str = myAnnotation.get();
        int value = myAnnotation.howmuch();
        System.out.println(str + " " + value);

        Method myMethod = new Myclass().getClass().getMethod("something");
        System.out.println(myMethod.getAnnotation(MyAnnotation.class));
    }
}
