package StudentManagement;

public class Graduate extends Student implements TeachingAssistant {

    Graduate() {}

    public Graduate (String name, String nationality, int ID, int age, double GPA,
                          int gradYear, boolean hasScholarship, String major, boolean hasMinor, String minor, int coursesTaken, int totalCredits) {
        super(name, nationality, ID, age, GPA,
                gradYear, hasScholarship, major, hasMinor, minor, coursesTaken, totalCredits); //null if no minor
    }

    public String addMinor(String minor) {
        if (!minor.isEmpty()) {
        if (!hasMinor) {
            this.minor = minor;
            hasMinor = true;
            return "A minor has been added!";
        } else
            return "Already minoring in: " + this.minor;
    }
        else
            return "Invalid input";
    }

    public String registerCourse() { return "Registered successfully!"; }

    public String changeMajor(String major) {
        if (!major.isEmpty()) {
            this.major = major;
            return "The major was changed.";
        }
        else
            return "Invalid input";
    }

    public String calculateGPA(String percentageStr, String creditsStr) {
        double percentage;
        double credits;

        try {
            percentage = Double.parseDouble(percentageStr);
        } catch (Exception e) {
            return "Error: You did not pass a numeric value, try again!";
        }

        try {
            credits = Integer.parseInt(creditsStr);
        } catch (Exception e) {
            return  "Error: the value must be an integer, try again!";
        }

        if ((percentage >= 0 && percentage <= 100) && (credits > 0 && credits < 8)) {
            double gradePoint = to4PointScale(percentage);
            double GPA = (getGPA() * getTotalCredits() + gradePoint * credits) / (getTotalCredits() + credits);
            return String.format("%.3f", GPA);
        }
        else
            return  "Error: percentage must be in the range 0-100, credits must be greater than 0.";
    }

    public String assist(){ return "You've become a teaching assistant!"; }
}
