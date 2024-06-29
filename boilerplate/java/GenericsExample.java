import java.util.*;
class Container<T> {
    T value;
    public Container () {
        // this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }
}

class WildCardContainer {

    public void printValue(List<?> lst){
        for(Object t: lst){
            Container<?> tmp = (Container<?>) t;
            System.out.println(tmp.getValue());
        }
    }
}

class GenericsExample {

    
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
    
    public static void main(String[] args) {
        
        Container<Integer> intContainer = new Container<>();
        intContainer.setValue(12);
        System.out.println(intContainer.getValue());

        Container<String> stringContainer = new Container<>();
        stringContainer.setValue("String Value");
        System.out.println(stringContainer.getValue());

        List<Container<?>> lst = new ArrayList<>();
        lst.add(stringContainer);
        lst.add(intContainer);

        WildCardContainer wc = new WildCardContainer();
        wc.printValue(lst);
        // wc.printValue(intContainer);

    }
}