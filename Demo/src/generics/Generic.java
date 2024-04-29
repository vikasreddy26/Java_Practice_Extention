package generics;

import java.util.List;

public class Generic<T> {

    public T context;


    public Generic(T context){
        this.context = context;
    }

    public void print(){
        System.out.println(context);
    }

    public T get(List<?> list,int index){
        for(int i = 0;i<list.size();i++){
                 if(index==i){
                     return (T) list.get(i);
                 }

        }
        return null;
    }

}
