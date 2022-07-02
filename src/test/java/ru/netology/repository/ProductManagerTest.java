package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(1, "Книга1", 10, "Перумов");
    private Book book2 = new Book(2, "Книга1", 20, "Никитин");
    private Book book3 = new Book(3, "Книга2", 30, "Дивов");


    @BeforeEach
    public void save() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
    }

    @Test
    void shouldRemoveByExistingId() {
        repository.removeById(1);

        Product[] expected = new Product[]{book2, book3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldRemoveByNotExistingId() {
        assertThrows(NotFoundException.class, () -> {
            repository.removeById(4);
        });
    }
}