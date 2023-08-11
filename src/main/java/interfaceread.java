

import java.io.*;
import java.sql.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.logging.Logger;

import java.util.Properties;

public class interfaceread {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Logger logger = Logger.getLogger(interfaceread.class.getName());
        Properties props = new Properties();
        try (InputStream in = new FileInputStream("db.properties")) {
            props.load(in);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        connection conn = new connection();
        Connection con = conn.connection();

        if(con!=null)
        {
            logger.info("Connection OK");

        }
        else {
            logger.info("Connection failed");

        }

        Statement st=con.createStatement();

        ResultSet rs=st.executeQuery("select * from people where age>25;");
        while(rs.next())
        {
            System.out.println(rs.getInt("sno")+" "+rs.getString("name")+" "+rs.getInt("age"));
        }

        String fileName = args[0];
        String fileType = args[1];

        SwitchClass s = new SwitchClass();
        s.switchMethod(fileType, fileName, con);


        st.close();
        con.close();
    }

}
