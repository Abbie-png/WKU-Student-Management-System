package StudentManagement;

abstract public class Student {
    private String name;
    private String nationality;
    private int ID;
    private int age;
    private double GPA;
   // private int rank; - move to WKU
    private int gradYear;
    private boolean hasScholarship;
    private int coursesTaken;
    private int totalCredits;

    public String major;
    public boolean hasMinor;
    public String minor;
    //String department; move to departments
    //Course[] semesterCourses;

    // Student's constructors
    Student () {}

    Student (String name, String nationality, int ID, int age, double GPA,
             int gradYear, boolean hasScholarship, String major, boolean hasMinor, String minor, int coursesTaken, int totalCredits) {
        this.name = name;
        this.nationality = nationality;
        this.ID = ID;
        this.age = age;
        this.GPA = GPA;
        this.gradYear = gradYear;
        this.hasScholarship =hasScholarship;
        this.major = major;
        this.hasMinor = hasMinor;
        this.minor = minor;
        this.coursesTaken = coursesTaken;
        this.totalCredits = totalCredits;
    }

    // getters/setters

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}

    public String getNationality() {
        return nationality;
    }

    public int getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getGradYear() {
        return gradYear;
    }

    public boolean getHasScholarship() {
        return hasScholarship;
    }

    public int getCoursesTaken() { return coursesTaken; }

    public int getTotalCredits() { return totalCredits; }

    // methods
    abstract String addMinor(String newM);
    abstract String registerCourse();
    abstract String changeMajor(String major);
    String calculateGPA(String percentageStr) { return ""; } //undergrads
    String calculateGPA(String percentageStr, String creditsStr) { return ""; } //grads

    double to4PointScale(double percentage) {
        if (percentage >= 90) return 4.0;
        else if (percentage >= 80) return 3.0;
        else if (percentage >= 70) return 2.0;
        else if (percentage >= 60) return 1.0;
        else return 0.0;
    }
}
