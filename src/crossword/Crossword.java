package crossword;

import java.util.List;

public class Crossword {
    private String word;
    private List<String> hints;

    public List<String> getHints() {
        return hints;
    }

    public void setHints(List<String> hints) {
        this.hints = hints;
    }

    private Catagory catagory;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }


    public Catagory getCatagory() {
        return catagory;
    }

    public void setCatagory(Catagory catagory) {
        this.catagory = catagory;
    }

    public int getLen() {
        return len;
    }


    public Crossword(String word) {
        this.word = word;
        this.word=this.word.replace(" ","");
        this.len=this.word.length();
    }

    private int len; //word length
    public enum Catagory {
        Sport,Technology,Animal,Health;
    }

    @Override
    public String toString() {
        return "{word='" + word + '\'' +
                ", hints=" + hints +
                ", catagory=" + catagory +
                '}';
    }
}
