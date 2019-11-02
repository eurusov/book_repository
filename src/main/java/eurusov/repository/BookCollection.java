package eurusov.repository;

import eurusov.model.Book;

public interface BookCollection {

    int getSize();

    void add(Book book);

    Book getByIndex(int index);

    default Book getById(int id){
        Integer index = indexById(id);
        return index == null ? null : getByIndex(index);
    }

    void remove(int id);

    default Integer indexById(int id) {
        for (int i = 0; i < getSize(); i++) {
            if (getByIndex(i).getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    Book[] getAll();
}
