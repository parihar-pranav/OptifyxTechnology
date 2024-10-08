import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public boolean isBorrowed() { return isBorrowed; }
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}

class LibraryManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void updateBook(int id, String title, String author) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(title);
                book.setAuthor(author);
                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void deleteBook(int id) {
        if (books.removeIf(book -> book.getId() == id)) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBooks(String query) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(book);
            }
        }
    }
}

public class DigitalLibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager libraryManager = new LibraryManager();

        while (true) {
            System.out.println("\nDigital Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. List Books");
            System.out.println("5. Search Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    libraryManager.addBook(new Book(id, title, author));
                    break;
                case 2:
                    System.out.print("Enter book ID to update: ");
                    id = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Enter new title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    author = scanner.nextLine();
                    libraryManager.updateBook(id, title, author);
                    break;
                case 3:
                    System.out.print("Enter book ID to delete: ");
                    id = scanner.nextInt();
                    libraryManager.deleteBook(id);
                    break;
                case 4:
                    libraryManager.listBooks();
                    break;
                case 5:
                    System.out.print("Enter search query: ");
                    String query = scanner.nextLine();
                    libraryManager.searchBooks(query);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
 }
}
}