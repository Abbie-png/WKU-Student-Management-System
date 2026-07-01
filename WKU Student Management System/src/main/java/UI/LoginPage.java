package UI;

import StudentManagement.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.geometry.*;

import static StudentManagement.DataStore.*;

public class LoginPage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    ComboBox<String> userTypeCombo = new ComboBox<>();
    TextField IDField = new TextField();
    HBox welcomeBox = new HBox();
    HBox btnBox = new HBox();
    VBox all = new VBox();
    GridPane loginPane = new GridPane(10, 10);

    @Override
    public void start(Stage loginStage) {
        DataInitializer.loadData();


        Label welcomeLabel = createLabel("Welcome to Students Management System!");
        welcomeLabel.setFont(Font.font("", FontWeight.BOLD, 20));
        welcomeBox.setAlignment(Pos.TOP_CENTER);
        welcomeBox.setPadding(new Insets(20));

        // User type selection (dropdown)
        Label userTypeLabel = createLabel("You are:");
        userTypeCombo.getItems().addAll("Undergraduate", "Graduate");
        userTypeCombo.setValue("...");
        userTypeCombo.setStyle("-fx-font-size: 20px; -fx-font-family: 'Times New Roman'");

        Label IDLabel = createLabel("ID");

        Button loginBtn = new Button("Login");
        btnBox.getChildren().add(loginBtn);
        btnBox.setAlignment(Pos.BASELINE_CENTER);
        btnBox.setPadding(new Insets(20));


        welcomeBox.getChildren().add(welcomeLabel);
        loginPane.add(userTypeLabel, 0, 3);
        loginPane.add(userTypeCombo, 1, 3);
        loginPane.add(IDLabel, 0, 4);
        loginPane.add(IDField, 0, 5);

        loginBtn.setOnAction(e -> handleLogin(loginStage));

        all.getChildren().addAll(welcomeBox, loginPane, btnBox);
        all.setPadding(new Insets(20));
        Scene scene = new Scene(all, 600, 350);
        loginStage.setTitle("Student Login Page");
        loginStage.setScene(scene);
        loginStage.show();
    }

    void handleLogin(Stage loginStage) {
        String userType = userTypeCombo.getValue();
        String ID = IDField.getText();

        boolean logged = false;
        Student student = null;

        if (userType.equals("Undergraduate")) {
            student = findUndergrad(ID);
            logged = student != null;

            if (!logged) {
                notFoundError();
            }
        }
        else {
            student = findGrad(ID);
            logged = student != null;
            if (!logged) {
                notFoundError();
            }
        }

        if (logged) {
            openProfile(student);
            loginStage.close();
        }
    }

    Undergraduate findUndergrad(String ID) {
        for (int i = 0; i < undergradCount; i++) {
            if ((undergrad[i].getID() + "").equals(ID)) {
                return undergrad[i];
            }
        }
        return null;
    }

    Graduate findGrad(String ID) {
        for (int i = 0; i < gradCount; i++) {
            if ((grad[i].getID() + "").equals(ID)) {
                return grad[i];
            }
        }
        return null;
    }

    void openProfile(Student student) {
        Stage profileStage = new Stage();

        if (student instanceof Undergraduate) {
            new UndergraduateProfile().start(profileStage, (Undergraduate) student);
            profileStage.show();
        }
        else if (student instanceof Graduate) {
            new GraduateProfile().start(profileStage, (Graduate) student);
            profileStage.show();
        }
    }

    void notFoundError() {
        Label notFoundLabel = createLabel("Matches not found, check your ID!");
        loginPane.add(notFoundLabel, 0, 6);
    }

    public Label createLabel(String name) {
        Label label = new Label(name);
        label.setFont(Font.font("Times New Roman", 20));
        System.out.println();
        return label;
    }
}
