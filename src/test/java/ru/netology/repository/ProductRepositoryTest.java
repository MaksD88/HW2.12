package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    //private Book book = new Book();
    private ProductManager manager = new ProductManager( repository );

    private Book book1 = new Book( 1, "Book1", 100, "Author1" );
    private Book book2 = new Book( 2, "Book2", 100, "Author1" );
    private Book book3 = new Book( 3, "Book3", 100, "Author2" );
    private Book book4 = new Book( 4, "Book4", 100, "Author2" );
    private Book book5 = new Book( 5, "Book5", 100, "Author3" );



    @Test
    public void removeByIdElementNotExistTest() {

        assertThrows( NotFoundException.class, () -> repository.removeById( 6 ) );
    }

    @Test
    public void shouldFinById() {
        repository.save( book2 );
        repository.findById( book2.getId() );

        Product[] expected = {book2};
        Product[] actual = repository.getItems();
        assertArrayEquals( expected, actual );

    }


    
    @Test
    public void shouldSaveOneItem() {
        repository.save( book1 );

        Product[] expected = new Product[]{book1};
        Product[] actual = repository.findAll();
        assertArrayEquals( expected, actual );
    }

    @Test
    public void shouldRemoveId() {
        repository.save( book1 );
        repository.save( book2 );
        repository.save( book3 );
        repository.removeById( book3.getId() );
        Product[] expected = {book1, book2};
        Product[] actual = repository.getItems();
        assertArrayEquals( expected, actual );
    }

}
