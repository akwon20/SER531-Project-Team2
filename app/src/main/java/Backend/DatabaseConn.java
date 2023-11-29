package Backend;

import com.complexible.common.rdf.query.resultio.TextTableQueryResultWriter;
import com.complexible.stardog.StardogException;
import com.complexible.stardog.api.*;
import com.stardog.stark.query.SelectQueryResult;
import com.stardog.stark.query.io.QueryResultWriters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DatabaseConn {

    private static final String url = "https://sd-f08b11ca.stardog.cloud:5820";
    private static final String username = "test";
    private static final String password = "test1234567890";
    private static final String to = "test123";

    private static final int maxPool = 200;
    private static final int minPool = 10;
    private static final boolean reasoningType = false;

    private static final long blockCapacityTime = 900;
    private static final TimeUnit blockCapacityTimeUnit = TimeUnit.SECONDS;
    private static final long expirationTime = 300;
    private static final TimeUnit expirationTimeUnit = TimeUnit.SECONDS;

    static ConnectionPool connectionPool;

    public DatabaseConn() {


        ConnectionConfiguration connectionConfig = ConnectionConfiguration
                .to(to)
                .server(url)
                .reasoning(reasoningType)
                .credentials(username, password);

        // creates the Stardog connection pool
        connectionPool = createConnectionPool(connectionConfig);

    }

    public void executeQuery(String queryString) {

        Connection connection = getConnection(connectionPool);

        try (connection) {
            // start the connection to the database
            connection.begin();

            // Query the database to get our list patients with Age 55  and print the results to the console
            SelectQuery query = connection.select(queryString);
            SelectQueryResult tupleQueryResult = query.execute();
            QueryResultWriters.write(tupleQueryResult, System.out, TextTableQueryResultWriter.FORMAT);

        } catch (StardogException | IOException e) {
            e.printStackTrace();
        } finally {
            releaseConnection(connectionPool, connection);
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
