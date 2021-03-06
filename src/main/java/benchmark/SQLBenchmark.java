package benchmark;

import mappers.SQLMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mato on 24.5.17.
 */
public class SQLBenchmark
{

    SQLMapper sql = new SQLMapper();
    List<Integer> timeMeasures = new ArrayList<>();

    public SQLBenchmark() throws ClassNotFoundException {
    }


    public void q1(ArrayList<String> cities) throws Exception {
        long average=0;
        for (String city: cities) {
            long startTime = System.currentTimeMillis(); // Start timing:
            sql.getBookByCity(city);
            long endTime = System.currentTimeMillis(); // End timing
            long duration = (endTime - startTime);
            timeMeasures.add((int) duration);
            average += duration;
            System.out.println("Execution time was: " + duration + "ms.");

        }
        System.out.println("Avg. execution time was: " + (average / cities.size()) + "ms.");
    }



    public void q2(ArrayList<String> titles) throws Exception {
        long average=0;
        for (String title: titles) {
            long startTime = System.currentTimeMillis(); // Start timing:
            sql.getMentionedCitiesByBook(title);
            long endTime = System.currentTimeMillis(); // End timing
            long duration = (endTime - startTime);
            timeMeasures.add((int) duration);
            average += duration;
            System.out.println("Execution time was: " + duration + "ms.");

        }
        System.out.println("Avg. execution time was: " + (average / titles.size()) + "ms.");
    }



    public void q3(ArrayList<String> authors) throws SQLException {
        long average=0;
        for (String author: authors) {
            long startTime = System.currentTimeMillis(); // Start timing:
            sql.getMentionedCitiesByAuthor(author);
            long endTime = System.currentTimeMillis(); // End timing
            long duration = (endTime - startTime);
            timeMeasures.add((int) duration);
            average += duration;
            System.out.println("Execution time was: " + duration + "ms.");

        }
        System.out.println("Avg. execution time was: " + (average / authors.size()) + "ms.");
    }

    public void q4(ArrayList<Coordinate> coordinates) throws SQLException {
        long average=0;
        for (Coordinate coordinate: coordinates) {
            long startTime = System.currentTimeMillis(); // Start timing:
            sql.getAllBooksByCity(coordinate.getLatitude(),coordinate.getLongitude());
            long endTime = System.currentTimeMillis(); // End timing
            long duration = (endTime - startTime);
            timeMeasures.add((int) duration);
            average += duration;
            System.out.println("Execution time was: " + duration + "ms.");

        }
        System.out.println("Avg. execution time was: " + (average / coordinates.size()) + "ms.");
    }

    }