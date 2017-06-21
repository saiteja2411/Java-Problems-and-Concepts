/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoreJavaConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.Optional;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;

/**
 *
 * @author Saiteja
 */




 
public class Java8BasicPractice {

    public static void main(String[] args) {
       int abc = 20;
        BiFunction bi = (q, w) -> (Integer) q + (Integer) w;
        System.out.println(bi.apply(150, 200));
        
        //static method of interface
        demoI.stat();

        java.util.function.BinaryOperator bif = (g, h) -> (Integer) g + (Integer) h;
        bif.apply(10, 20);
        //java.util.function.BinaryOperator
        System.out.println(calculate((a, b) -> a + b));
        System.out.println(calculate((a, b) -> a - b));
        System.out.println(calculate((a, b) -> a * b));
        System.out.println(calculate((a, b) -> a / b));

        Consumer c = i -> System.out.println(i + " using consumer");
        display(c);
        BiConsumer b = (x, y) -> {
            int z = Integer.parseInt(x.toString()) + (Integer) y;
            System.out.println("sum is " + z);
        };
        display2(b);

        List l = new ArrayList(Arrays.asList(10, 20, 30, 40, 50));
        l.forEach(System.out::println);
        l.forEach((e) -> System.out.println(e));

        l.stream()
                .filter(s -> (Integer) s > 20)
                .forEach(System.out::println);

        Person arr[] = {
            new Person("sai", 25),
            new Person("teja", 30),
            new Person("pavan", 74),
            new Person("guda", 28),
            new Person("nitin", 42),
            new Person("roopesh", 18),
            new Person("prav", 39)
        };

        demo2I<Person> dem = (a) -> {
            List<Person> list = new ArrayList();
            for (int i = 0; i < a.length; i++) {
                list.add(a[i]);
            }
            return list;
        };

        System.out.println("------BEFORE SORTING------");
        displayPersons(dem, arr);
        System.out.println("------AFTER SORTING------");
        sortAge1(dem, arr);
        System.out.println("------ADDITIONAL------");
        sortAge(dem, arr);
        //divisiblility by 5
        int x1 = 4; // closure
        
        divisibility(l, (U) -> {
            return ((Integer) U % x1 == 0);
        });

        System.out.println("------AFG------");

        List<Integer> lis = new ArrayList();
        lis.add(10);
        lis.forEach(Java8BasicPractice::dummy);
    }

    static void dummy(Integer abc) {
        abc = abc + 20;
        System.out.println(abc);
    }
    
     void dummy1(Integer abc) {
         
        abc = abc + 20;
        dummy2(abc);
        System.out.println(abc);
    }
      
     void dummy2(Integer abc) {
        abc = abc + 20;
        System.out.println(abc);
    }

    static void divisibility(List l, Predicate b) {
        l.stream().filter(b).forEach(System.out::println);
    }

    static int calculate(demoI add) {
        add.sayHello();
        return add.calc(10, 20);
        
    }

    static void display(Consumer c) {
        c.accept(10);
    }

    static void display2(BiConsumer c) {
        c.accept(10, 20);
    }

    static void displayPersons(demo2I c, Person[] p) {
        c.getList(p).forEach((a) -> System.out.println(a));
        c.getList(p).forEach(System.out::println);
    }

    static void sortAge1(demo2I<Person> dem, Person[] p) {
        dem.getList(p).stream()
                .sorted((p1, p2) -> p1.fname.compareTo(p2.fname))
                .filter(s -> s.age < 100)
                .forEach(System.out::println);
        
    }
    
    static void sortAge(demo2I<Person> dem, Person[] p) {
        //Map<String,Integer> map =
                dem.getList(p).stream()
                .sorted((p1, p2) -> p1.fname.compareTo(p2.fname))
                .filter(s -> s.age < 100)
                .map(h->{h.age+=10;return h;})
                .filter(s -> s.fname.equals("guda") || s.fname.equals("pavan"))
                 //.forEach(System.out::println); //getting in order
                .collect(toMap(s->s.fname,I->I.age)) //loosing the order
                .forEach((s,i)->{System.out.println(s+" "+i);});
                //System.out.println(map);
                
                
        System.out.println("-----------");
        Person person=dem.getList(p).stream()
               .max((p1,p2)->(p1.age>p2.age)?1:-1)
               .orElse(null);//if min not present.
        System.out.println(person);
        
        person=dem.getList(p).stream()
               .min((p1,p2)->(p1.age>p2.age)?1:-1)
               .orElseGet(()->new Person("default",0)); //if min not present. takes supplier
        System.out.println(person);
        
        System.out.println(dem.getList(p).stream().count());
    }
}

@FunctionalInterface
interface demoI {

    int calc(int i, int b);

    default void sayHello() {
        System.out.println("IN Interface");
    }
    static void stat(){
        System.out.println("In static");
    }
}

@FunctionalInterface
interface demo2I<T> {

    List<T> getList(T[] a);
}

class abc{
    protected int i=10;

    public abc() {
    }
    
}