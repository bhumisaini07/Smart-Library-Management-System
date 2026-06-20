import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();
        Admin admin = new Admin();

        while (true) {

            System.out.println("\n===== SMART LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Register User");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Enter Admin Username: ");
                    String adminUser = sc.nextLine();

                    System.out.print("Enter Admin Password: ");
                    String adminPass = sc.nextLine();

                    if (admin.login(adminUser, adminPass)) {

                        System.out.println("Admin Login Successful!");

                        while (true) {

                            System.out.println("\n===== ADMIN MENU =====");
                            System.out.println("1. Add Book");
                            System.out.println("2. View Books");
                            System.out.println("3. Search Book");
                            System.out.println("4. Delete Book");
                            System.out.println("5. Issue Book");
                            System.out.println("6. Return Book");
                            System.out.println("7. Logout");

                            System.out.print("Enter Choice: ");
                            int adminChoice = sc.nextInt();

                            switch (adminChoice) {

                                case 1:

                                    System.out.print("Enter Book ID: ");
                                    int id = sc.nextInt();

                                    sc.nextLine();

                                    System.out.print("Enter Book Title: ");
                                    String title = sc.nextLine();

                                    System.out.print("Enter Author Name: ");
                                    String author = sc.nextLine();

                                    library.addBook(
                                            new Book(
                                                    id,
                                                    title,
                                                    author
                                            )
                                    );

                                    break;

                                case 2:

                                    library.viewBooks();

                                    break;

                                case 3:

                                    System.out.print("Enter Book ID: ");
                                    int searchId = sc.nextInt();

                                    library.searchBook(searchId);

                                    break;

                                case 4:

                                    System.out.print("Enter Book ID: ");
                                    int deleteId = sc.nextInt();

                                    library.deleteBook(deleteId);

                                    break;

                                case 5:

                                    System.out.print("Enter Book ID: ");
                                    int issueId = sc.nextInt();

                                    library.issueBook(issueId);

                                    break;

                                case 6:

                                    System.out.print("Enter Book ID: ");
                                    int returnId = sc.nextInt();

                                    library.returnBook(returnId);

                                    break;

                                case 7:

                                    System.out.println("Logged Out!");
                                    break;

                                default:

                                    System.out.println("Invalid Choice!");
                            }

                            if (adminChoice == 7) {
                                break;
                            }
                        }

                    } else {

                        System.out.println("Invalid Admin Credentials!");
                    }

                    break;

                case 2:

                    sc.nextLine();

                    System.out.print("Enter Username: ");
                    String username = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String password = sc.nextLine();

                    if (library.loginUser(username, password)) {

                        System.out.println("Login Successful!");

                        while (true) {

                            System.out.println("\n===== USER MENU =====");
                            System.out.println("1. View Books");
                            System.out.println("2. Search Book");
                            System.out.println("3. Logout");

                            System.out.print("Enter Choice: ");
                            int userChoice = sc.nextInt();

                            switch (userChoice) {

                                case 1:

                                    library.viewBooks();

                                    break;

                                case 2:

                                    System.out.print("Enter Book ID: ");
                                    int searchId = sc.nextInt();

                                    library.searchBook(searchId);

                                    break;

                                case 3:

                                    System.out.println("Logged Out!");
                                    break;

                                default:

                                    System.out.println("Invalid Choice!");
                            }

                            if (userChoice == 3) {
                                break;
                            }
                        }

                    } else {

                        System.out.println("Invalid Username or Password!");
                    }

                    break;

                case 3:

                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Password: ");
                    String pass = sc.nextLine();

                    library.registerUser(
                            new User(
                                    userId,
                                    name,
                                    pass
                            )
                    );

                    break;

                case 4:

                    System.out.println("Thank You!");

                    sc.close();

                    System.exit(0);

                    break;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}