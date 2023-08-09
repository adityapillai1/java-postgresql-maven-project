import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest {
    @Test
    public void compare() throws SQLException, ClassNotFoundException {
        connection test = new connection();
        Connection value = test.connection();
        //assertTrue(test instanceof connection);
        assertNotNull(value);
    }
}
