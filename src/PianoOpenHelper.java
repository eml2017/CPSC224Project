/**
 * This program handles the logic for the database. This database creates a table, inserts an
 *      octave integer value into it, updates it as the user moves the slider, and uses a query
 *      to retrieve the recorded value. This database also drops the table if it already exists
 *      to avoid exceptions.
 *
 * @author John Hyde and Elizabeth Larson
 * @see http://www.java2s.com/Code/Java/Database-SQL-JDBC/Detectifatableexists.htm, Java2S, dropping the table if it has already been created
 */

import java.sql.*;

public class PianoOpenHelper {
    /** DATABASE_NAME - the name of the database that stores the octave information */
    static final String DATABASE_NAME = "databasePiano.db";
    /** CONNECTION_URL - the URL of the connection to the database */
    static final String CONNECTION_URL = "jdbc:sqlite:databases/" + DATABASE_NAME;
    /** connection - the connection to the database */
    Connection connection;
    /** TABLE_OCTAVE - the name of the table that stores octave information */
    static final String TABLE_OCTAVE = "tableOctave";
    /** OCTAVE - the name of the octave attribute */
    static final String OCTAVE = "octave";

    /**
     * Constructor for the PianoOpenHelper
     * Gets a connection to the database and attempts to create a table
     * If the table already exists, don't try to create it
     *
     * @see	"No Borrowed Code"
     */
    public PianoOpenHelper() {
        getConnection();
        // If the table already exists, don't try to create it again
        if (tableExists() == false) {
            createOctaveTable();
        }
    }

    /**
     * Attempts to create a connection to the database
     *
     * @see "No Borrowed Code"
     */
    public void getConnection() {
        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Uses an SQL create statement to create a table
     * This table will store one record: an integer representation of the piano octave
     *
     * @see "No Borrowed Code"
     */
    public void createOctaveTable() {
        // CREATE TABLE tableOctave (octave INTEGER)
        String sqlCreate = "CREATE TABLE " + TABLE_OCTAVE + "(" +
                OCTAVE + " INTEGER)";
        // Try to execute the create statement if the connection is there
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlCreate);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // Because this is a new table, immediately add a new octave value
        // Start the octave slider at 4... the "middle" of the piano
        insertOctave(4);
    }

    /**
     * Use an SQL insert statement to insert an octave value into the database
     *
     * @param octave integer representation of the octave value being stored
     * @see "No Borrowed Code"
     */
    public void insertOctave(int octave) {
        // INSERT INTO tableOctave VALUES(<octave>)
        String sqlInsert = "INSERT INTO " + TABLE_OCTAVE + " VALUES(" + octave + ")";
        // Try to execute the insert statement if the connection is there
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlInsert);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Uses a simple SQL query to retrieve the octave value from the database
     * Store this in an integer value
     *
     * @return the most recent octave to be stored in the database
     * @see "No Borrowed Code"
     */
    public int getOctave() {
        // If there are no records in the database yet, return 4 (4th octave on the piano)
        int storedOctave = 4;
        // SELECT octave FROM tableOctave
        String sqlSelect = "SELECT " + OCTAVE + " FROM " + TABLE_OCTAVE;
        // Try to execute the query if the connection is there
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            // Look through the query's result set and fetch the integer in the octave attribute
            while (resultSet.next()) {
                storedOctave = resultSet.getInt(OCTAVE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return storedOctave;
    }

    /**
     * Use an SQL update statement to change the value of the octave record to a new passed-in integer
     *
     * @param octave integer representation of the octave value being stored
     * @see "No Borrowed Code"
     */
    public void updateOctave(int octave) {
        // UPDATE tableOctave SET octave=<octave>
        String sqlUpdate = "UPDATE " + TABLE_OCTAVE + " SET " +
                OCTAVE + "='" + octave + "'";
        // Try to execute the update statement if the connection is there
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlUpdate);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Checks if a certain table already exists within a database
     * Returns true if so
     *
     * @return if the table already exists or not
     * @see "http://www.java2s.com/Code/Java/Database-SQL-JDBC/Detectifatableexists.htm, Java2S, dropping the table if it has already been created"
     */
    private boolean tableExists() {
        DatabaseMetaData md = null;
        boolean hasNext = false;
        // Try to look through the database until a specific table is found
        try {
            md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, TABLE_OCTAVE, null);
            hasNext = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasNext;
    }
}