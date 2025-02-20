package com.yomiroku.yomiroku.controller;

import com.yomiroku.yomiroku.domain.BookEntry;
import com.yomiroku.yomiroku.factory.BookEntryFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    private BookEntryFactory bookEntryFactory;

    @FXML
    void saveBookEntry(){
        String bookName = txtBookName.getText();
        int pagesRead = Integer.parseInt(txtPagesRead.getText());
        int chaptersRead = Integer.parseInt(txtChaptersRead.getText());
        int volumesRead = Integer.parseInt(txtVolumesRead.getText());
        LocalDate date = LocalDate.now();

        BookEntry book = BookEntryFactory.createBookEntry(bookName,pagesRead,chaptersRead,volumesRead, date);

    }
}
