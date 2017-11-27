package crossword;

import java.util.ArrayList;
import java.util.Random;

public class Gentics {
    private char[][] chromosome;
    private int N, M, blanks;
    private ArrayList<Crossword> crosswords;

    public Gentics(char[][] chromosome, int n, int m, int blanks) {
        this.chromosome = chromosome;
        N = n;
        M = m;
        this.blanks = blanks;
        crosswords = Save.getCrossWords();
    }

    public char[][] getRandomChromo() {
        int lenCount = 0;
        for (int i = 0; i < crosswords.size(); i++) {
            lenCount += crosswords.get(i).getLen();
        }
        if (N * M - blanks < lenCount)
            return null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (chromosome[i][j] != Const.black)
                    chromosome[i][j] = generateRandom();

            }
        }
        return chromosome;
    }

    public char generateRandom() {

        int i, j;
        i = new Random().nextInt(crosswords.size());
        String s = crosswords.get(i).getWord();
        j = new Random().nextInt(crosswords.get(i).getLen());
        return s.charAt(j);
    }

}

