public class Main {
    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("         Course Registration System          ");
        System.out.println("============================================\n");

        CourseCatalog catalog = new CourseCatalog();

        // username and password now passed to User via super()
        Admin admin           = new Admin("admin01", "Admin User", "admin01", "adminpass");
        Instructor instructor1 = new Instructor("inst01","Pramod", "iamPR", "pramod123");
        Instructor instructor2 = new Instructor("inst02", "Sreedeep", "iamSR", "sree123");

        Student student1 = new Student("AM.SC.U4CSE25261", "Adithyadev",
                "am.sc.u4cse25261@am.students.amrita.edu", "iamAD", "AD01");
        Student student2 = new Student("AM.SC.U4CSE25266", "Abhishek R Pillai",
                "am.sc.u4cse25266@am.students.amrita.edu", "abhishek26", "AB01");

        // Login
        System.out.println("--- USE CASE: Login ---");
        System.out.println("Student login:    " + student1.login("iamAD", "AD01"));
        System.out.println("Admin login:      " + admin.login("admin01", "adminpass"));
        System.out.println("Instructor login: " + instructor1.login("iamPR", "pramod123"));
        System.out.println("Invalid login:    " + student2.login("wrongUser", "wrongPass"));
        System.out.println();

        // --- Add Courses ---
        System.out.println("--- USE CASE: Admin Adds Courses ---");
        Course oop  = new Course("CS101", "Object Oriented Programming", 4, 3);
        Course dsa  = new Course("CS102", "Data Structures and Algorithms", 4, 1);
        Course dbms = new Course("CS103", "Database Management Systems", 3, 0);
        Course os   = new Course("CS104", "Operating Systems", 3, 5);
        admin.addCourse(oop,  catalog);
        admin.addCourse(dsa,  catalog);
        admin.addCourse(dbms, catalog);
        admin.addCourse(os,   catalog);
        System.out.println();

        //Assign Instructor
        System.out.println("--- USE CASE: Admin Assigns Instructors ---");
        admin.assignInstructor(oop,  instructor1);
        admin.assignInstructor(dsa,  instructor1);
        admin.assignInstructor(dbms, instructor2);
        admin.assignInstructor(os,   instructor2);
        System.out.println();

        //View Courses
        System.out.println("--- USE CASE: View All Courses ---");
        catalog.displayCourses();
        System.out.println();

        // Search Course
        System.out.println("--- USE CASE: Search Course ---");
        Course found = catalog.searchCourse("23CSE111");
        if (found != null) System.out.println("Found: " + found.viewCourseDetails());
        catalog.searchCourse("CS999");
        System.out.println();

        //Register (Seats Available)
        System.out.println("--- USE CASE: Register for Course (Seats Available) ---");
        student1.registerCourse("CS101", catalog);
        System.out.println();

        //Register (Duplicate)
        System.out.println("--- USE CASE: Register Same Course Again (Duplicate Check) ---");
        student1.registerCourse("23CSE111", catalog);
        System.out.println();

        //Register (No Seats)
        System.out.println("--- USE CASE: Register for Course (No Seats) ---");
        student1.registerCourse("23CSE103", catalog);
        System.out.println();

        //Register (Credit Limit)
        System.out.println("--- USE CASE: Register Multiple Courses (Credit Limit Check) ---");
        student1.registerCourse("23CSE102", catalog);
        student1.registerCourse("23CSE104", catalog);
        System.out.println();

        //View Registered Courses
        System.out.println("--- Adithyadev's Registered Courses ---");
        student1.viewCourses(catalog);
        System.out.println();

        // --- Drop Course ---
        System.out.println("--- USE CASE: Drop Course ---");
        student1.dropCourse("23CSE111", catalog);
        System.out.println("Seats in CS101 after drop: " + oop.getSeatsAvailable());
        System.out.println();

        //Drop Not Registered
        System.out.println("--- Drop Course Not Registered ---");
        student1.dropCourse("23CSE103", catalog);
        System.out.println();

        // Instructor Views Assigned Courses
        System.out.println("--- USE CASE: Instructor Views Assigned Courses ---");
        Course[] inst1Courses = instructor1.viewAssignedCourses(catalog);
        System.out.println(instructor1.getName() + "'s courses:");
        for (Course c : inst1Courses) System.out.println("  " + c.viewCourseDetails());
        System.out.println();

        //Update Course
        System.out.println("--- USE CASE: Admin Updates Course ---");
        os.setSeatsAvailable(10);
        os.setCourseName("Operating Systems — Advanced");
        admin.updateCourse(os);
        System.out.println();

        //Remove Course
        System.out.println("--- USE CASE: Admin Removes Course ---");
        admin.removeCourse("23CSE103", catalog);
        catalog.displayCourses();
        System.out.println();

        System.out.println("============================================");
        System.out.println("       All Use Cases Demonstrated           ");
        System.out.println("============================================");
    }
}
