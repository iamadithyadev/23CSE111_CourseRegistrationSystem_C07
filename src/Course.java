public class Course {
    private String courseID;
    private String courseName;
    private int credits;
    private int seatsAvailable;
    private Instructor instructor;

    public Course(String courseID, String courseName, int credits, int seatsAvailable) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
        this.seatsAvailable = seatsAvailable;
        this.instructor = null;
    }

    public String getCourseID() { return courseID; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }
    public int getSeatsAvailable() { return seatsAvailable; }
    public Instructor getInstructor() { return instructor; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setCredits(int credits) { this.credits = credits; }
    public void setSeatsAvailable(int seatsAvailable) { this.seatsAvailable = seatsAvailable; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }

    public boolean checkAvailability() {
        return seatsAvailable > 0;
    }

    public void reserveSeats(int change) {
        this.seatsAvailable += change;
        System.out.println("Seats updated for course " + courseID
                + ". Seats now available: " + seatsAvailable);
    }

    public void updateCourse() {
        System.out.println("Course " + courseID + " updated: Name='"
                + courseName + "', Credits=" + credits
                + ", Seats=" + seatsAvailable);
    }

    public String viewCourseDetails() {
        String instructorName = (instructor != null) ? instructor.getName() : "Not Assigned";
        return "Course{ID='" + courseID + "', Name='" + courseName
                + "', Credits=" + credits + ", Seats=" + seatsAvailable
                + ", Instructor='" + instructorName + "'}";
    }

    @Override
    public String toString() {
        return viewCourseDetails();
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     