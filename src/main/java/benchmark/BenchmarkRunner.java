package benchmark;

import mappers.Neo4jMapper;

import java.util.ArrayList;

/**
 * Created by Mato on 24.5.17.
 */
public class BenchmarkRunner {

    private static ArrayList<String> cities = new ArrayList<>();
    private static ArrayList<String> titles = new ArrayList<>();
    private static ArrayList<String> authors = new ArrayList<>();
    private static ArrayList<Coordinate> coordinates = new ArrayList<>();



    public static void main(String[] args) throws Exception {
        setUp();
        Neo4jBenchmark neo = new Neo4jBenchmark();
        SQLBenchmark sql = new SQLBenchmark();

        System.out.println("------------------1--------------");
        neo.q1(cities);
        sql.q1(cities);

        System.out.println("------------------2--------------");
        neo.q2(titles);
        sql.q2(titles);

        System.out.println("------------------3--------------");
        neo.q3(authors);
        sql.q3(authors);

        System.out.println("------------------4--------------");
        neo.q4(coordinates);
        sql.q4(coordinates);

    }

    private static void setUp()
    {
        cities.add("London");
        cities.add("Bratislava");
        cities.add("Paris");
        cities.add("Dubai");
        cities.add("Bucharest");

        titles.add("The Warriors");
        titles.add("The Mystery");
        titles.add("The Magna Carta");
        titles.add("Gaslight Sonatas");
        titles.add("The Tripple Alliance");

        authors.add("Ada Leverson");
        authors.add("Various");
        authors.add("Harold Avery");
        authors.add("Edgar Allan Poe");
        authors.add("Charles A Lee");

        coordinates.add(new Coordinate(57.048,9.9187));
        coordinates.add(new Coordinate(5.10658,7.36667));
        coordinates.add(new Coordinate(-19.16,-45.44583));
        coordinates.add(new Coordinate(6.32485,8.11368));
        coordinates.add(new Coordinate(50.1,1.83333));

    }

}
