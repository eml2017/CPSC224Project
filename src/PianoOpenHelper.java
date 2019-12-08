import java.sql.*;

public class PianoOpenHelper {
    // Database name
    static final String DATABASE_NAME = "databasePiano.db";
    // Connection URL (like a command to open a file)
    static final String CONNECTION_URL = "jdbc:sqlite:databases/" + DATABASE_NAME;
    Connection connection;
    // Attribute names
    static final String TABLE_OCTAVE = "tableOctave";
    static final String OCTAVE = "octave";

    public PianoOpenHelper() {
        getConnection();
        if (tableExists() == false) {
            createOctaveTable();
        }
    }

    public void getConnection() {
        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
            System.out.println("Successfully connected to the database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createOctaveTable() {
        String sqlCreate = "CREATE TABLE " + TABLE_OCTAVE + "(" +
                OCTAVE + " INTEGER)";
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlCreate);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        insertOctave(4);
    }

    public void insertOctave(int octave) {
        String sqlInsert = "INSERT INTO " + TABLE_OCTAVE + " VALUES(" + octave + ")";
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlInsert);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int getOctave() {
        int storedOctave = 4;
        String sqlSelect = "SELECT " + OCTAVE + " FROM " + TABLE_OCTAVE;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()) {
                storedOctave = resultSet.getInt(OCTAVE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return storedOctave;
    }

    public void updateOctave(int octave) {
        String sqlUpdate = "UPDATE " + TABLE_OCTAVE + " SET " +
                OCTAVE + "='" + octave + "'";
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                statement.execute(sqlUpdate);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean tableExists() {
        // See sources
        DatabaseMetaData md = null;
        boolean hasNext = false;
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