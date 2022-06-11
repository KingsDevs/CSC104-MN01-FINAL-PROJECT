package com.csc104oop.shelves;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class MainController {

    @FXML
    private Button addBtn;

    @FXML
    private TableColumn<?, ?> authorCol;

    @FXML
    private TextField authorField;

    @FXML
    private TableColumn<?, ?> bookTitleCol;

    @FXML
    private TextField bookTitleField;

    @FXML
    private TableColumn<?, ?> dateReleasedCol;

    @FXML
    private DatePicker dateReleasedDatePicker;

    @FXML
    private Button deleteBtn;

    @FXML
    private ChoiceBox<?> genreChoiceBox;

    @FXML
    private TableColumn<?, ?> genreCol;

    @FXML
    private TableColumn<?, ?> pagesCol;

    @FXML
    private TextField pagesField;

    @FXML
    private TableView<?> shelfTable;

    @FXML
    private Button updateBtn;



    @FXML
    void addBook(ActionEvent event) {

    }

    @FXML
    void deleteBook(ActionEvent event) {

    }

    @FXML
    void updateBook(ActionEvent event) {

    }
    

}
