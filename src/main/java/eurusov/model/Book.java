package eurusov.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Book {

    private static AtomicInteger idGenerator = new AtomicInteger();

    private Integer id;
    private String title;
    private String author;
    private boolean available;

    // ~ Constructors
    // ======================================================================================
    public Book(String title, String author) {
        this.id = idGenerator.incrementAndGet();
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // ~ Getters
    // ======================================================================================

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // ~ Setters
    // ======================================================================================
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", available=" + available +
                '}';
    }
}
