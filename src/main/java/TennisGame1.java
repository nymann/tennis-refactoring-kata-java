public class TennisGame1 implements TennisGame {

    private final Player p1;
    private final Player p2;

    public TennisGame1(String player1Name, String player2Name) {
        this.p1 = new Player(player1Name);
        this.p2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) throws Exception {
        if (playerName.equals(this.p1.getName())) {
            this.p1.addPoint();
        } else if (playerName.equals(this.p2.getName())) {
            this.p2.addPoint();
        } else {
            throw new Exception("%s is not a valid playerName.".formatted(playerName));
        }
    }

    public String getScore() throws Exception {
        if (scoreIsEqual(this.p1.getScore(), this.p2.getScore())) {
            return getEqualScore();
        }
        if (isAdvantageOrWin()) {
            return getAdvantageOrWin();
        }
        return getNormalScore();
    }

    private boolean isAdvantageOrWin() {
        return this.p1.getScore() >= 4 || this.p2.getScore() >= 4;
    }

    private boolean scoreIsEqual(int m_score1, int m_score2) {
        return m_score1 == m_score2;
    }

    private String getNormalScore() throws Exception {
        String p1 = playerScore(this.p1.getScore());
        String p2 = playerScore(this.p2.getScore());
        return "%s-%s".formatted(p1, p2);
    }

    private String playerScore(int score) throws Exception {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new Exception("Score not valid");
        };
    }

    private String getAdvantageOrWin() {
        int scoreDelta = Math.abs(p1.getScore() - this.p2.getScore());
        Player leader = this.p1.getScore() > this.p2.getScore() ? this.p1 : this.p2;
        if (scoreDelta == 1) {
            return "Advantage %s".formatted(leader.getName());
        }
        return "Win for %s".formatted(leader.getName());
    }

    private String getEqualScore() {
        return switch (this.p1.getScore()) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
