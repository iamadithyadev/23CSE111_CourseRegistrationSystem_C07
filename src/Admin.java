public class Admin extends User {
    private String adminID;
    private String name;

    public Admin(String adminID, String name, String username, String password) {
        super(username, password);
        this.adminID = adminID;
        this.name = name;
    }

    public String getAdminID() { return adminID; }
    public String getName() { return name; }

    public void addCourse(Course course, CourseCatalog catalog) {
        catalog.addCourse(course);
        System.out.println("[Admin] Course added: " + course.viewCourseDetails());
    }

    public void removeCourse(String courseID, CourseCatalog catalog) {
        boolean removed = catalog.removeCourse(courseID);
        if (removed) {
            System.out.println("[Admin] Course removed: " + courseID);
        } else {
            System.out.println("[Admin] Course not found: " + courseID);
        }
    }

    public void updateCourse(Course course) {
        course.updateCourse();
        System.out.println("[Admin] Course updated: " + course.viewCourseDetails());
    }

    public void assignInstructor(Course course, Instructor instructor) {
        course.setInstructor(instructor);
        System.out.println("[Admin] Instructor '" + instructor.getName()
                + "' assigned to course '" + course.getCourseName() + "'.");
    }

    @Override
    public String toString() {
        return "Admin{ID='" + adminID + "', Name='" + name + "'}";
    }
}
