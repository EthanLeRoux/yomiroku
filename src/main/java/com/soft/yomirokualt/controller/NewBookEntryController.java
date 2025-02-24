package com.soft.yomirokualt.controller;

import com.soft.yomirokualt.domain.BookEntry;
import com.soft.yomirokualt.util.Helper;
import com.soft.yomirokualt.util.TextFileHandler;
import com.soft.yomirokualt.factory.BookEntryFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class NewBookEntryController {
    @FXML
    private TextField txtBookName;
    @FXML
    private TextField txtPagesRead;
    @FXML
    private TextField txtChaptersRead;
    @FXML
    private TextField txtVolumesRead;
    @FXML
    private Button btnSaveEntry;
    @FXML
    private Button btnGoToDashboard;
    private Helper helper;
    private BookEntryFactory bookEntryFactory;
    @FXML
    public void initialize() {
        helper = new Helper();
    }
    @FXML
    void saveBookEntry(){
        TextFileHandler textFileHandler = new TextFileHandler();
        String bookName = txtBookName.getText();
        int pagesRead = Integer.parseInt(txtPagesRead.getText());
        int chaptersRead = Integer.parseInt(txtChaptersRead.getText());
        int volumesRead = Integer.parseInt(txtVolumesRead.getText());
        LocalDate date = LocalDate.now();

        BookEntry book = BookEntryFactory.createBookEntry(bookName,pagesRead,chaptersRead,volumesRead, date);
        textFileHandler.writeBookEntryToSerFile(book);
    }

    @FXML
    void goToDashboard(ActionEvent event) throws IOException {
        helper.switchScene(event, "/com/soft/yomirokualt/entriesdashboard-view.fxml");
    }
}
