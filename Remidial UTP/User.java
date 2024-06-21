import java.util.ArrayList;

public class User {
    private String email;
    private String password;
    private String fullName;
    private double balance;
    private ArrayList<Ticket> ticketLists;
    private final int MAX_TICKET = 20;

    public User(String email, String password, String fullName, double balance) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.balance = balance;
        this.ticketLists = new ArrayList<>();
    }

    public boolean addTicket(Ticket ticket) {
        if (ticketLists.size() < MAX_TICKET) {
            if (balance >= ticket.getPrice()) {
                ticketLists.add(ticket);
                balance -= ticket.getPrice();
                return true;
            }
        }
        return false;
    }

    public void displayAllTickets() {
        if (ticketLists.isEmpty()) {
            System.out.println("You have no tickets.");
        } else {
            for (Ticket ticket : ticketLists) {
                System.out.println(ticket.getTicketInfo());
            }
        }
    }

    public boolean isMatch(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
