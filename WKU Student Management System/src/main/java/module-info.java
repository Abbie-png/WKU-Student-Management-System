module org.example.wku_student_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;
    //requires org.example.wku_student_management_system;

    exports UI;
    opens UI to javafx.graphics;

    exports StudentManagement;
    opens StudentManagement to javafx.graphics;

}