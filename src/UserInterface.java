import java.util.Scanner;

public class UserInterface {
    Controller controller = new Controller();

    public void startProgram() {
        Scanner input = new Scanner(System.in);
        //Vi kommenterer Moviecollection ud og tilføjer vores controller klasse.
        //MovieCollection o = new MovieCollection();
       // Controller o = new Controller();

        //Start på While Loop, menu til bruger.
        final int SENTINEL = 9;
        int loopInput = 0;

        //Hardcode til debug
        controller.addMovie("Adams æbler", "Jonathan B", 2018, true, 193, "Horror");
        controller.addMovie("Adams æbler 2", "Jonathan B", 2013, true, 193, "Horror");
        controller.addMovie("Batman", "Jonathan H", 2012, true, 193, "Horror");

        while (loopInput != SENTINEL) {
            try {
                    //Der printes en menu ud til brugeren, således de kan navigere i programmet.
                    menuVelkomst(); //Menu med navigationspunkter. Metode findes nedenfor i nærværende klasse.
                    loopInput = input.nextInt();
                    input.nextLine();

                    if (loopInput == 1) { //Primære blok af kode til at tilføje nye film til samling.
                        addMovieMethod(); //Metodekald til at oprette film.

                    }
                    //Se en liste af dine film
                    if (loopInput == 2) {
                        controller.seeListOfMovies();
                    }
                    if (loopInput == 3) {
                        System.out.println("Indtast venlig en søgning.");
                        String searchTerm = input.nextLine();
                        //o.searchMovie(searchTerm);
                        controller.searchMovie(searchTerm);
                    }
                    if (loopInput == 4) {
                        controller.displayMovieIndex(); //Oversigt af filmtitler med tilhørende index nr for lettere navigation.
                        System.out.println("Vælg venligst en film, som du ønsker at redigere ved at indtaste filmens index plads i din filmsamling.");
                        int index = input.nextInt();
                        input.nextLine();
                        controller.editMovieMenu(index);
                    }
                    if (loopInput == 5) {
                        controller.displayMovieIndex();
                        System.out.print("Filmsletning på index: ");
                        int index = input.nextInt();
                        input.nextLine();
                        controller.movieDeletion(index);
                    }
                    if(loopInput == 9) {
                        System.out.println("Du har valgt at afslutte programmet.");
                    }
                    /*
                    if (loopInput == 5) { //Test input af søgefunktion af arrayliste fra 29/2/2024. Virker ikke. Returnerer ikke noget.
                        System.out.println("Indtast din søgning");
                        String searchTerm = input.nextLine();
                        input.nextLine();
                        o.searchMovieArraylist(searchTerm);
                     */
            } catch (Exception e) {
                System.out.println("Der skete en fejl. Du er blevet sendt tilbage til menuen.");
                input.nextLine();
            }
        }
    }
    public void addMovieMethod() {
        //I nedenstående kode er der indsat input.nextLine efter hver int eller boolean variabel i et
        // forsøg på at redde programmet fra Scanner bug.
        //Controller o = new Controller();
        Scanner input = new Scanner(System.in);

        System.out.println("Skriv titlen på filmen.");
        String title = input.nextLine();

        System.out.println("Skriv navnet på instruktøren.");
        String director = input.nextLine();

        System.out.println("Skriv årstallet på, hvornår filmen blev udgivet.");
        int yearCreated = input.nextInt();
        input.nextLine();

        //Brugerinput i fht. farve. Kan skrive ja eller nej.
        //Metode "lånt" fra Edith. isInColor sættes til false som udgangspunkt. Hvis brugeren skriver nej, er filmen
        //på forhånd sat til ikke at være i farve.
        System.out.println("Skriv, hvorvidt filmen er i farve eller ej. Ja/Nej.");
        boolean isInColor = false;
        String farveValg = input.next().toLowerCase();
        if (farveValg.equals("ja")) { //hvis brugeren skriver ja, sættes isInColor til true og filmen er i farve.
            isInColor = true;
        }

        System.out.println("Skriv varigheden af filmen i minutter.");
        int lengthInMinutes = input.nextInt();
        input.nextLine();

        System.out.println("Skriv genren.");
        String genre = input.next();

        controller.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
    }

    public void menuVelkomst() { //Blot for at samle de mange sysout for bedre overskuelighed af startProgram().
        System.out.println("\nVelkommen til din filmsamling.");
        System.out.println("Tast 1 for at oprette en film.");
        System.out.println("Tast 2 for at se din samling.");
        System.out.println("Tast 3 for at foretage en søgning.");
        System.out.println("Tast 4 for at redigere en film i din samling.");
        System.out.println("Tast 5 for at slette en film i din samling.");
        System.out.println("Tast 9 for at afslutte.\n");

    }
}
