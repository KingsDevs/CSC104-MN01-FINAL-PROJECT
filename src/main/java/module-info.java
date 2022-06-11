module com.csc104oop.shelves {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive java.sql;

    opens com.csc104oop.shelves to javafx.fxml;
    exports com.csc104oop.shelves;
}
