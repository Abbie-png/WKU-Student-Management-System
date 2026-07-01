package UI;

import StudentManagement.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class UndergraduateProfile extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Undergraduate student;
    Stage profileStage;


    public void start(Stage profileStage, Undergraduate student) {
        this.profileStage = profileStage;
        this.student = student;

        showProfile();
    }

    @Override
    public void start(Stage profileStage) {
        this.profileStage = profileStage;
        showProfile();
    }

    public void showProfile() {
        String name = "Name:";
        String nationality = "Nationality:";
        String ID = "ID:";
        String age = "Age:";
        String GPA = "GPA:";
        String gradYear = "Year of";
        String scholarship = "Scholarship:";
        String major = "Major:";
        String volunteerH = "Volunteer hours:";
        String minor = "Minor:";
        String coursesTaken = "Completed courses:";
        String totalCredits = "Completed credits:";
        String predictGPA = "Predict GPA:";

        TextField addMinorTF = new TextField();
        TextField changeMajorTF = new TextField();
        TextField predictGPATF = new TextField();
        predictGPATF.setPrefWidth(200);
        predictGPATF.setPromptText("Enter your percentage (0-100)");

        GridPane pane = new GridPane(10, 10);

        HBox logoutBox = new HBox();
        logoutBox.setAlignment(Pos.BOTTOM_CENTER);
        logoutBox.setPadding(new Insets(20));

        VBox all = new VBox();
        all.setPadding(new Insets(20));
        all.getChildren().addAll(pane, logoutBox);

        //Labels for all properties (9)
        Label nameS = createLabel(name);
        pane.add(nameS, 0, 0);
        Label nameL = createLabel(student.getName());
        pane.add(nameL, 1, 0);

        Label IDS = createLabel(ID);
        pane.add(IDS, 0, 1);
        Label IDL = createLabel(student.getID());
        pane.add(IDL, 1, 1);

        Label GPAS = createLabel(GPA);
        pane.add(GPAS, 0, 2);
        Label GPAL = createLabel(student.getGPA());
        pane.add(GPAL, 1, 2);

        Label gradYearS = createLabel(gradYear);
        pane.add(gradYearS, 0, 3);
        Label GradYearL = createLabel(student.getGradYear());
        pane.add(GradYearL, 1, 3);

        Label majorS = createLabel(major);
        pane.add(majorS, 0, 4);
        Label majorL = createLabel(student.major);
        pane.add(majorL, 1, 4);

        Label coursesTakenS = createLabel(coursesTaken);
        pane.add(coursesTakenS, 0, 5);
        Label coursesTakenL = createLabel(student.getCoursesTaken());
        pane.add(coursesTakenL, 1, 5);

        Label totalCreditsS = createLabel(totalCredits);
        pane.add(totalCreditsS, 0, 6);
        Label totalCreditsL = createLabel(student.getTotalCredits());
        pane.add(totalCreditsL, 1, 6);

        Label volunteerHS = createLabel(volunteerH);
        pane.add(volunteerHS, 0, 7);
        Label volunteerHL = createLabel(student.volunteerH);
        pane.add(volunteerHL, 1, 7);

        Label ageS = createLabel(age);
        pane.add(ageS, 0, 8);
        Label ageL = createLabel(student.getAge());
        pane.add(ageL, 1, 8);

        Label scholarshipS = createLabel(scholarship);
        pane.add(scholarshipS, 0, 9);
        if (student.getHasScholarship()) {
            Label scholarshipL = createLabel("Yes");
            pane.add(scholarshipL, 1, 9);
        }
        else {
            Label scholarshipL = createLabel("No");
            pane.add(scholarshipL, 1, 9);
        }

        Label nationalityS = createLabel(nationality);
        pane.add(nationalityS, 0, 10);
        Label nationalityL = createLabel(student.getNationality());
        pane.add(nationalityL, 1, 10);


        //methods
        Label addMinorS = createLabel("Add minor:");
        Label addMinorOutput = createLabel("");
        pane.add(addMinorS, 0, 12);
        Button addMinorB = new Button("Add");
        pane.add(addMinorTF, 1, 12);
        pane.add(addMinorB, 2, 12);

        Label minorS = createLabel("Minor:");
        Label minorL = createLabel("");
        if (student.hasMinor) {
            pane.add(minorS, 0, 11);
            pane.add(minorL, 1, 11);
        }

        addMinorB.setOnAction(e -> {
            String result = student.addMinor((addMinorTF.getText()));
            if (result.equals("Invalid input") || result.equals("Already minoring in: " + student.minor)) {
                addMinorOutput.setText(result);
                pane.add(addMinorOutput, 3, 12);
            } else {
                addMinorOutput.setText("A minor has been added!");
                pane.add(addMinorOutput, 3, 12);

                minorL.setText(student.minor);
                pane.add(minorL, 1, 11);
                pane.add(minorS, 0, 11);
            }
        } );

        Label courseReg = createLabel("Course Registration:");
        pane.add(courseReg, 0, 13);
        Label courseRegOutput = createLabel("");
        Button regCourseB = new Button("Register");
        pane.add(regCourseB, 1, 13);
        pane.add(courseRegOutput, 3, 13);

        regCourseB.setOnAction(e -> {
            courseRegOutput.setText(this.student.registerCourse());
        });

        Label changeMajorS = createLabel("Change Major: ");
        Label changeMajorOutput = createLabel("");
        pane.add(changeMajorS, 0, 14);
        Button changeMajorB = new Button("Change");
        pane.add(changeMajorTF, 1, 14);
        pane.add(changeMajorB, 2, 14);

        changeMajorB.setOnAction(e -> {
            changeMajorOutput.setText(student.changeMajor(changeMajorTF.getText()));
            pane.add(changeMajorOutput, 3, 14);
            majorL.setText(student.major);
        } );

        Label joinActivityS = createLabel("Activity");
        pane.add(joinActivityS, 0, 15);
        Button joinB = new Button("Join");
        pane.add(joinB, 1, 15);
        Label joinOutput = createLabel("");

        joinB.setOnAction(e -> {
            joinOutput.setText(student.joinActivity());
            pane.add(joinOutput, 3, 15);
        });

        Label peerTutorS = createLabel("Apply for peer tutoring");
        pane.add(peerTutorS, 0, 16);
        Button applyB = new Button("Apply");
        pane.add(applyB, 1, 16);
        Label applyOutput = createLabel("");

        applyB.setOnAction(e -> {
            applyOutput.setText(student.peerTutoring());
            pane.add(applyOutput, 3, 16);
        });

        Label predictGPAS = createLabel(predictGPA);
        pane.add(predictGPAS, 0, 17);
        pane.add(predictGPATF, 1, 17);
        Button predictGPAB = new Button("Calculate");
        pane.add(predictGPAB, 2, 17);
        Label predictGPAOutput = new Label("");

        predictGPAB.setOnAction(e -> {
            predictGPAOutput.setText(student.calculateGPA(predictGPATF.getText()));
            pane.add(predictGPAOutput, 3, 17);
        });

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> {
            profileStage.close();
            new LoginPage().start(new Stage());
        });
        logoutBox.getChildren().add(logoutBtn);

        Scene scene = new Scene(all,800, 700);
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