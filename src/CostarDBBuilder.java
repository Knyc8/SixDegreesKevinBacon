import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CostarDBBuilder {
    private static int baconNumber = 0;
    //creates a new file of the actors that have worked with Bacon
    public static void createLevel1(ArrayList<SimpleMovie> movies) {
        try {
        FileWriter baconMovies = new FileWriter("src/bacon_costars");
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
                    }
                    baconMovies.write("\n");
                }
            }
        }
        baconMovies.close();
        System.out.println("Successfully wrote to the file.");
    } catch (
    IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String searchActor(String actorName, ArrayList<SimpleMovie> baconMovies)
    {
        String baconLevel = "";
        for (SimpleMovie movie : baconMovies)
        {
            for (String actor : movie.getActors())
            {
                boolean sameActor = actor.equalsIgnoreCase(actorName);
                if (sameActor == true)
                {
                    baconLevel = actorName + " --> " + movie.getTitle() + " --> Kevin Bacon | Bacon Number: " + baconNumber;
                    break;
                }
                else
                {
                    baconLevel = "There is no such actor that Bacon has played with.";
                }
            }
        }
        return baconLevel;
    }
}
