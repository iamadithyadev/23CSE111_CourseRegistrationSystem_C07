import java.util.ArrayList;
import java.util.List;

public class CourseCatalog {
	private List<Course> courseList;
    public CourseCatalog() {
        this.courseList = new ArrayList<>();
    }
    public List<Course> getCourseList() { return courseList; }
    public Course[] displayCourses() {
        if (courseList.isEmpty()) {
            System.out.println("No courses available in the catalog.");
        } else {
            System.out.println("=== Available Courses ===");
            for (Course c : courseList) {
                System.out.println(c.viewCourseDetails());
            }
        }
        return courseList.toArray(new Course[0]);
    }
    public Course searchCourse(String courseID) {
        for (Course c : courseList) {
            if (c.getCourseID().equals(courseID)) return c;
        }
        System.out.println("Course with ID '" + courseID + "' not found.");
        return null;
    }
    public void addCourse(Course course) { courseList.add(course); }
    public boolean removeCourse(String courseID) {
        return courseList.removeIf(c -> c.getCourseID().equals(courseID));
    }
}
