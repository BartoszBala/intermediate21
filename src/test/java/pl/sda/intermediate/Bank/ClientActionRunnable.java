package pl.sda.intermediate.Bank;

import java.util.Random;

public class ClientActionRunnable implements  Runnable{
    @Override
    public void run() {
        Random random = new Random();
        int amount = random.nextInt(100);
        Bank.withdraw(amount);
        System.out.println(Thread.currentThread().getName()+"stan konta po pobraniu "+Bank.getBalance());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        Bank.deposit(amount);
        System.out.println(Thread.currentThread().getName()+"stan konta po depozycie "+Bank.getBalance());


    }
}
