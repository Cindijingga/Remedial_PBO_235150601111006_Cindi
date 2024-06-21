public class Studio {
    private Movie movie;
    private String type;
    private boolean[][] seats;

    public Studio(String type) {
        this.type = type;
        setSeats();
    }

    public void setSeats() {
        switch (type) {
            case "Imax":
                seats = new boolean[8][9];
                break;
            case "Premiere":
                seats = new boolean[6][4];
                break;
            case "Reguler":
                seats = new boolean[5][5];
                break;
        }
    }

    public boolean reserve(int row, char col) {
        int colIndex = col - 'A';
        if (row < seats.length && colIndex < seats[0].length) {
            if (!seats[row][colIndex]) {
                seats[row][colIndex] = true;
                return true;
            }
        }
        return false;
    }

    public int isBooked(int row, char col) {
        int colIndex = col - 'A';
        if (row < 0 || row >= seats.length || colIndex < 0 || colIndex >= seats[0].length) {
            return -1;
        }
        return seats[row][colIndex] ? 1 : 0;
    }

    public String getStudioInfo() {
        StringBuilder info = new StringBuilder();
        info.append("  ");
        for (int i = 1; i <= seats[0].length; i++) {
            info.append(i).append(" ");
        }
        info.append("\n");

        char rowLabel = 'A';
        for (boolean[] row : seats) {
            info.append(rowLabel).append(" ");
            for (boolean seat : row) {
                info.append(seat ? "X " : "O ");
            }
            info.append("\n");
            rowLabel++;
        }

        info.append("--------------------------------\n");
        info.append("Movie : ").append(movie.getTitle()).append("\n");
        info.append("Type  : ").append(type).append("\n");
        info.append("Price : ").append(Ticket.getTicketPrice(type)).append("\n");
        info.append("Genre : ").append(String.join(", ", movie.getGenres())).append("\n");

        return info.toString();
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getType() {
        return type;
    }
}
