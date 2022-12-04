package scoreRendering;

import model.Player;

public class WinScoreRenderer implements ScoreRenderer {
    @Override
    public String render(Player p1, Player p2) {
        Player leader = p1.getScore() > p2.getScore() ? p1 : p2;
        return "Win for %s".formatted(leader.getName());
    }
}
