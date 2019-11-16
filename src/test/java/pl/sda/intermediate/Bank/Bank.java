package pl.sda.intermediate.Bank;

import java.util.concurrent.atomic.AtomicInteger;

public class Bank {

  private static int balance1 =1000;
private static AtomicInteger balance =new AtomicInteger(1000);  //  to jest lepsze rozwiązanie
   private static AtomicInteger counter =new AtomicInteger(0);

    public /*synchronized*/ static void deposit(int amount)
    {
counter.incrementAndGet();
        balance.addAndGet(amount);
    }

    public /*synchronized*/   static  void withdraw(int amount)
    {

        balance.addAndGet(-amount);

    }

    public  static int  getBalance()
    {
        return balance.intValue();

    }

    public  static int getCounter()
    {
        return counter.intValue();

    }


}
