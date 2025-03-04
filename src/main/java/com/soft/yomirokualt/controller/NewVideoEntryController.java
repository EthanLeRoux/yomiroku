package com.soft.yomirokualt.controller;

import com.soft.yomirokualt.domain.VideoEntry;
import com.soft.yomirokualt.factory.VideoEntryFactory;
import com.soft.yomirokualt.util.Helper;
import com.soft.yomirokualt.util.TextFileHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class NewVideoEntryController {
    @FXML
    private TextField txtVideoName;
    @FXML
    private TextField txtVideoUrl;
    @FXML
    private TextField txtVideoDuration;
    @FXML
    private Button btnSaveEntry;
    private VideoEntryFactory videoEntryFactory;
    private Helper helper;

    @FXML
    public void initialize() {
        helper = new Helper();
    }
    @FXML
    void saveBookEntry(){
        TextFileHandler textFileHandler = new TextFileHandler();
        String videoName = txtVideoName.getText();
        String videourl = txtVideoUrl.getText();
        double videoDuration =Double.parseDouble(txtVideoDuration.getText());

        VideoEntry videoEntry = videoEntryFactory.createVideoEntry(videoName,videoDuration,videourl);
        textFileHandler.writeVideoEntryToSerFile(videoEntry);
    }
    @FXML
    void goToDashboard(ActionEvent event) throws IOException {
        helper.switchScene(event, "/com/soft/yomirokualt/entriesdashboard-view.fxml");
    }
}
