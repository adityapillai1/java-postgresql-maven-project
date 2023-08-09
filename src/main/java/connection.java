import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connection {
    public Connection connection() throws ClassNotFoundException, SQLException {
        Properties props = new Properties();
        try (InputStream in = new FileInputStream("db.properties")) {
            props.load(in);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String dbURL = props.getProperty("db.dbURL");
        String usern = props.getProperty("db.username");
        String passw = props.getProperty("db.password");

        Class.forName("org.postgresql.Driver");

        Connection con=DriverManager.getConnection(dbURL,usern,passw);

        return con;
    }

}
