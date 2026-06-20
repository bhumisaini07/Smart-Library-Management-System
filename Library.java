import java.util.ArrayList;
import java.io.*;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<User> users;

    private final String FILE_NAME = "books.txt";

    // Constructor
    public Library() {

        books = new ArrayList<>();
        users = new ArrayList<>();

        loadBooks();
        loadUsers();
    }

    // ================= BOOK METHODS =================

    public void addBook(Book book) {

        books.add(book);

        saveBooks();

        System.out.println("Book Added Successfully!");
    }

    public void viewBooks() {

        if (books.isEmpty()) {

            System.out.println("No Books Available!");
            return;
        }

        for (Book b : books) {

            System.out.println(
                    "ID: " + b.getId()
                            + " | Title: " + b.getTitle()
                            + " | Author: " + b.getAuthor()
                            + " | Available: " + b.isAvailable()
            );
        }
    }

    public void searchBook(int id) {

        for (Book b : books) {

            if (b.getId() == id) {

                System.out.println("\nBook Found!");
                System.out.println("ID: " + b.getId());
                System.out.println("Title: " + b.getTitle());
                System.out.println("Author: " + b.getAuthor());
                System.out.println("Available: " + b.isAvailable());

                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    public void deleteBook(int id) {

        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getId() == id) {

                books.remove(i);

                saveBooks();

                System.out.println("Book Deleted Successfully!");

                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    public void issueBook(int id) {

        for (Book b : books) {

            if (b.getId() == id) {

                if (b.isAvailable()) {

                    b.setAvailable(false);

                    saveBooks();

                    System.out.println("Book Issued Successfully!");

                } else {

                    System.out.println("Book Already Issued!");
                }

                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    public void returnBook(int id) {

        for (Book b : books) {

            if (b.getId() == id) {

                if (!b.isAvailable()) {

                    b.setAvailable(true);

                    saveBooks();

                    System.out.println("Book Returned Successfully!");

                } else {

                    System.out.println("This Book Was Not Issued!");
                }

                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    // ================= USER METHODS =================

    public void registerUser(User user) {

        users.add(user);

        saveUsers();

        System.out.println("User Registered Successfully!");
    }

    public boolean loginUser(String name, String password) {

        for (User u : users) {

            if (u.getName().equals(name)
                    && u.getPassword().equals(password)) {

                return true;
            }
        }

        return false;
    }

    // ================= BOOK FILE HANDLING =================

    private void saveBooks() {

        try {

            PrintWriter writer =
                    new PrintWriter(new FileWriter(FILE_NAME));

            for (Book b : books) {

                writer.println(
                        b.getId() + ","
                                + b.getTitle() + ","
                                + b.getAuthor() + ","
                                + b.isAvailable()
                );
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error Saving Books!");
        }
    }

    private void loadBooks() {

        try {

            File file = new File(FILE_NAME);

            if (!file.exists()) {
                return;
            }

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(FILE_NAME));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String title = data[1];
                String author = data[2];
                boolean available =
                        Boolean.parseBoolean(data[3]);

                books.add(
                        new Book(
                                id,
                                title,
                                author,
                                available
                        )
                );
            }

            br.close();

        } catch (Exception e) {

            System.out.println("Error Loading Books!");
        }
    }

    // ================= USER FILE HANDLING =================

    private void saveUsers() {

        try {

            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter("users.txt"));

            for (User u : users) {

                writer.println(
                        u.getUserId() + ","
                                + u.getName() + ","
                                + u.getPassword()
                );
            }

            writer.close();

        } catch (Exception e) {

            System.out.println("Error Saving Users!");
        }
    }

    private void loadUsers() {

        try {

            File file = new File("users.txt");

            if (!file.exists()) {
                return;
            }

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                users.add(
                        new User(
                                Integer.parseInt(data[0]),
                                data[1],
                                data[2]
                        )
                );
            }

            br.close();

        } catch (Exception e) {

            System.out.println("Error Loading Users!");
        }
    }
}