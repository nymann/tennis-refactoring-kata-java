public class ScoreRendererFactory {

    public ScoreRenderer createScoreRenderer(Player p1, Player p2) {
        if (p1.getScore() == p2.getScore()) {
            return new EqualScoreRenderer();
        }
        if (isAdvantageOrWin(p1, p2)) {
            return new AdvantageOrWinScoreRenderer();
        }
        return new NormalScoreRenderer();
    }

    private boolean isAdvantageOrWin(Player p1, Player p2) {
        return p1.getScore() >= 4 || p2.getScore() >= 4;
    }
}