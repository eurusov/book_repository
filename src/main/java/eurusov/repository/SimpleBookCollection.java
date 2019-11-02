package eurusov.repository;

import eurusov.model.Book;

import java.util.Arrays;

public class SimpleBookCollection implements BookCollection {
    private Book[] books = new Book[10];
    private int size;

    public int getSize() {
        return size;
    }

    @Override
    public void add(Book book) {
        if (size == books.length) {
            books = Arrays.copyOf(books, books.length * 2);
        }
        books[size++] = book;
    }

    @Override
    public Book getByIndex(int index) {
        return books[index];
    }

    @Override
    public void remove(int id) {
        Integer index = indexById(id);
        if (index != null) {
            System.arraycopy(books, index + 1, books, index, size - index + 1);
            size--;
        }
    }

    @Override
    public Book[] getAll() {
        return Arrays.copyOf(books, size);
    }

    @Override
    public String toString() {
        return "SimpleBookCollection{" +
                "books=" + Arrays.toString(books) +
                ", size=" + size +
                '}';
    }
}
