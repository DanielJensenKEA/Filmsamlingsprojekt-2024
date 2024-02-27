public class Movie {
    private String title;
    private String director;
    private int yearCreated;
    private boolean isInColor = false;
    private int lengthInMinutes;
    private String genre;
    MovieCollection f = new MovieCollection();

    public Movie(String title, String director, int yearCreated, boolean isInColor, int lengthInMinutes, String genre) {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.isInColor = isInColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;

    }


    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public boolean isInColor() {
        return isInColor;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public void setInColor(boolean inColor) {
        isInColor = inColor;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        String result = "";
        result += "\nTitel:" + title + " " + "\n Genre:" + genre + "\n  Instruktør:" + director + "\n   År:" + yearCreated + "\n    Længde i minutter: " + lengthInMinutes;
        if (isInColor) {
            result += "\n     Filmen er i farve";
        } else {
            result += "\n     Filmen er ikke i farve.";
        }

        return result;
    }
}

