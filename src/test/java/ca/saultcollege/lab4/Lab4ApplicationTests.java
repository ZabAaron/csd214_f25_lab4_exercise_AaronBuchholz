package ca.saultcollege.lab4;

import ca.saultcollege.lab4.entities.BookEntity;
import ca.saultcollege.lab4.repositories.BookEntityRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class Lab4ApplicationTests {

    @Autowired
    private BookEntityRepository bookRepository;
    private final Faker faker = new Faker();



	@BeforeEach
    void setUp() {
        bookRepository.deleteAll();
    }
    @Test
    void testSaveAndFindBook(){

        BookEntity book = new BookEntity(
                faker.book().title(),
                faker.number().randomDouble(2, 1, 5),
                faker.number().numberBetween(1, 5),
                faker.book().author());


        BookEntity savedBook = bookRepository.save(book);
        Optional<BookEntity> foundBook = bookRepository.findById(savedBook.getId());


        assertNotNull(foundBook);
        assertTrue(foundBook.isPresent(), "Book should be found");
        assertEquals(savedBook.getTitle(), foundBook.get().getTitle(), "Book title should be found");
        assertEquals(savedBook.getAuthor(), foundBook.get().getAuthor(), "Book author should be found");
        assertEquals(savedBook.getPrice(), foundBook.get().getPrice(), "Book price should be found");
        assertEquals(savedBook.getCopies(), foundBook.get().getCopies(), "Book copies should be found");

    }

    @Test
    void testFindBookByAuthor(){

        String authorName = "Aaron";
        BookEntity book1 = new BookEntity("Book one", 1.0, 1, authorName);
        BookEntity book2 = new BookEntity("Book two", 2.0, 2, authorName);
        bookRepository.save(book1);
        bookRepository.save(book2);

        var booksByAuthor = bookRepository.findByAuthor(authorName);

        assertEquals(2, booksByAuthor.size(), "Should find 2 books");
        assertTrue(booksByAuthor.stream().anyMatch(book -> authorName.equals(book.getAuthor())), "Book should be found");
    }


    @Test
    void testDeleteBook(){
        BookEntity book = new BookEntity(
                faker.book().title(),
                faker.number().randomDouble(2, 1, 5),
                faker.number().numberBetween(1, 5),
                faker.book().author());


        BookEntity savedBook = bookRepository.save(book);

        bookRepository.delete(savedBook);
        Optional<BookEntity> deletedBook = bookRepository.findById(savedBook.getId());
        assertFalse(deletedBook.isPresent(), "Book should be deleted");


    }












}
