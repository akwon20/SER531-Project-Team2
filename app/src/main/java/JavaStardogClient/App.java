package JavaStardogClient;

import Frontend.AppFrame;

import com.complexible.common.rdf.query.resultio.TextTableQueryResultWriter;
import com.complexible.stardog.StardogException;
import com.complexible.stardog.api.*;
import com.stardog.stark.query.SelectQueryResult;
import com.stardog.stark.query.io.QueryResultWriters;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class App {
    private static final String url = "https://sd-f08b11ca.stardog.cloud:5820";
    private static final String username = "test";
    private static final String password = "test1234567890";
    private static final String to = "test123";

    private static int maxPool = 200;
    private static int minPool = 10;
    private static boolean reasoningType = false;

    private static long blockCapacityTime = 900;
    private static TimeUnit blockCapacityTimeUnit = TimeUnit.SECONDS;
    private static long expirationTime = 300;
    private static TimeUnit expirationTimeUnit = TimeUnit.SECONDS;

    private static final String NS = "http://api.stardog.com/";

    public static void main(String[] args) {
        AppFrame testFrame = new AppFrame();
        
        testFrame.setVisible(true);
        
        ConnectionConfiguration connectionConfig = ConnectionConfiguration
                .to(to)
                .server(url)
                .reasoning(reasoningType)
                .credentials(username, password);

        // creates the Stardog connection pool
        ConnectionPool connectionPool = createConnectionPool(connectionConfig);

        try (Connection connection = getConnection(connectionPool)) {
            // start the connection to the database
            connection.begin();
            String queryString =
                    "SELECT DISTINCT ?subject_0 " +
                            "FROM <tag:stardog:api:context:default> " +
                            "WHERE { " +
                            "  { " +
                            "    ?subject_0 a <http://www.semanticweb.org/healthcare#Patients> . " +
                            "    ?subject_0 <http://www.semanticweb.org/healthcare#hasAge> ?dat_0 . " +
                            "    FILTER(STR(?dat_0) = \"55\") . " +
                            "  } " +
                            "}";
            // Query the database to get our list patients with Age 55  and print the results to the console
            SelectQuery query = connection.select(queryString);
            SelectQueryResult tupleQueryResult = query.execute();
            QueryResultWriters.write(tupleQueryResult, System.out, TextTableQueryResultWriter.FORMAT);

        } catch (StardogException | IOException e) {
            e.printStackTrace();
        } finally {
            connectionPool.shutdown();
        }
    }


    /**
     *  Now we want to create the configuration for our pool.
     * @param connectionConfig the configuration for the connection pool
     * @return the newly created pool which we will use to get our Connections
     */
    private static ConnectionPool createConnectionPool(ConnectionConfiguration connectionConfig) {
        ConnectionPoolConfig poolConfig = ConnectionPoolConfig
                .using(connectionConfig)
                .minPool(minPool)
                .maxPool(maxPool)
                .expiration(expirationTime, expirationTimeUnit)
                .blockAtCapacity(blockCapacityTime, blockCapacityTimeUnit);

        return poolConfig.create();
    }

    /**
     * Obtains the Stardog connection from the connection pool
     * @param connectionPool the connection pool to get our connection
     * @return Stardog Connection
     */
    public static Connection getConnection(ConnectionPool connectionPool) {
        return connectionPool.obtain();
    }

    /**
     * Releases the Stardog connection from the connection pool
     * @param connection Stardog Connection
     */
    public static void releaseConnection(ConnectionPool connectionPool, Connection connection) {
        try {
            connectionPool.release(connection);
        } catch (StardogException e) {
            e.printStackTrace();
        }
    }
}
