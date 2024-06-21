public class Movie {
    private String title;
    private double rating;
    private String[] genres;

    public Movie(String title, double rating, String[] genres) {
        this.title = title;
        this.rating = rating;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }
}
