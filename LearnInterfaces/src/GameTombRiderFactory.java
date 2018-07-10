public class GameTombRiderFactory implements PS4GameFactory {
    @Override
    public PS4Game getGame() {
        return new GameTombRider();
    }
}
