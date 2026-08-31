module graficas {
    requires javafx.controls;
    requires javafx.fxml;

    // Exporta y abre los subpaquetes del proyecto
    exports graficas.view;
    exports graficas.controller;
    exports graficas.model;

    opens graficas.view to javafx.graphics, javafx.fxml;
    opens graficas.controller to javafx.fxml;
    opens graficas.model to javafx.fxml;
}