import java.io.*;
import java.sql.*;
import java.util.Properties;


public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Properties props = new Properties();
        try (InputStream in = new FileInputStream("db.properties")) {
            props.load(in);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String csvFile = "C:\\Users\\aditya.pillai\\IdeaProjects\\jdbctest\\book1.csv";
        String usern = props.getProperty("db.username");
        String passw = props.getProperty("db.password");
        String dbURL= props.getProperty("db.dbURL");

        Class.forName("org.postgresql.Driver");

        Connection con=DriverManager.getConnection(dbURL,usern,passw);

        if(con!=null)
        {
            System.out.println("Connection OK");
        }
        else {
            System.out.println("Connection Failed");
        }

        Statement st=con.createStatement();
        //String InsertSql = "insert into people values(2,'Cd',23);";
        //st.executeUpdate(InsertSql);

        //String CopySql = "\\copy people FROM 'C:\\Users\\aditya.pillai\\IdeaProjects\\jdbctest\\book1.csv' DELIMITER ',' CSV HEADER;";
        //st.executeUpdate(CopySql);



        ResultSet rs=st.executeQuery("select * from people where age>25;");
        while(rs.next())
        {
            System.out.println(rs.getInt("sno")+" "+rs.getString("name")+" "+rs.getInt("age"));
        }

//        try (Connection conn = DriverManager.getConnection(dbURL, usern, passw);
//             BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
//
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(",");
//                int sno = Integer.parseInt(values[0]);
//                String name = values[1];
//                int age = Integer.parseInt(values[2]);
//
//                String sql = "INSERT INTO people (sno, name, age) VALUES (?, ?, ?)";
//                PreparedStatement statement = conn.prepareStatement(sql);
//                statement.setInt(1, sno);
//                statement.setString(2, name);
//                statement.setInt(3, age);
//
//                int rowsInserted = statement.executeUpdate();
//                if (rowsInserted > 0) {
//                    System.out.println("A new row was inserted successfully!");
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());
//        }

        st.close();
        con.close();
    }
}