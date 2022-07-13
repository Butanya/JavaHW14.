import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);


    Ticket first = new Ticket(111, 23333, "EGO", "DME", 140);
    Ticket second = new Ticket(222, 14555, "DME", "GOJ", 130);
    Ticket third = new Ticket(333, 75555, "SVO", "LED", 70);
    Ticket fourth = new Ticket(444, 10000, "DME", "GOJ", 180);
    Ticket fifth = new Ticket(555, 12000, "DME", "GOJ", 180);
    Ticket sixth = new Ticket(111, 23333, "EGO", "DME", 150);

    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
    }

    @Test
    void shouldNotFindAllBySearch() {

        Ticket[] actual = manager.getAll("SVO", "DME");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindAllBySearch1() {

        Ticket[] actual = manager.getAll("SVO", "LED");
        Ticket[] expected = {third};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllBySearch2() {

        Ticket[] actual = manager.getAll("EGO", "DME");
        Ticket[] expected = {first, sixth};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindAllBySearch3() {

        Ticket[] actual = manager.getAll("DME", "GOJ");
        Ticket[] expected = {fourth, fifth, second};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindAll() {

        Ticket[] actual = repository.findAll();
        Ticket[] expected = {first, second, third, fourth, fifth, sixth};

        Assertions.assertArrayEquals(expected, actual);
    }

   @Test
    void shouldFindById1() {
        Ticket actual = repository.findById(444);
        Ticket expected = fourth;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindById() {

        repository.findById(888);

        Ticket[] actual = repository.findAll();
        Ticket[] expected = {first, second, third, fourth, fifth, sixth};

        Assertions.assertArrayEquals(expected, actual);
    }



    @Test
    void shouldRemoveById() {

        Ticket[] actual = repository.removeById(444);
        Ticket[] expected = {first, second, third, fifth, sixth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById2() {
        repository.removeById(444);
        repository.removeById(555);

        Ticket[] actual = repository.findAll();
        Ticket[] expected = {first, second, third, sixth};

        Assertions.assertArrayEquals(expected, actual);
    }
}


