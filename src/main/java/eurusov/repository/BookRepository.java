package eurusov.repository;

import eurusov.model.Book;

public interface BookRepository extends BookCollection {

    default void addBooks(Book[] books) {
        for (Book book : books) {
            book.setAvailable(true);
            this.add(book);
        }
    }

    default Book giveToReader(String title, String author) {
        Book book = findOne(title, author, true);
        if (book != null) {
            book.setAvailable(false);
        }
        return book;
    }

    default Book findOne(String title, String author, Boolean ready) {
        for (int i = 0; i < this.getSize(); i++) {
            Book book = this.getByIndex(i);
            if ((ready == null || book.isAvailable() == ready)
                    && (title == null || book.getTitle().equals(title))
                    && (author == null || book.getAuthor().equals(author))
            ) {
                return book;
            }
        }
        return null;
    }

    default Book[] findAll(String title, String author, Boolean ready) {
        BookCollection res = new SimpleBookCollection();
        for (int i = 0; i < this.getSize(); i++) {
            Book book = this.getByIndex(i);
            if ((ready == null || book.isAvailable() == ready)
                    && (title == null || book.getTitle().equals(title))
                    && (author == null || book.getAuthor().equals(author))
            ) {
                res.add(book);
            }
        }
        return res.getAll();
    }
}
