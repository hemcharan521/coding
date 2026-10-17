import java.util.*;

class Book {
    // Access control: private fields
    private String title;
    private String author;
    private double price;
    private boolean available;

    // Constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true; // default available
    }

    // Getter methods (for accessing private data)
    public String getTitle() {
        return this.title;
    }

    public boolean isAvailable() {
        return this.available;
    }

    // Method to issue a book
    public void issueBook() {
        if (available) {
            available = false;
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Sorry, book already issued.");
        }
    }

    // Display book details
    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author + 
                           ", Price: " + price + ", Available: " + available);
    }
}

class Library {
    private Book[] books; // array of Book objects
    private int count;
    private static int totalBooks = 0; // static variable for total books

    // Constructor
    Library(int size) {
        books = new Book[size];//creates a array that can hold 5(size) objects
        count = 0;
    }

    // Add new book
    public void addBook(Book b) {
        if (count < books.length) {
            books[count] = b;
            count++;
            totalBooks++; // static counter increases
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full! Cannot add more books.");
        }
    }

    // Search book by title
    public Book searchBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i]; // return reference
            }
        }
        return null;
    }

    // Static method to display total books
    public static void displayTotalBooks() {
        System.out.println("Total Books in Library: " + totalBooks);
    }

    // Nested Class
    class Statistics {
        void showStats() {
            System.out.println("Number of books added: " + count);
            Library.displayTotalBooks();
        }
    }
}

// Driver class
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library(5); // max 5 books

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");//issue means giving the book to a person
            System.out.println("4. Show Stats");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    Book b = new Book(title, author, price);
                    lib.addBook(b);
                    break;

                case 2:
                    System.out.print("Enter title to search: ");
                    String searchTitle = sc.nextLine();
                    Book found = lib.searchBook(searchTitle);
                    if (found != null)
                        found.displayBook();
                    else
                        System.out.println("Book not found.");
                    break;

                case 3:
                    System.out.print("Enter title to issue: ");
                    String issueTitle = sc.nextLine();
                    Book toIssue = lib.searchBook(issueTitle);
                    if (toIssue != null)
                        toIssue.issueBook(); // passed by reference
                    else
                        System.out.println("Book not found.");
                    break;

                case 4:
                    Library.Statistics stats = lib.new Statistics();
                    stats.showStats();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

