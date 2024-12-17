import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class AviaSoulsTest {

    @Test
    public void searchOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("NY", "MSC", 250, 11, 14);
        Ticket ticket2 = new Ticket("NY", "LA", 100, 9, 19);
        Ticket ticket3 = new Ticket("LA", "SPB", 400, 5, 22);
        Ticket ticket4 = new Ticket("SPB", "MEL", 600, 14, 20);
        Ticket ticket5 = new Ticket("LA", "SPB", 320, 8, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("SPB", "MEL");
        Ticket[] expected = {ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchSeveralTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("NY", "MSC", 250, 11, 14);
        Ticket ticket2 = new Ticket("NY", "LA", 100, 9, 19);
        Ticket ticket3 = new Ticket("LA", "SPB", 400, 5, 22);
        Ticket ticket4 = new Ticket("SPB", "MEL", 600, 14, 20);
        Ticket ticket5 = new Ticket("LA", "SPB", 320, 8, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("LA", "SPB");
        Ticket[] expected = {ticket5, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("NY", "MSC", 250, 11, 14);
        Ticket ticket2 = new Ticket("NY", "LA", 100, 9, 19);
        Ticket ticket3 = new Ticket("LA", "SPB", 400, 5, 22);
        Ticket ticket4 = new Ticket("SPB", "MEL", 600, 14, 20);
        Ticket ticket5 = new Ticket("LA", "SPB", 320, 8, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.search("MAD", "SPB");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOneTicketAndComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("NY", "MSC", 250, 11, 14);
        Ticket ticket2 = new Ticket("NY", "LA", 100, 9, 19);
        Ticket ticket3 = new Ticket("LA", "SPB", 400, 5, 22);
        Ticket ticket4 = new Ticket("SPB", "MEL", 600, 14, 20);
        Ticket ticket5 = new Ticket("LA", "SPB", 320, 8, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("SPB", "MEL", comparator);
        Ticket[] expected = {ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchSeveralTicketsAndComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("NY", "MSC", 250, 11, 14);
        Ticket ticket2 = new Ticket("NY", "LA", 100, 9, 19);
        Ticket ticket3 = new Ticket("LA", "SPB", 400, 5, 22);
        Ticket ticket4 = new Ticket("SPB", "MEL", 600, 14, 20);
        Ticket ticket5 = new Ticket("LA", "SPB", 320, 8, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] actual = manager.searchAndSortBy("LA", "SPB", comparator);
        Ticket[] expected = {ticket5, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchZeroTicketsAndComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("NY", "MSC", 250, 11, 14);
        Ticket ticket2 = new Ticket("NY", "LA", 100, 9, 19);
        Ticket ticket3 = new Ticket("LA", "SPB", 400, 5, 22);
        Ticket ticket4 = new Ticket("SPB", "MEL", 600, 14, 20);
        Ticket ticket5 = new Ticket("LA", "SPB", 320, 8, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("MAD", "SPB", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}