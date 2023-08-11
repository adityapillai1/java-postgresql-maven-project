import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class SwitchTest {
    @Test
    public void testSwitchMethodWithValidFileType() {
        // create a mock connection object
        Connection con = mock(Connection.class);
        // create an instance of the switch class
        SwitchClass sc = new SwitchClass();
        // call the switch method with a valid file type and name
        boolean result = sc.switchMethod("csv", "test.csv", con);
        // assert that the result is true
        assertTrue(result);
    }

    @Test
    public void testSwitchMethodWithInvalidFileType() {
        // create a mock connection object
        Connection con = mock(Connection.class);
        // create an instance of the switch class
        SwitchClass sc = new SwitchClass();
        // call the switch method with an invalid file type and name
        boolean result = sc.switchMethod("txt", "test.txt", con);
        // assert that the result is false
        assertFalse(result);
    }
}

