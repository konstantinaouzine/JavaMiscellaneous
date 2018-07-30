public class Waxing extends Thread {
    Car car;
    public Waxing(Car car)
    {
        this.car = car;
    }
    public void run()
    {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Waxed");
                Thread.sleep(500);
                car.waxed();
                car.waitForPolishing();
            }
        }catch(InterruptedException e)
        {
            System.out.println("Waxing stopped according to interrupt");
        }
        System.out.println("Ending WAX on task");
    }
}
