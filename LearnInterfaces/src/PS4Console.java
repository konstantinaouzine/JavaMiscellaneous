import org.jetbrains.annotations.Contract;

public class PS4Console {
    private static void playGame(PS4GameFactory _someFactory) throws InterruptedException {
            PS4Game myGame = _someFactory.getGame();
            myGame.startGame();
            Thread.sleep(3000);
            myGame.playGame();
            Thread.sleep(3000);
        }


    public static void main(String[] args) throws InterruptedException {
       playGame(null);
//        payGame(new GameTombRiderFactory());

    }
}
