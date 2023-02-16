import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CostarDBBuilder {
    public static int baconNumber = 0;
    //creates a new file of the actors that have worked with Bacon
    public static void createLevel1(ArrayList<SimpleMovie> movies) {
        try {
        FileWriter baconMovies = new FileWriter("src/bacon_movies");
        FileWriter baconCostars = new FileWriter("src/bacon_costars");
        ArrayList<String> costarList = new ArrayList<String>();
        baconNumber++;
        for (SimpleMovie movie : movies)
        {
            ArrayList<String> cast = movie.getActors();
            for (String actor : cast)
            {
                if (actor.equalsIgnoreCase("Kevin Bacon"))
                {
                    baconMovies.write(movie.getTitle() + "---");
                    for (String costar : movie.getActors())
                    {
                        baconMovies.write(costar + ":");
                        if (!costar.equals("Kevin Bacon") && costarList.indexOf(costar) == -1)
                        {
                            costarList.add(costar);
                        }
                    }
                    baconMovies.write("\n");
                }
            }
        }

        for (String costar : costarList)
        {
            baconCostars.write(costar + "\n");
        }
        baconMovies.close();
        baconCostars.close();
    } catch (
    IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void createLevels(ArrayList<SimpleMovie> movies, ArrayList<String> baconCostars) {
        baconNumber++;
        ArrayList<SimpleMovie> baconCostarMovies = new ArrayList<SimpleMovie>();
        for (SimpleMovie movie : movies)
        {
            for (String actor : baconCostars)
            {
                if (movie.getActors().contains(actor) && baconCostarMovies.indexOf(movie) == -1)
                {
                        baconCostarMovies.add(movie);
                }
            }
        }

        try {
            FileWriter baconCMovies = new FileWriter("src/bacon_movies" + baconNumber);
            FileWriter baconCMCostars = new FileWriter("src/bacon_costars" + baconNumber);
            ArrayList<String> costarList = new ArrayList<String>();
            for (SimpleMovie movie : baconCostarMovies)
            {
                ArrayList<String> cast = movie.getActors();
                baconCMovies.write(movie.getTitle() + "---");
                for (String costar : movie.getActors())
                {
                    baconCMovies.write(costar + ":");
                    if (!costar.equals("Kevin Bacon") && costarList.indexOf(costar) == -1)
                    {
                            costarList.add(costar);
                    }
                }
                baconCMovies.write("\n");
            }

            for (String costar : costarList)
            {
                baconCMCostars.write(costar + "\n");
            }
            baconCMovies.close();
            baconCMCostars.close();
        } catch (
                IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void createActorMovies(ArrayList<SimpleMovie> movies, String actorName) {
        try {
            FileWriter actorMovies = new FileWriter("src/actor_movies");
            FileWriter actorCostars = new FileWriter("src/actor_costars");
            ArrayList<String> costarList = new ArrayList<String>();
            baconNumber++;
            for (SimpleMovie movie : movies)
            {
                ArrayList<String> cast = movie.getActors();
                for (String actor : cast)
                {
                    if (actor.equalsIgnoreCase(actorName))
                    {
                        actorMovies.write(movie.getTitle() + "---");
                        for (String costar : movie.getActors())
                        {
                            actorMovies.write(costar + ":");
                            if (!costar.equals(actorName) || costarList.indexOf(costar) == -1)
                            {
                                costarList.add(costar);
                            }
                        }
                        actorMovies.write("\n");
                    }
                }
            }
            for (String costar : costarList)
            {
                actorCostars.write(costar + "\n");
            }
            actorMovies.close();
            actorCostars.close();
        } catch (
                IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
