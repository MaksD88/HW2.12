package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager( repository );

    private Book book1 = new Book( 1, "Book1", 100, "Author1" );
    private Book book2 = new Book( 2, "Book2", 100, "Author2" );
    private Book book3 = new Book( 3, "Book3", 100, "Author3" );
    private Book book4 = new Book( 4, "Book4", 100, "Author4" );
    private Book book5 = new Book( 5, "Book5", 100, "Author5" );

    private Smartphone smartphone1 = new Smartphone( 1, "Smartphone1", 1000, "Producer1" );
    private Smartphone smartphone2 = new Smartphone( 2, "Smartphone2", 1000, "Producer2" );
    private Smartphone smartphone3 = new Smartphone( 3, "Smartphone3", 1000, "Producer3" );
    private Smartphone smartphone4 = new Smartphone( 4, "Smartphone5", 1000, "Producer4" );
    private Smartphone smartphone5 = new Smartphone( 5, "Smartphone5", 1000, "Producer4" );

    @BeforeEach
    void setUp() {
        manager.save( book1 );
        manager.save( book2 );
        manager.save( book3 );
        manager.save( book4 );
        manager.save( book5 );
        manager.save( smartphone1 );
        manager.save( smartphone2 );
        manager.save( smartphone3 );
        manager.save( smartphone4 );
        manager.save( smartphone5 );
    }


    @Test
    public void shouldFindBookByName() {
        String nameToSearch = "Book2";
        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy( nameToSearch );
        assertArrayEquals( expected, actual );
    }


    @Test
    public void shouldFindSmartphoneByName() {
        String nameToSearch = "Smartphone2";
        Product[] expected = new Product[]{smartphone2};
        Product[] actual = manager.searchBy( nameToSearch );
        assertArrayEquals( expected, actual );
    }



    @Test
    public void shouldFindSmartphoneByNameMoreThenOne() {
        String nameToSearch = "Smartphone5";
        Product[] expected = new Product[]{smartphone4, smartphone5};
        Product[] actual = manager.searchBy( nameToSearch );
        assertArrayEquals( expected, actual );
    }

    // дописан тест: не найдено ниодного продукта

    @Test
    public void shouldFindSmartphoneByNameZero() {
        String nameToSearch = "Smartphone6";
        Product[] expected = {};
        Product[] actual = manager.searchBy( nameToSearch );
        assertArrayEquals( expected, actual );
    }



    @Test
    void searchByInvalidBookName() {

        Product[] expected = {};
        Product[] actual = manager.searchBy( "NoName" );
        assertArrayEquals( expected, actual );
    }

    @Test
    void searchByInvalidAuthor() {

        Product[] expected = {};
        Product[] actual = manager.searchBy( "NoAuthor" );
        assertArrayEquals( expected, actual );

    }


    @Test
    void searchByInvalidProducer() {

        Product[] expected = {};
        Product[] actual = manager.searchBy( "Samsung" );
        assertArrayEquals( expected, actual );
    }


    @Test
    void searchByInvalidSmartphoneByName() {

        Product[] expected = {};
        Product[] actual = manager.searchBy( "Iphone" );
        assertArrayEquals( expected, actual );
    }


}