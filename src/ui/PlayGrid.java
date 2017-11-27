package ui;

import crossword.Const;
import crossword.Gentics;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayGrid implements Initializable {
    public AnchorPane container;
    private int N = 3, M = 6;
    private char[][] words = new char[N][M];
    private GridPane playGrid = new GridPane();
    private int blankNo = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                words[i][j] = Const.white;
            }
        }
        populate();

    }

    @FXML
    void generate() {
        Gentics gentics = new Gentics(words, N, M, blankNo);
        words = gentics.getRandomChromo();
        if (words != null) {
            container.getChildren().remove(playGrid);
            populate();
        }
    }

    void populate() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Button label = new Button(String.valueOf(words[i][j]));
                label.getStyleClass().add("grid-label");
                int finalI = i;
                int finalJ = j;
                label.setOnAction((e) -> {
                    if (words[finalI][finalJ] == Const.white) {
                        label.setStyle("-fx-background-color:black");
                        words[finalI][finalJ] = Const.black;
                        blankNo++;
                    } else if (words[finalI][finalJ] == Const.black) {
                        if (blankNo > 0)
                            blankNo--;
                        label.setStyle("-fx-background-color: white");
                        words[finalI][finalJ] = Const.white;
                    }
                });
                playGrid.add(label, i, j);
            }
        }
        playGrid.setAlignment(Pos.CENTER);
        playGrid.setLayoutX(120);
        playGrid.setLayoutY(120);
        container.getChildren().add(playGrid);
    }
}
