public class Ticket {
    private Movie movie;
    private int studioNumber;
    private double price;
    private String seat;

    public Ticket(Movie movie, int studioNumber, String studioType, String seat) {
        this.movie = movie;
        this.studioNumber = studioNumber;
        this.price = getTicketPrice(studioType);
        this.seat = seat;
    }

    public static double getTicketPrice(String type) {
        switch (type) {
            case "Premiere":
                return 120000;
            case "Imax":
                return 100000;
            case "Reguler":
                return 50000;
            default:
                return 0;
        }
    }

    public String getTicketInfo() {
        return "Movie: " + movie.getTitle() + ", Studio: " + studioNumber + ", Seat: " + seat + ", Price: " + price;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getStudioNumber() {
        return studioNumber;
    }

    public double getPrice() {
        return price;
    }

    public String getSeat() {
        return seat;
    }
}
