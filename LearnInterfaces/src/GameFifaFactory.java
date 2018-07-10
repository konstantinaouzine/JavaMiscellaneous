public class GameFifaFactory implements PS4GameFactory {
    @Override
    public PS4Game getGame() {
        return new GameFifa();
    }
}
