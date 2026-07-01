package UI;

import StudentManagement.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GraduateProfile extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Graduate student;
    Stage profileStage;

    public void start(Stage profileStage, Graduate student) {
        this.profileStage = profileStage;
        this.student = student;
        showProfile();
    }

    @Override
    public void start(Stage profileStage) {
        this.profileStage = profileStage;
    }

    public void showProfile() {
        GridPane pane = new GridPane(10, 10);

        HBox logoutBox = new HBox();
        logoutBox.setAlignment(Pos.BOTTOM_CENTER);
        logoutBox.setPadding(new Insets(20));

        VBox all = new VBox();
        all.setPadding(new Insets(20));
        all.getChildren().addAll(pane, logoutBox);

        TextField addMinorTF = new TextField();
        TextField changeMajorTF = new TextField();
        TextField percentageTF = new TextField();
        percentageTF.setPrefWidth(200);
        percentageTF.setPromptText("Enter your percentage (0-100)");
        TextField creditsTF = new TextField();
        creditsTF.setPrefWidth(200);
        creditsTF.setPromptText("Enter the course credits (0-7)");

        Label nameS = createLabel("Name:");
        pane.add(nameS, 0, 0);
        Label nameL = createLabel(student.getName());
        pane.add(nameL, 1, 0);

        Label IDS = createLabel("ID:");
        pane.add(IDS, 0, 1);
        Label IDL = createLabel(student.getID());
        pane.add(IDL, 1, 1);

        Label GPAS = createLabel("GPA:");
        pane.add(GPAS, 0, 2);
        Label GPAL = createLabel(student.getGPA());
        pane.add(GPAL, 1, 2);

        Label gradYearS = createLabel("Year of");
        pane.add(gradYearS, 0, 3);
        Label GradYearL = createLabel(student.getGradYear());
        pane.add(GradYearL, 1, 3);

        Label majorS = createLabel("Major:");
        pane.add(majorS, 0, 4);
        Label majorL = createLabel(student.major);
        pane.add(majorL, 1, 4);

        Label coursesTakenS = createLabel("Completed Courses:");
        pane.add(coursesTakenS, 0, 5);
        Label coursesTakenL = createLabel(student.getCoursesTaken());
        pane.add(coursesTakenL, 1, 5);

        Label ageS = createLabel("Age:");
        pane.add(ageS, 0, 7);
        Label ageL = createLabel(student.getAge());
        pane.add(ageL, 1, 7);

        Label scholarshipS = createLabel("Scholarship:");
        pane.add(scholarshipS, 0, 8);
        if (student.getHasScholarship()) {
            Label scholarshipL = createLabel("Yes");
            pane.add(scholarshipL, 1, 8);
        }
        else {
            Label scholarshipL = createLabel("No");
            pane.add(scholarshipL, 1, 8);
        }

        Label nationalityS = createLabel("Nationality:");
        pane.add(nationalityS, 0, 9);
        Label nationalityL = createLabel(student.getNationality());
        pane.add(nationalityL, 1, 9);


        Label minorS = createLabel("Minor:");
        Label minorL = createLabel("");
        if (student.hasMinor) {
            pane.add(minorS, 0, 10);
            pane.add(minorL, 1, 10);
        }


        //methods
        Label addMinorS = createLabel("Add minor:");
        Label addMinorOutput = createLabel("");
        pane.add(addMinorS, 0, 11);
        Button addMinorB = new Button("Add");
        pane.add(addMinorTF, 1, 11);
        pane.add(addMinorB, 2, 11);

        addMinorB.setOnAction(e -> {
            String result = student.addMinor((addMinorTF.getText()));
            if (result.equals("Invalid input") || result.equals("Already minoring in: " + student.minor)) {
                addMinorOutput.setText(result);
                pane.add(addMinorOutput, 3, 11);
            } else {
                addMinorOutput.setText("A minor has been added!");
                pane.add(addMinorOutput, 3, 11);

                minorL.setText(student.minor);
                if (!pane.getChildren().contains(minorS)) {
                    pane.add(minorS, 0, 10);
                    pane.add(minorL, 1, 10);
                }
            }
        } );


        Label courseReg = createLabel("Course Registration:");
        pane.add(courseReg, 0, 12);
        Label courseRegOutput = createLabel("");
        Button regCourseB = new Button("Register");
        pane.add(regCourseB, 1, 12);
        pane.add(courseRegOutput, 3, 12);

        regCourseB.setOnAction(e -> {
            courseRegOutput.setText(student.registerCourse());
        });

        Label changeMajorS = createLabel("Change Major:");
        Label changeMajorOutput = createLabel("");
        pane.add(changeMajorS, 0, 13);
        Button changeMajorB = new Button("Change");
        pane.add(changeMajorTF, 1, 13);
        pane.add(changeMajorB, 2, 13);

        changeMajorB.setOnAction(e -> {
            changeMajorOutput.setText(student.changeMajor(changeMajorTF.getText()));
            pane.add(changeMajorOutput, 3, 13);
            majorL.setText(student.major);
            pane.add(majorL, 1, 4);
        } );

        Label becomeTAS = createLabel("Apply for a teaching assistant role");
        pane.add(becomeTAS, 0, 15);
        Button joinB = new Button("Apply");
        pane.add(joinB, 1, 15);
        Label joinOutput = createLabel("");

        joinB.setOnAction(e -> {
            joinOutput.setText(student.assist());
            pane.add(joinOutput, 3, 15);
        });


        Label predictGPAS = createLabel("Predict GPA");
        pane.add(predictGPAS, 0, 17);
        pane.add(percentageTF, 1, 17);
        pane.add(creditsTF, 1, 18);
        Button predictGPAB = new Button("Calculate");
        pane.add(predictGPAB, 2, 17);
        Label predictGPAOutput = new Label("");

        predictGPAB.setOnAction(e -> {
            predictGPAOutput.setText(student.calculateGPA(percentageTF.getText(), creditsTF.getText()));
            pane.add(predictGPAOutput, 3, 17);
        });

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> {
            profileStage.close();
            new LoginPage().start(new Stage());
        });
        logoutBox.getChildren().add(logoutBtn);


        Scene scene = new Scene(all,900, 700);
        profileStage.setScene(scene);
        profileStage.setTitle(student.getName() + "'s profile");
        profileStage.show();
    }

    public Label createLabel(String name) {
        Label label = new Label(name);
        label.setFont(Font.font("Times New Roman", 20));
        System.out.println();
        return label;
    }

    public Label createLabel(int num) {
        String numS = "" + num;
        Label label = new Label(numS);
        label.setFont(Font.font("Times New Roman", 20));
        System.out.println();
        return label;
    }

    public Label createLabel(double num) {
        String numS = "" + num;
        Label label = new Label(numS);
        label.setFont(Font.font("Times New Roman", 20));
        System.out.println();
        return label;
    }
}
