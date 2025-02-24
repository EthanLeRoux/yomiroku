package com.soft.yomirokualt.controller;

import com.soft.yomirokualt.util.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class SelectEntryController {
    @FXML
    private Button btnBookEntry;
    @FXML
    private Button btnVideoEntry;

    private Helper helper;

    @FXML
    private void initialize() {
        helper = new Helper();
    }
    @FXML
    public void switchToBook(ActionEvent event) throws IOException {
        helper.switchScene(event, "/com/soft/yomirokualt/newbookentry-view.fxml");
    }

    @FXML
    public void switchToVideo(ActionEvent event) throws IOException {
        helper.switchScene(event, "/com/soft/yomirokualt/newvideoentry-view.fxml");
    }

}
