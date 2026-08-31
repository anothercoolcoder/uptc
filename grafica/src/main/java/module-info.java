module graficas {
    requires javafx.controls;
    requires javafx.fxml;

    opens graficas to javafx.fxml;
    exports graficas;
}
