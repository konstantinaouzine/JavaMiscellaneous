import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Car {
    boolean isWaxed = false;

    public synchronized void waxed()
    {
        isWaxed = true;
        notifyAll();
    }

    public synchronized void polished()
    {
        isWaxed = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (!isWaxed)
            wait();
    }

    public synchronized void waitForPolishing() throws InterruptedException {
        while (isWaxed)
            wait();
    }

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        Waxing waxing = new Waxing(car);
        Polishing polishing= new Polishing(car);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(waxing);
        exec.execute(polishing);
        Thread.sleep(5000);
        exec.shutdownNow();
    }
}
