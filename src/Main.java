import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static CourseCatalog catalog = new CourseCatalog();

    static Admin admin = new Admin("admin01", "Admin User", "admin01", "adminpass");
    static Instructor instructor1 = new Instructor("inst01", "Pramod", "iamPR", "pramod123");
    static Instructor instructor2 = new Instructor("inst02", "Sreedeep", "iamSR", "sree123");
    static Student student1 = new Student("AM.SC.U4CSE25261", "Adithyadev",
            "am.sc.u4cse25261@am.students.amrita.edu", "iamAD", "AD01");
    static Student student2 = new Student("AM.SC.U4CSE25266", "Abhishek R Pillai",
            "am.sc.u4cse25266@am.students.amrita.edu", "abhishek266", "AB01");

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("   Welcome to Course Registration System    ");
        System.out.println("============================================");

        boolean running = true;
        while (running) {
            System.out.println("\n--- LOGIN ---");
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            if (admin.login(username, password)) {
                System.out.println("\n[Login Successful] Welcome Admin!");
                adminMenu();
            } else if (student1.login(username, password)) {
                System.out.println("\n[Login Successful] Welcome " + student1.getName() + "!");
                studentMenu(student1);
            } else if (student2.login(username, password)) {
                System.out.println("\n[Login Successful] Welcome " + student2.getName() + "!");
                studentMenu(student2);
            } else if (instructor1.login(username, password)) {
                System.out.println("\n[Login Successful] Welcome " + instructor1.getName() + "!");
                instructorMenu(instructor1);
            } else if (instructor2.login(username, password)) {
                System.out.println("\n[Login Successful] Welcome " + instructor2.getName() + "!");
                instructorMenu(instructor2);
            } else {
                System.out.println("[Login Failed] Invalid username or password.");
            }

            System.out.print("\nBack to Login? (yes/no): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                running = false;
                System.out.println("Exiting system. Goodbye!");
            }
        }
    }

   
    static void studentMenu(Student student) {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== STUDENT MENU ===");
            System.out.println("1. View All Courses");
            System.out.println("2. Search Course");
            System.out.println("3. Register for Course");
            System.out.println("4. Drop Course");
            System.out.println("5. View My Registered Courses");
            System.out.println("6. Logout");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    catalog.displayCourses();
                    break;

                case "2":
                    System.out.print("Enter Course ID to search: ");
                    Course found = catalog.searchCourse(scanner.nextLine());
                    if (found != null) {
                        System.out.println("Found: " + found.viewCourseDetails());
                    }
                    break;

                case "3":
                    System.out.print("Enter Course ID to register: ");
                    student.registerCourse(scanner.nextLine(), catalog);
                    break;

                case "4":
                    System.out.print("Enter Course ID to drop: ");
                    student.dropCourse(scanner.nextLine(), catalog);
                    break;

                case "5":
                    student.viewCourses(catalog);
                    break;

                case "6":
                    back = true;
                    System.out.println("Logged out.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    
    static void adminMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. View All Courses");
            System.out.println("2. Add Course");
            System.out.println("3. Remove Course");
            System.out.println("4. Update Course");
            System.out.println("5. Assign Instructor");
            System.out.println("6. Logout");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    catalog.displayCourses();
                    break;

                case "2":
                    System.out.print("Enter Course ID: ");
                    String cID = scanner.nextLine();
                    System.out.print("Enter Course Name: ");
                    String cName = scanner.nextLine();
                    System.out.print("Enter Credits: ");
                    int credits = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Seats Available: ");
                    int seats = Integer.parseInt(scanner.nextLine());
                    admin.addCourse(new Course(cID, cName, credits, seats), catalog);
                    break;

                case "3":
                    System.out.print("Enter Course ID to remove: ");
                    admin.removeCourse(scanner.nextLine(), catalog);
                    break;

                case "4":
                    System.out.print("Enter Course ID to update: ");
                    Course update = catalog.searchCourse(scanner.nextLine());
                    if (update != null) {
                        System.out.print("Enter new Course Name: ");
                        update.setCourseName(scanner.nextLine());
                        System.out.print("Enter new Credits: ");
                        update.setCredits(Integer.parseInt(scanner.nextLine()));
                        System.out.print("Enter new Seats: ");
                        update.setSeatsAvailable(Integer.parseInt(scanner.nextLine()));
                        admin.updateCourse(update);
                    }
                    break;

                case "5":
                    System.out.print("Enter Course ID to assign instructor: ");
                    Course aCourse = catalog.searchCourse(scanner.nextLine());
                    if (aCourse != null) {
                        System.out.println("1. Pramod");
                        System.out.println("2. Sreedeep");
                        System.out.print("Choose Instructor: ");
                        String iChoice = scanner.nextLine();
                        if (iChoice.equals("1")) {
                            admin.assignInstructor(aCourse, instructor1);
                        } else if (iChoice.equals("2")) {
                            admin.assignInstructor(aCourse, instructor2);
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case "6":
                    back = true;
                    System.out.println("Logged out.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

   
    static void instructorMenu(Instructor instructor) {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== INSTRUCTOR MENU ===");
            System.out.println("1. View Assigned Courses");
            System.out.println("2. Logout");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Course[] assigned = instructor.viewAssignedCourses(catalog);
                    System.out.println("\n" + instructor.getName() + "'s Assigned Courses:");
                    if (assigned.length == 0) {
                        System.out.println("No courses assigned yet.");
                    } else {
                        for (Course c : assigned) {
                            System.out.println(c.viewCourseDetails());
                        }
                    }
                    break;

                case "2":
                    back = true;
                    System.out.println("Logged out.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
