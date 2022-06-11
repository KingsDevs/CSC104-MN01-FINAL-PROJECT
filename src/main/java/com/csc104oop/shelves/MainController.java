package com.csc104oop.shelves;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class MainController implements Initializable
{

    @FXML
    private Button addBtn;

    @FXML
    private TableColumn<Book, String> authorCol;

    @FXML
    private TextField authorField;

    @FXML
    private TableColumn<Book, String> bookTitleCol;

    @FXML
    private TextField bookTitleField;

    @FXML
    private TableColumn<Book, String> dateReleasedCol;

    @FXML
    private DatePicker dateReleasedDatePicker;

    @FXML
    private Button deleteBtn;

    @FXML
    private ChoiceBox<String> genreChoiceBox;

    @FXML
    private TableColumn<Book, String> genreCol;

    @FXML
    private TableColumn<Book, Integer> pagesCol;

    @FXML
    private TextField pagesField;

    @FXML
    private TableView<Book> shelfTable;

    @FXML
    private Button updateBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) 
    {
        bookTitleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        dateReleasedCol.setCellValueFactory(new PropertyValueFactory<Book, String>("dateReleased"));
        genreCol.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        pagesCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("pages"));

        try {
            updateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        


        deleteBtn.setDisable(true);
        updateBtn.setDisable(true);

        shelfTable.getSelectionModel().selectedIndexProperty().addListener(
            (obs , oldSelection, newSelection) ->  {
                if(newSelection != null)
                {
                    deleteBtn.setDisable(false);
                    updateBtn.setDisable(false);
                }
                else
                {
                    deleteBtn.setDisable(true);
                    updateBtn.setDisable(true);
                }
            }
        );

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

    private void updateTable() throws SQLException, IOException
    {
        ObservableList<Book> shelf = shelfTable.getItems();
        shelf.clear();

        ResultSet resultSet = Book.getBooksFromShelf();
        while (resultSet.next()) 
        {
            Book book = new Book(
                                 resultSet.getInt("book_id"), 
                                 resultSet.getString("book_title"), 
                                 resultSet.getString("book_author"), 
                                 resultSet.getString("book_date_released"), 
                                 resultSet.getString("book_genre"), 
                                 resultSet.getInt("book_numpages"));
            
            shelf.add(book);
        }


    }

    @FXML
    void addBook(ActionEvent event) {

    }

    @FXML
    void deleteBook(ActionEvent event) throws IOException, SQLException
    {
        Book selectedBook = shelfTable.getSelectionModel().getSelectedItem();
        
        int bookId = selectedBook.getId();
        System.out.println(bookId);

        Alert confirmToDelete = new Alert(AlertType.CONFIRMATION);
        confirmToDelete.setContentText("Are you sure to delete this book?");

        confirmToDelete.showAndWait().ifPresent(response -> {
            if(response == ButtonType.OK)
            {
                try {
                    Book.deleteBook(bookId);
                    updateTable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @FXML
    void updateBook(ActionEvent event) {

    }
    

}
