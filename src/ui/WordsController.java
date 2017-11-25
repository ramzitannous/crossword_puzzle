package ui;

import crossword.Const;
import crossword.Crossword;
import crossword.Save;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class WordsController implements Initializable{

    @FXML
    private ScrollPane wordsContainer;

    @FXML
    private TextField word;

    @FXML
    private TextField clues;


    @FXML
    private ComboBox<Crossword.Catagory> topics;

    private ArrayList<Crossword>crosswords;
    @FXML
    void back() {
        Main.changeScene(Const.menu);
        Save.saveCrossWords(crosswords);
    }

    @FXML
    void saveWord() {
        String cl,wor;
        cl=clues.getText();
        wor=word.getText();
        Crossword.Catagory catagory=topics.getValue();
        String[] cls;
        if(cl.contains(",")) {
            cls= cl.split(",");
        }
        else { //one word
            cls=new String[]{cl};
        }
        Crossword crossword=new Crossword(wor);
        crossword.setHints(Arrays.asList(cls));
        crossword.setCatagory(catagory);
        crosswords.add(crossword);
        showWords();
        clearAll();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topics.setItems(FXCollections.observableList(Const.topicsArray));
        crosswords= Save.getCrossWords();
        Main.stage.setOnHidden(event -> {
            Save.saveCrossWords(crosswords);
            System.out.println("closed");
        });
        showWords();
    }

    private void showWords(){
        if(wordsContainer.getContent()!=null)
            wordsContainer.setContent(null);
        int count=0;
        VBox vBox=new VBox();
        for(Crossword c:crosswords){
            Image image = new Image("ui/delete.png");
            ImageView imageView = new ImageView(image);
            HBox hBox=new HBox();
            hBox.setId("myBox");
            Label label = new Label((count + 1) + ". " + c.toString());
            Button button=new Button();
            int finalCount = count;
            button.setId("del");
            button.setGraphic(imageView);
            button.setOnAction(e->{
                if(crosswords.size()>0) {
                    crosswords.remove(finalCount);
                    showWords();
                }
            });
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setSpacing(10);
            hBox.getChildren().addAll(label,button);
            vBox.getChildren().add(hBox);
            count++;
        }
        vBox.setSpacing(5);
        wordsContainer.setContent(vBox);
    }

    private void clearAll(){
        word.setText("");
        clues.setText("");
    }

}
