package ui;

import crossword.Const;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class PlayGrid implements Initializable {
    public AnchorPane container;
    private int N = 10, M = 5;
    private char[][] words = new char[N][M];
    private GridPane playGrid = new GridPane();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Button label = new Button();
                label.getStyleClass().add("grid-label");
                int finalI = i;
                int finalJ = j;
                label.setOnAction((e) -> {
                    label.setStyle("-fx-background-color: black");
                    words[finalI][finalJ] = Const.blank;
                    System.out.println(Arrays.toString(words));
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
