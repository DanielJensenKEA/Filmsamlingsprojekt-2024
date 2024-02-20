public class MovieCollection {
    private Movie [] filmSamling;
    int count = 0;

    public MovieCollection() {
        this.filmSamling = new Movie[5];
    }

    public void addMovie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre) {
        filmSamling[count++] = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
    }





}
