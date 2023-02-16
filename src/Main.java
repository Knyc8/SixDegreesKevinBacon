import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data (1)");
        CostarDBBuilder.createLevel1(movies);
        ArrayList<SimpleMovie> baconMovies = MovieDatabaseBuilder.getMovieDB("src/bacon_movies");
        ArrayList<String> baconCostars = MovieDatabaseBuilder.getActorDB("src/bacon_costars");
        ArrayList<SimpleMovie> baconCostarMovies = MovieDatabaseBuilder.getMovieDB("src/bacon_costars_movies");

        Scanner s = new Scanner(System.in);
        System.out.print("Enter an actor(ress): ");
        String actor = s.nextLine();
        Boolean contains = false;
        String printMessage = "Selected actor(ress): " + actor + "\n" + actor;
        for (SimpleMovie bm : baconMovies)
        {
            if (bm.getActors().indexOf(actor) != -1)
            {
                System.out.println("Selected actor(ress): " + actor);
                System.out.println(actor + " --> " + bm.getTitle() + " --> Kevin Bacon" + "\nBacon #: " + 1);
                contains = true;
                break;
            }
        }
        if (!contains) //level 2
        {
            for (SimpleMovie movie : baconCostarMovies)
            {
                if (movie.getActors().contains(actor))
                {
                    String finalMovie = movie.getTitle();
                    for (String currActor : movie.getActors()) {
                        if (baconCostars.contains(currActor))
                        {
                            String secondActor = currActor;
                            for (SimpleMovie baconMovie : baconMovies) {
                                if (baconMovie.getActors().contains(currActor)) {
                                    String firstMovie = baconMovie.getTitle();
                                    System.out.println("Selected actor(ress): " + actor);
                                    System.out.println(actor + " --> " + firstMovie + " --> " + secondActor + " --> " + finalMovie + " --> Kevin Bacon" + "\nBacon #: " + 2);
                                    contains = true;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
        if (!contains) //level 3
        {
            CostarDBBuilder.createActorMovies(movies, actor);
            ArrayList<SimpleMovie> actorMovies = MovieDatabaseBuilder.getMovieDB("src/actor_movies");
            ArrayList<String> actorCostars = MovieDatabaseBuilder.getActorDB("src/actor_costars");
            for (String actCostar : actorCostars)
            {
                String secondActor = actCostar;
                for (SimpleMovie movie : baconCostarMovies)
                {
                    String middleMovie = movie.getTitle();
                    if (movie.getActors().contains(actCostar))
                    {
                        String firstMovie = "";
                        for (SimpleMovie actMovie : actorMovies)
                        {
                            if (actMovie.getActors().contains(actCostar))
                            {
                                firstMovie = actMovie.getTitle();
                            }
                        }
                        for (String baconCostar : movie.getActors())
                        {
                            if (baconCostars.contains(baconCostar))
                            {
                                String middleActor = baconCostar;
                                for (SimpleMovie baconMovie : baconMovies)
                                {
                                    if (baconMovie.getActors().contains(middleActor))
                                    {
                                        String finalMovie = baconMovie.getTitle();
                                        System.out.println("Selected actor(ress): " + actor);
                                        System.out.println(actor + " --> " + firstMovie + " --> " + secondActor + " --> " + middleMovie + " --> " + middleActor + " --> " + finalMovie + " --> Kevin Bacon" + "\nBacon #: " + 3);
                                        contains = true;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
                if (contains)
                {
                    break;
                }
            }
        }
    }
}