import model.Player;
import scoreRendering.ScoreRenderer;
import scoreRendering.ScoreRendererFactory;

public class TennisGame1 implements TennisGame {

    private final Player p1;
    private final Player p2;

    public TennisGame1(String player1Name, String player2Name) {
        this.p1 = new Player(player1Name);
        this.p2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.p1.getName())) {
            this.p1.addPoint();
        } else if (playerName.equals(this.p2.getName())) {
            this.p2.addPoint();
        } else {
            throw new RuntimeException("%s is not a valid playerName.".formatted(playerName));
        }
    }

    public String getScore() {
        ScoreRenderer scoreRenderer = new ScoreRendererFactory(p1, p2).create();
        return scoreRenderer.render(p1, p2);
    }
}
