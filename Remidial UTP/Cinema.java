import java.util.ArrayList;

public class Cinema {
    private String name;
    private ArrayList<User> listUsers;
    private ArrayList<Studio> listStudio;
    private int studioCapacity;

    public Cinema(String name, int studioCapacity) {
        this.name = name;
        this.studioCapacity = studioCapacity;
        this.listUsers = new ArrayList<>();
        this.listStudio = new ArrayList<>(studioCapacity);
        init();
    }

    public void init() {
        addStudioWithMovies("Imax", "Inception", 9.0, new String[]{"Action", "Sci-Fi"});
        addStudioWithMovies("Premiere", "The Shawshank Redemption", 9.3, new String[]{"Drama"});
        addStudioWithMovies("Reguler", "The Lord of the Rings: The Fellowship of the Ring", 8.8, new String[]{"Adventure", "Fantasy"});
        addStudioWithMovies("Imax", "Avatar", 7.8, new String[]{"Action", "Adventure"});
        addStudioWithMovies("Premiere", "The Godfather", 9.2, new String[]{"Crime", "Drama"});
    }

    public boolean registerUser(User user) {
        return listUsers.add(user);
    }

    public User authenticateUser(String email, String password) {
        for (User user : listUsers) {
            if (user.isMatch(email, password)) {
                return user;
            }
        }
        return null;
    }

    public void displayListStudio() {
        System.out.println("List Studio");
        for (int i = 0; i < listStudio.size(); i++) {
            Studio studio = listStudio.get(i);
            System.out.println("Studio : " + (i + 1));
            System.out.println("Type   : " + studio.getType());
            System.out.println("Movie  : " + studio.getMovie().getTitle());
            System.out.println("--------------------------------");
        }
    }

    public void displayStudioDetail(int studioNumber) {
        if (studioNumber > 0 && studioNumber <= listStudio.size()) {
            System.out.println(listStudio.get(studioNumber - 1).getStudioInfo());
        } else {
            System.out.println("Invalid studio number.");
        }
    }

    public boolean addStudioWithMovies(String studioType, String movieTitle, double movieRating, String[] movieGenres) {
        if (listStudio.size() < studioCapacity) {
            Movie movie = new Movie(movieTitle, movieRating, movieGenres);
            Studio studio = new Studio(studioType);
            studio.setMovie(movie);
            listStudio.add(studio);
            return true;
        }
        return false;
    }

    public boolean bookTicket(User user, int studioNumber, int row, char col) {
        if (studioNumber > 0 && studioNumber <= listStudio.size()) {
            Studio studio = listStudio.get(studioNumber - 1);
            if (studio.reserve(row, col)) {
                Ticket ticket = new Ticket(studio.getMovie(), studioNumber, studio.getType(), String.valueOf(col) + row);
                return user.addTicket(ticket);
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
