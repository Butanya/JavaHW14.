import java.util.Arrays;

public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];


    public void save(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);

        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {

        return tickets;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (id == ticket.getId()) {
                return ticket;
            }
        }
        return null;
    }


    public Ticket[] removeById(int id) {

        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
            tickets = tmp;
        }
        return tickets;
    }
}
