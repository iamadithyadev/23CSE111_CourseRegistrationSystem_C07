import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {
    private String instructorID;
    private String name;

    public Instructor(String instructorID, String name, String username, String password) {
        super(username, password);
        this.instructorID = instructorID;
        this.name = name;
    }

    public String getInstructorID() { return instructorID; }
    public String getName() { return name; }

    public Course[] viewAssignedCourses(CourseCatalog catalog) {
        List<Course> assigned = new ArrayList<>();
        for (Course course : catalog.getCourseList()) {
            if (course.getInstructor() != null
                    && course.getInstructor().getInstructorID().equals(this.instructorID)) {
                assigned.add(course);
            }
        }
        return assigned.toArray(new Course[0]);
    }

    @Override
    public String toString() {
        return "Instructor{ID='" + instructorID + "', Name='" + name + "'}";
    }
}
