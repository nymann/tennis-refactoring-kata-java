package scoreRendering;

import model.Player;

public class NormalScoreRenderer implements ScoreRenderer {
    @Override
    public String render(Player p1, Player p2) {
        try {
            return "%s-%s".formatted(playerScore(p1.getScore()), playerScore(p2.getScore()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String playerScore(int score) throws Exception {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new Exception("Score '%d' is not valid (must be [0;4])".formatted(score));
        };
    }
}
