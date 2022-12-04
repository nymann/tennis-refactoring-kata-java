package scoreRendering;

import model.Player;

public class EqualScoreRenderer implements ScoreRenderer {
    @Override
    public String render(Player p1, Player p2) {
        return switch (p1.getScore()) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
