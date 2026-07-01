package StudentManagement;

public class Undergraduate extends Student implements PeerTutor, Activities {
    public static final String TYPE = "Undergraduate"; //same for graduate students

    public int volunteerH;

    public Undergraduate () {}

    public Undergraduate (String name, String nationality, int ID, int age, double GPA,
                          int gradYear, boolean hasScholarship, String major,
                          int volunteerH, boolean hasMinor, String minor, int coursesTaken, int totalCredits)
    {
        super(name, nationality, ID, age, GPA,
        gradYear, hasScholarship, major, hasMinor, minor, coursesTaken, totalCredits); //null if no minor

        this.volunteerH = volunteerH;
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

    public String registerCourse() {
        return "Registered successfully!";
    }

    public String changeMajor(String major) {
        if (!major.isEmpty()) {
            this.major = major;
            return "The major was changed.";
        }
        else
            return "Invalid input";
    }

    public String calculateGPA(String percentageStr) {
        double percentage;

        try {
            percentage = Double.parseDouble(percentageStr);
        } catch (Exception e) {
            return "Error: You did not pass a numeric value, try again!";
        }

        if (percentage <= 100 && percentage >= 0) {

            //converting percentage (0-100) to 4 point scale
            double gradePoint = to4PointScale(percentage);

            double GPA = ((getGPA() * getCoursesTaken()) + gradePoint) / (getCoursesTaken() + 1);

            return String.format("%.3f", (GPA));
        }
        else return "Invalid input: the value must be between 0 and 100!";
    }

    public String peerTutoring() {
        return "You've become a peer tutor!";
    }

    public String joinActivity() {
        return "You've joined an activity!";
    }

}
