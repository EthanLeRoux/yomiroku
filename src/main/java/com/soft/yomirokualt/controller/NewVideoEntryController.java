package com.soft.yomirokualt.controller;

import com.soft.yomirokualt.domain.VideoEntry;
import com.soft.yomirokualt.factory.VideoEntryFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

    @FXML
    void saveBookEntry(){
        String videoName = txtVideoName.getText();
        String videourl = txtVideoUrl.getText();
        double videoDuration =Double.parseDouble(txtVideoDuration.getText());

        LocalDate date = LocalDate.now();

        VideoEntry videoEntry = videoEntryFactory.createVideoEntry(videoName,videoDuration,videourl);

    }
}
