package ui;

import crossword.Const;

public class MenuController {


    public void play() {
        Main.changeScene(Const.playGui);

    }

    public void words() {
        Main.changeScene(Const.words);
    }
}
