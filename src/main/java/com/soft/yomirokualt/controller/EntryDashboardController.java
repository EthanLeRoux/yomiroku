package com.soft.yomirokualt.controller;

import com.soft.yomirokualt.domain.BookEntry;
import com.soft.yomirokualt.domain.VideoEntry;
import com.soft.yomirokualt.util.Helper;
import com.soft.yomirokualt.util.TextFileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EntryDashboardController {
    @FXML
    TableView tbvBookEntries;
    @FXML
    TableView tbvVideoEntries;
    private ObservableList<BookEntry> bookEntriesData = FXCollections.observableArrayList();
    private ObservableList<VideoEntry> videosEntriesData = FXCollections.observableArrayList();
    private ArrayList<BookEntry> arrayListBookEntries;
    private ArrayList<VideoEntry> arrayListVideoEntries;
    private Helper helper;

    @FXML
    public void initialize() {
        helper = new Helper();
        TextFileHandler textFileHandler = new TextFileHandler();

        // Create TableColumns:
        TableColumn<BookEntry, String> tableColumnBookEntryName = new TableColumn<>("Name");
        TableColumn<BookEntry, Integer> tableColumnBookEntryPagesRead = new TableColumn<>("Pages Read");
        TableColumn<BookEntry, Integer> tableColumnBookEntryChaptersRead = new TableColumn<>("Chapters Read");
        TableColumn<BookEntry, Integer> tableColumnBookEntryVolumesRead = new TableColumn<>("Volumes Read");
        TableColumn<BookEntry, LocalDate> tableColumnBookEntryDate = new TableColumn<>("Entry Date");

        //Video Entries
        TableColumn<VideoEntry, String> tableColumnVideoEntryName = new TableColumn<>("Name");
        TableColumn<VideoEntry, String> tableColumnVideoEntryUrl = new TableColumn<>("URL");
        TableColumn<VideoEntry, Double> tableColumnVideoEntryDuration = new TableColumn<>("Duration");
        TableColumn<VideoEntry, LocalDate> tableColumnVideoEntryDate = new TableColumn<>("Entry Date");

        tableColumnVideoEntryName.setCellValueFactory(
                new PropertyValueFactory<VideoEntry, String>("name")
        );
        tableColumnVideoEntryDuration.setCellValueFactory(
                new PropertyValueFactory<>("videoDuration")
        );
        tableColumnVideoEntryUrl.setCellValueFactory(
                new PropertyValueFactory<>("videoUrl")
        );
        tableColumnVideoEntryDate.setCellValueFactory(
                new PropertyValueFactory<>("entryDate")
        );

        //book entry cellvalue factories
        tableColumnBookEntryName.setCellValueFactory(
                new PropertyValueFactory<BookEntry, String>("name")
        );
        tableColumnBookEntryPagesRead.setCellValueFactory(
                new PropertyValueFactory<BookEntry, Integer>("pagesRead")
        );
        tableColumnBookEntryChaptersRead.setCellValueFactory(
                new PropertyValueFactory<BookEntry, Integer>("chaptersRead")
        );
        tableColumnBookEntryVolumesRead.setCellValueFactory(
                new PropertyValueFactory<BookEntry, Integer>("volumesRead")
        );
        tableColumnBookEntryDate.setCellValueFactory(
                new PropertyValueFactory<BookEntry, LocalDate>("entryDate")
        );

        tbvBookEntries.getColumns().add(tableColumnBookEntryName);
        tbvBookEntries.getColumns().add(tableColumnBookEntryPagesRead);
        tbvBookEntries.getColumns().add(tableColumnBookEntryChaptersRead);
        tbvBookEntries.getColumns().add(tableColumnBookEntryVolumesRead);
        tbvBookEntries.getColumns().add(tableColumnBookEntryDate);

        tbvVideoEntries.getColumns().add(tableColumnVideoEntryName);
        tbvVideoEntries.getColumns().add(tableColumnVideoEntryDate);
        tbvVideoEntries.getColumns().add(tableColumnVideoEntryDuration);
        tbvVideoEntries.getColumns().add(tableColumnVideoEntryUrl);

        arrayListBookEntries = textFileHandler.readFromBookEntrySerFile();
        arrayListVideoEntries = textFileHandler.readFromVideoEntrySerFile();

        if(arrayListBookEntries ==null || arrayListVideoEntries==null){
            System.out.println("fule no exist null.");
        }
        else{
            bookEntriesData.addAll(arrayListBookEntries);
            videosEntriesData.addAll(arrayListVideoEntries);
            tbvBookEntries.setItems(bookEntriesData);
            tbvVideoEntries.setItems(videosEntriesData);
        }

    }


    @FXML
    public void switchToSelectEntry(ActionEvent event) throws IOException {
        helper.switchScene(event, "/com/soft/yomirokualt/selectentry-view.fxml");
    }
}
