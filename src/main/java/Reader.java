import java.sql.Connection;
import java.util.List;

public interface Reader {
    List<String[]> reader(String fileName, Connection con);
}
