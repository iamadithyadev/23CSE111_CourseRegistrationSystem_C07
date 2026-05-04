import java.util.Date;

public class Registration {
    private String registrationID;
    private String studentID;
    private String courseID;
    private Date date;
    private String status;

    public Registration(String registrationID, String studentID, String courseID) {
        this.registrationID = registrationID;
        this.studentID = studentID;
        this.courseID = courseID;
        this.date = new Date();
        this.status = "ACTIVE";
    }

    public String getRegistrationID() { return registrationID; }
    public String getStudentID() { return studentID; }
    public String getCourseID() { return courseID; }
    public Date getDate() { return date; }
    public String getStatus() { return status; }

    public boolean register(Student student, Course course) {
        if (student == null || course == null) return false;
        this.studentID = student.getStudentID();
        this.courseID = course.getCourseID();
        this.date = new Date();
        this.status = "ACTIVE";
        System.out.println("Registration entry created: " + registrationID
                + " for Student: " + studentID + " | Course: " + courseID);
        return true;
    }

    public boolean cancelRegistration() {
        if ("ACTIVE".equals(this.status)) {
            this.status = "CANCELLED";
            System.out.println("Registration " + registrationID + " cancelled.");
            return true;
        }
        System.out.println("Registration " + registrationID + " is already cancelled.");
        return false;
    }

    @Override
    public String toString() {
        return "Registration{ID='" + registrationID + "', StudentID='" + studentID
                + "', CourseID='" + courseID + "', Status='" + status + "'}";
    }
}
