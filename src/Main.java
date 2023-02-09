import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data (1)");
        for (SimpleMovie movie : movies) {
            System.out.println(movie);
        }
        System.out.println("Number of movies: " + movies.size());

        CostarDBBuilder.createLevel1(movies);

        ArrayList<SimpleMovie> baconMovies = MovieDatabaseBuilder.getMovieDB("src/bacon_costars");
        for (SimpleMovie bm : baconMovies) {
            System.out.println(bm);
        }
        System.out.println("Number of Bacon's movies: " + baconMovies.size());

        Scanner s = new Scanner(System.in);
        System.out.print("Enter an actor(ress): ");
        String actor = s.nextLine();
        System.out.println(CostarDBBuilder.searchActor(actor, baconMovies));
    }
}