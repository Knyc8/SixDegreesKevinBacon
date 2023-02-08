import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data (1)");
        for (SimpleMovie movie : movies) {
            System.out.println(movie);
        }
        System.out.println("Number of movies: " + movies.size());

        try {
            FileWriter myWriter = new FileWriter("src/bacon_costars");
            for (SimpleMovie movie : movies)
            {
                ArrayList<String> cast = movie.getActors();
                for (String actor : cast)
                {
                    if (actor.equalsIgnoreCase("Kevin Bacon"))
                    {
                        myWriter.write(movie.getTitle() + "---");
                        for (String costar : movie.getActors())
                        {
                            myWriter.write(costar + ":");
                        }
                        myWriter.write("\n");
                    }
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}