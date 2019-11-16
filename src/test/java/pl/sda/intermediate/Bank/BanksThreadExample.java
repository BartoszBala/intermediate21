package pl.sda.intermediate.Bank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BanksThreadExample {


    @Test
    void sequential() {
        ClientActionRunnable clientActionRunnable = new ClientActionRunnable();
        for (int i = 0; i <100 ; i++) {
clientActionRunnable.run();
        }

    }

    @Test
    void threads() throws InterruptedException {

        List<Thread> thread = new ArrayList<>();

        for (int i = 0; i <100 ; i++) {
            thread.add(new Thread(new ClientActionRunnable()));
        }

        for (Thread thread1 : thread) {

            thread1.start();

        }
Thread.sleep(2000);


        for (Thread thread1 : thread) {
            thread1.join();
        }
        System.out.println("stan hajsu  w banku"+Bank.getBalance());
        System.out.println("liczba operacji "+Bank.getCounter());





    }
}
