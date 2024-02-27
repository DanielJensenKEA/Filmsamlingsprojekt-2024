import java.util.Scanner;

public class UserInterface {

    public void startProgram() {
        Scanner input = new Scanner(System.in);
        //Vi kommenterer Moviecollection ud og tilføjer vores controller klasse.
        //MovieCollection o = new MovieCollection();
        Controller o = new Controller();

        //Start på While Loop, menu til bruger.
        final int SENTINEL = 9;
        int loopInput = 1;
        int i = 0;

        //Hardcode til debug
        o.addMovie("Adams æbler", "Jonathan B", 2018, true, 193, "Horror" );
        o.addMovie("Adams æbler 2", "Jonathan B", 2013, true, 193, "Horror" );
        o.addMovie("Batman", "Jonathan H", 2012, true, 193, "Horror" );
        //

        while (loopInput != SENTINEL ) {
            //Der printes en menu ud til brugeren, således de kan navigere i programmet.
            menuVelkomst(); //Menu med navigationspunkter
            loopInput = input.nextInt();
            input.nextLine();

            if(loopInput == 1) { //Primære blok af kode til at tilføje nye film til samling.
                addMovieMethod(); //Metodekald til at oprette film.

                //Kode er udkommenteret.
                // Movie[] test2 = o.getFilmSamling();
                //System.out.println(test2[0].getTitle() + "er tilføjet til listen.");
            }
            //Se en liste af dine film
            if(loopInput == 2) {
                o.seeListOfMovies();
            }
            if(loopInput == 3) {
                System.out.println("Indtast venlig en søgning.");
                String searchTerm =  input.nextLine();
                o.searchMovie(searchTerm);
            }

            else if (loopInput == 9) { //skod linje af kode
                System.out.println("Du har afsluttet programmet.");
            }
        }
    }
    public void addMovieMethod() {
        //I nedenstående kode er der indsat input.nextLine efter hver int eller boolean variabel i et
        // forsøg på at redde programmet fra Scanner bug.
        Controller o = new Controller();
        Scanner input = new Scanner(System.in);

        System.out.println("Skriv titlen på filmen.");
        String title = input.nextLine();

        System.out.println("Skriv navnet på instruktøren.");
        String director = input.nextLine();

        System.out.println("Skriv årstallet på, hvornår filmen blev udgivet.");
        int yearCreated = input.nextInt();
        input.nextLine();

        //Brugerinput i fht. farve. Kan skrive ja eller nej.
        System.out.println("Skriv, hvorvidt filmen er i farve eller ej. Ja/Nej.");
        boolean isInColor = false;
        String farveValg = input.next().toLowerCase();
        if (farveValg.equals("ja")) {
            isInColor = true;
        }

        System.out.println("Skriv varigheden af filmen i minutter.");
        int lengthInMinutes = input.nextInt();
        input.nextLine();

        System.out.println("Skriv genren.");
        String genre = input.next();

        o.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
    }

    public void menuVelkomst() {
        System.out.println("Velkommen til din filmsamling.");
        System.out.println("Tast 1 for at oprette en film.");
        System.out.println("Tast 2 for at se din samling.");
        System.out.println("Tast 3 for at foretage en søgning.");
        System.out.println("Tast 9 for at afslutte.");
    }
}