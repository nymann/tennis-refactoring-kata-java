public class AdvantageOrWinScoreRenderer implements ScoreRenderer {
    @Override
    public String render(Player p1, Player p2) {
        int scoreDelta = Math.abs(p1.getScore() - p2.getScore());
        Player leader = p1.getScore() > p2.getScore() ? p1 : p2;
        if (scoreDelta == 1) {
            return "Advantage %s".formatted(leader.getName());
        }
        return "Win for %s".formatted(leader.getName());
    }
}
