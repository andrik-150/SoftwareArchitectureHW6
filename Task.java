// В пакете domain

public class Book {
    private String id;
    private String title;
    private String author;
    private double price;

    // Конструктор, геттеры и сеттеры
}

// В пакете data

import java.util.List;

public interface BookRepository {
    void addBook(Book book);
    void removeBook(Book book);
    List<Book> getAllBooks();
}

public class InMemoryBookRepository implements BookRepository {
    private List<Book> books;

    public InMemoryBookRepository(List<Book> books) {
        this.books = books;
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }
}

// В пакете presentation

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        BookRepository bookRepository = new InMemoryBookRepository(books);

        // Добавляем книги
        Book book1 = new Book("1", "Clean Code", "Robert C. Martin", 34.99);
        Book book2 = new Book("2", "Effective Java", "Joshua Bloch", 29.99);
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);

        // Получаем список всех книг
        List<Book> allBooks = bookRepository.getAllBooks();
        for (Book book : allBooks) {
            System.out.println("Книга: " + book.getTitle() + ", Автор: " + book.getAuthor() + ", Цена: $" + book.getPrice());
        }
    }
}
