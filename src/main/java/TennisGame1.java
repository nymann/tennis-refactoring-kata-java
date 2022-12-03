public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
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

    private String getNormalScore() {
        StringBuilder score = new StringBuilder();
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (scoreIsEqual(i, 1)) tempScore = m_score1;
            else {
                score.append("-");
                tempScore = m_score2;
            }
            switch (tempScore) {
                case 0 -> score.append("Love");
                case 1 -> score.append("Fifteen");
                case 2 -> score.append("Thirty");
                case 3 -> score.append("Forty");
            }
        }
        return score.toString();
    }

    private String getAdvantageOrWin() {
        String score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
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
