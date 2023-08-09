import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// use this annotation to enable Mockito annotations
@RunWith(MockitoJUnitRunner.class)
public class CsvTest {

    // create a mock object of connection class
    @Mock
    Connection mockConnection;

    @Test
    public void testReader() throws Exception {

            // create a mock object of PreparedStatement class
            PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
            // stub the prepareStatement method to return the mock PreparedStatement object
            when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
            // stub the executeUpdate method to return 1
            when(mockPreparedStatement.executeUpdate()).thenReturn(1);
            // use the mock objects in your test
            CSVFileReader csvFileReader = new CSVFileReader();
            List<String[]> res= csvFileReader.reader("testDemo", mockConnection);
            List<String[]> expectedData = new ArrayList<>();
            String[] dataRow = {
            "1", "A", "22"
            };
            expectedData.add(dataRow);
            // check if res and expectedData are not null
            assertNotNull(res);
            assertNotNull(expectedData);
            assertEquals(expectedData.size(), res.size());
            for (int i = 0; i < expectedData.size(); i++) {
            assertArrayEquals(expectedData.get(i), res.get(i));
            }
        }

    }
