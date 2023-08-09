import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

// implement the interface in a class that provides the logic for reading CSV file type

class CSVFileReader implements Reader {


    public List<String[]> reader(String fileName, Connection con) {
        Logger logger = Logger.getLogger(interfaceread.class.getName());
        // use java.io.BufferedReader to read csv file
        String csvFile = "src\\main\\resources\\"+fileName+".csv";
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(csvFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
                int sno = Integer.parseInt(values[0]);
                String name = values[1];
                int age = Integer.parseInt(values[2]);

                String sql = "INSERT INTO people (sno, name, age) VALUES (?, ?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, sno);
                statement.setString(2, name);
                statement.setInt(3, age);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    logger.info("A new row was inserted successfully!");

                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return data;

    }

}
