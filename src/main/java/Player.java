public class Player {
    private final String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public void addPoint() {
        this.score += 1;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
