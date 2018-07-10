public class GameFifa implements PS4Game {
    private int startPosition;
    @Override
    public void playGame() {
        System.out.println("Fifa playing started");
    }

    @Override
    public void startGame() {
        startPosition = 0;
        System.out.println("Fifa started");
    }
}
