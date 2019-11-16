package pl.sda.intermediate;

public class OurRunnable implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " Text From our Runnable");
    }
}
