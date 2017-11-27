package crossword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Gentics {
    private Character[][] chromosome;
    private int N, M, blanks;
    private ArrayList<Crossword> crosswords;
    private ArrayList<Character[][]> chromosomes = new ArrayList<>();

    public Gentics(Character[][] chromosome, int n, int m, int blanks) {
        this.chromosome = chromosome;
        N = n;
        M = m;
        this.blanks = blanks;
        crosswords = Save.getCrossWords();
    }

    public Character[][] getRandomChromo() {
        int lenCount = 0;
        for (int i = 0; i < crosswords.size(); i++) {
            lenCount += crosswords.get(i).getLen();
        }
        if (N * M - blanks < lenCount)
            return null;
        for (int i = 0; i < crosswords.size(); i++) {
            final char[] chars = crosswords.get(i).getWord().toCharArray();
            for (int j = 0; j < crosswords.get(i).getLen(); j++) {
                generateRandom(chars, j);
            }
        }
        return chromosome;
    }

    public void generateRandom(char[] chars, int j) {
        int k = new Random().nextInt(N);
        int l = new Random().nextInt(M);
        if (chromosome[k][l] == Const.white)//not black and doesn't have a letter
            chromosome[k][l] = chars[j];
        else
            generateRandom(chars, j);
    }

    public void generateSolutions() {
        for (int i = 0; i < 10; i++) {
            chromosomes.add(getRandomChromo());
            for (int j = 0; j < chromosomes.get(i).length; j++)
                System.out.println(Arrays.toString(chromosomes.get(i)[j]));
        }
    }
}


