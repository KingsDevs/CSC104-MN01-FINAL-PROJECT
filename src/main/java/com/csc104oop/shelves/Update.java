package com.csc104oop.shelves;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Update implements Initializable
{

    @FXML
    private Button addBtn;

    @FXML
    private TextField authorField;

    @FXML
    private TextField bookTitleField;

    @FXML
    private DatePicker dateReleasedDatePicker;

    @FXML
    private ChoiceBox<String> genreChoiceBox;

    @FXML
    private TextField pagesField;

    private Book book;

    public void setBook(Book book)
    {
        this.book = book;

        bookTitleField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        pagesField.setText(book.getPages().toString());
        genreChoiceBox.setValue(book.getGenre());
        dateReleasedDatePicker.setValue(LocalDate.parse(book.getDateReleased()));
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
        genreChoiceBox.getItems().add("Action and Adventure");
        genreChoiceBox.getItems().add("Classics");
        genreChoiceBox.getItems().add("Graphic Novel");
        genreChoiceBox.getItems().add("Detective and Mystery");
        genreChoiceBox.getItems().add("Fantasy");
        genreChoiceBox.getItems().add("Historical Fiction");
        genreChoiceBox.getItems().add("Horror");
        genreChoiceBox.getItems().add("Literary Fiction");
        genreChoiceBox.getItems().add("Romance");
        genreChoiceBox.getItems().add("Science Fiction");
        genreChoiceBox.getItems().add("Short Stories");
        genreChoiceBox.getItems().add("Suspense and Thrillers");
        genreChoiceBox.getItems().add("Women's Fiction");
        genreChoiceBox.getItems().add("Biographies and Autobiographies");
        genreChoiceBox.getItems().add("Cookbooks");
        genreChoiceBox.getItems().add("Essays");
        genreChoiceBox.getItems().add("History");
        genreChoiceBox.getItems().add("Memoir");
        genreChoiceBox.getItems().add("Poetry");
        genreChoiceBox.getItems().add("Self-Help");
        genreChoiceBox.getItems().add("True Crime");
        

        pagesField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                if (!newValue.matches("\\d*")) {
                    pagesField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    @FXML
    void addBook(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {

    }

   

}
