public class TennisGame1 implements TennisGame {

    private final Player p1;
    private final Player p2;
    private int m_score1 = 0;
    private int m_score2 = 0;

    public TennisGame1(String player1Name, String player2Name) {
        this.p1 = new Player(player1Name);
        this.p2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) throws Exception {
        if (playerName.equals(this.p1.getName())) {
            m_score1 += 1;
        } else if (playerName.equals(this.p2.getName())) {
            m_score2 += 1;
        } else {
            throw new Exception("%s is not a valid playerName.".formatted(playerName));
        }
    }

    public String getScore() throws Exception {
        if (scoreIsEqual(m_score1, m_score2)) {
            return getEqualScore();
        }
        if (isAdvantageOrWin()) {
            return getAdvantageOrWin();
        }
        return getNormalScore();
    }

    private boolean isAdvantageOrWin() {
        return m_score1 >= 4 || m_score2 >= 4;
    }

    private boolean scoreIsEqual(int m_score1, int m_score2) {
        return m_score1 == m_score2;
    }

    private String getNormalScore() throws Exception {
        String p1 = playerScore(m_score1);
        String p2 = playerScore(m_score2);
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
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) {
            return "Advantage %s".formatted(this.p1.getName());
        } else if (minusResult == -1) {
            return "Advantage %s".formatted(this.p2.getName());
        } else if (minusResult >= 2) {
            return "Win for %s".formatted(this.p1.getName());
        } else {
            return "Win for %s".formatted(this.p2.getName());
        }
    }

    private String getEqualScore() {
        return switch (m_score1) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
