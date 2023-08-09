import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



class JSONFileReader implements Reader {
    public List<String[]> reader(String fileName, Connection con) {
        Logger logger = Logger.getLogger(interfaceread.class.getName());
        // use java.io.InputStreamReader to read json file
        System.out.println("JSON");
        String jsonFile = "src\\main\\resources\\"+fileName+".json";
        System.out.println(jsonFile);

        List<String[]> data = new ArrayList<>();
        // create a JSONParser object
        JSONParser parser = new JSONParser();
        // parse the json file and put it in a JSONArray
        JSONArray array = null;
        try {
            array = (JSONArray) parser.parse(new FileReader(jsonFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // iterate over the array elements
        for (Object obj : array) {
            JSONObject json = (JSONObject) obj;

            int sno = ((Long) json.get("sno")).intValue();
            String name = (String) json.get("name");
            int age = ((Long) json.get("age")).intValue();

            String[] values = new String[]{
                    "1",
                    "B",
                    "22"
            };
            data.add(values);

            String sql = "INSERT INTO people (sno, name, age) VALUES (?, ?, ?)";
            PreparedStatement statement = null;
            try {
                statement = con.prepareStatement(sql);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                statement.setInt(1, sno);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                statement.setString(2, name);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                statement.setInt(3, age);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            int rowsInserted = 0;
            try {
                rowsInserted = statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (rowsInserted > 0) {
                logger.info("A new row was inserted successfully!");
            }
        }

        return data;

    }
}
