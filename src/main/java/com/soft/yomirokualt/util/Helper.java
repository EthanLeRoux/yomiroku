package com.soft.yomirokualt.util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Helper {
    private Stage stage;
    private Parent root;

    public void switchScene(ActionEvent event, String fxmlFile) throws IOException {
            root = FXMLLoader.load(getClass().getResource(fxmlFile));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
    }

    public Boolean checkIfStringValueIsValid(String stringValue){
        if(stringValue.isEmpty() || stringValue==null){
            System.out.println("Values are either empty or null");
            return false;
        }
        return true;
    }

    public Boolean checkIfIntValueIsValid(int intValue){
        if(!(intValue <0)){
            System.out.println("Values are not positive integers");
            return false;
        }
        return true;
    }

    public  Boolean checkIfLocalDateisValid(LocalDate localDateValue){
        DateTimeFormatter localDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if((localDateValue == null) || localDateValue.equals(null)){
            System.out.println("Values are null or empty");
            return false;
        }
        return true;
    }
}
