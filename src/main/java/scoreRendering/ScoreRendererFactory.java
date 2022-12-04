package scoreRendering;

import model.Player;

public class ScoreRendererFactory {
    private final Player p1;
    private final Player p2;

    public ScoreRendererFactory(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public ScoreRenderer create() {
        if (isEqual()) {
            return new EqualScoreRenderer();
        }
        if (isWin()) {
            return new WinScoreRenderer();
        }
        if (isAdvantage()) {
            return new AdvantageScoreRenderer();
        }
        return new NormalScoreRenderer();
    }

    private boolean isEqual() {
        return p1.getScore() == p2.getScore();
    }

    private boolean pointIsInFinalPhase() {
        return p1.getScore() > 3 || p2.getScore() > 3;
    }

    private int scoreDelta() {
        return Math.abs(p1.getScore() - p2.getScore());
    }

    private boolean isWin() {
        return pointIsInFinalPhase() && scoreDelta() > 1;
    }

    private boolean isAdvantage() {
        return pointIsInFinalPhase() && scoreDelta() == 1;
    }
}