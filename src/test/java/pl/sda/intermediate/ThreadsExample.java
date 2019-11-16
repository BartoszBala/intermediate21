package pl.sda.intermediate;

import org.junit.jupiter.api.Test;

public class ThreadsExample {


    @Test
    void runnableBasics() {
        OurRunnable ourRunnable = new OurRunnable();            //praca do wykonania

        Runnable anonim = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " klasa anonimowa");
            }
        };

        Runnable anonim2 = () -> System.out.println(Thread.currentThread().getName()+ " lambda");




        Thread thread1 = new Thread(anonim, "t1");
        Thread thread2 = new Thread(ourRunnable, "t2");
        Thread thread3 = new Thread(anonim2, "t3");

        thread1.start();
        thread2.start();
        thread3.start();

        ourRunnable.run();


    }
}
