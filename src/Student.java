import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String studentID;
    private String name;
    private String email;
    private List<Registration> registrations;

    private static int regCounter = 1;

    public Student(String studentID, String name, String email, String username, String password) {
        super(username, password);
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.registrations = new ArrayList<>();
    }

    public String getStudentID() { return studentID; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public List<Registration> getRegistrations() { return registrations; }

    public boolean registerCourse(String courseID, CourseCatalog catalog) {
        Course course = catalog.searchCourse(courseID);
        if (course == null) {
            System.out.println("[FAILURE] Course '" + courseID + "' does not exist.");
            return false;
        }
 
        for (Registration reg : registrations) {
            if (reg.getCourseID().equals(courseID) && "ACTIVE".equals(reg.getStatus())) {
                System.out.println("[FAILURE] Already registered for course: " + courseID);
                return false;
            }
        }

        boolean available = course.checkAvailability();
        if (available) {
            String regID = "REG" + String.format("%03d", regCounter++);
            Registration reg = new Registration(regID, this.studentID, courseID);
            boolean registered = reg.register(this, course);
            if (registered) {
                course.reserveSeats(-1);
                registrations.add(reg);
                System.out.println("[SUCCESS] " + name + " registered for course: "
                        + course.getCourseName());
                return true;
            }
        }

        System.out.println("[FAILURE] No seats available for course: " + course.getCourseName());
        return false;
    }

    public boolean dropCourse(String courseID, CourseCatalog catalog) {
        for (Registration reg : registrations) {
            if (reg.getCourseID().equals(courseID) && "ACTIVE".equals(reg.getStatus())) {
                boolean cancelled = reg.cancelRegistration();
                if (cancelled) {
                    Course course = catalog.searchCourse(courseID);
                    if (course != null) {
                        course.reserveSeats(+1);
                    }
                    System.out.println("[Drop Successful] " + name + " dropped course: " + courseID);
                    return true;
                }
            }
        }
        System.out.println("[FAILURE] No active registration found for course: " + courseID);
        return false;
    }

    public Course[] viewCourses(CourseCatalog catalog) {
        List<Course> enrolled = new ArrayList<>();
        System.out.println("=== Courses registered by " + name + " ===");
        for (Registration reg : registrations) {
            if ("ACTIVE".equals(reg.getStatus())) {
                Course c = catalog.searchCourse(reg.getCourseID());
                if (c != null) {
                    enrolled.add(c);
                    System.out.println(c.viewCourseDetails());
                }
            }
        }
        if (enrolled.isEmpty()) {
            System.out.println("No active course registrations.");
        }
        return enrolled.toArray(new Course[0]);
    }

    @Override
    public String toString() {
        return "Student{ID='" + studentID + "', Name='" + name + "', Email='" + email + "'}";
    }
}
