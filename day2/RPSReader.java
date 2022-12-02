import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RPSReader {
    private final String fileName;

    public RPSReader(String fileName) {
        this.fileName = fileName;
    }

    public int decideScore(String line) {
        int score = 0;
        if (line.charAt(0) == 'A') {
            if (line.charAt(2) == 'X') {
                score += 3;
            } else if (line.charAt(2) == 'Y') {
                score += 4;
            } else if (line.charAt(2) == 'Z') {
                score += 8;
            }
        } else if (line.charAt(0) == 'B') {
            if (line.charAt(2) == 'X') {
                score += 1;
            } else if (line.charAt(2) == 'Y') {
                score += 5;
            } else if (line.charAt(2) == 'Z') {
                score += 9;
            }
        } else if (line.charAt(0) == 'C') {
            if (line.charAt(2) == 'X') {
                score += 2;
            } else if (line.charAt(2) == 'Y') {
                score += 6;
            } else if (line.charAt(2) == 'Z') {
                score += 7;
            }
        }
        return score;
    }

    public int decideElfScore(String line) {
        int new_score = 0;
        if (line.charAt(0) == 'A') {
            if (line.charAt(2) == 'X') {
                new_score += 4;
            } else if (line.charAt(2) == 'Y') {
                new_score += 8;
            } else if (line.charAt(2) == 'Z') {
                new_score += 3;
            }
        } else if (line.charAt(0) == 'B') {
            if (line.charAt(2) == 'X') {
                new_score += 1;
            } else if (line.charAt(2) == 'Y') {
                new_score += 5;
            } else if (line.charAt(2) == 'Z') {
                new_score += 9;
            }
        } else if (line.charAt(0) == 'C') {
            if (line.charAt(2) == 'X') {
                new_score += 7;
            } else if (line.charAt(2) == 'Y') {
                new_score += 2;
            } else if (line.charAt(2) == 'Z') {
                new_score += 6;
            }
        }
        return new_score;
    }

    public Pair<Integer, Integer> getScore() {
        int score = 0;
        int new_score = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                score += decideScore(line);
                new_score += decideElfScore(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Pair<>(score, new_score);
    }

}
