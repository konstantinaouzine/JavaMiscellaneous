public class Polishing extends Thread{
    Car car;
    public Polishing(Car car)
    {
        this.car = car;
    }
    public void run()
    {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Polished");
                Thread.sleep(500);
                car.polished();
                car.waitForWaxing();
            }
        }catch(InterruptedException e)
        {
            System.out.println("Polishing stopped according to interrupt");
        }
        System.out.println("Ending Polish on task");
    }
}
