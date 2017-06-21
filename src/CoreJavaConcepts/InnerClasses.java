/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoreJavaConcepts;

/**
 *
 * @author Saiteja
 */
public class InnerClasses {

    public static void main(String[] args) {
        UsageClass usg = new UsageClass();

        //calling a public inner class
        UsageClass.Inner1 in = usg.new Inner1();
        in.print();
        //calling a final inner class.
        UsageClass.Inner2 in1 = usg.new Inner2();
        in1.print();

        //calling a local class in the method.
        // only that method can use the class.
        in1.methodInnerClass();

        //calling a static inner class with classname.innerclassname
        UsageClass.StaticInner extendThread = new UsageClass.StaticInner();
        extendThread.start();

        //calling a static inner class which is implemented by runnable.
        UsageClass.StaticInnerRunnable thread2 = new UsageClass.StaticInnerRunnable();
        Thread runnablethread = new Thread(thread2);
        runnablethread.start();

        //anonymous inner class
        Thread anonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("anonymous class's run()");
            }
        });
        anonThread.start();

        //lambda expression anonyomous class
        //possible only for functional interfaces.
        Thread anonThreadLambda = new Thread(()
                -> System.out.println("Lambda expresssion anonymous class's run()")
        );
        anonThreadLambda.start();

    }
}

class UsageClass {

    //public inner class
    public class Inner1 {

        public void print() {
            System.out.println("public inner1.print()");
        }
    }

    //final inner class
    final class Inner2 {

        public void print() {
            System.out.println("final inner2.print()");
        }

        //method containing a class
        public void methodInnerClass() {
            //class inside a method is also possibe
            class InMethodInnerClass extends Thread {
                @Override
                public void run(){
                    System.out.println("InMethodInnerClass.run()");
                }
                public int method() {
                    return 10;
                }
            }
            InMethodInnerClass inm = new InMethodInnerClass();
            System.out.println("class inside method " + inm.method());
            inm.start();
            //return inm;  //cant return the instance of inner class.
        }
    }

    //Thread class as a nested class or Static Inner Class of the usage class
    static class StaticInner extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }
    }

    //Another thread class as a nested class or Static Inner Class of the usage class
    static class StaticInnerRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }
    }

}
