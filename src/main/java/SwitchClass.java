import java.sql.Connection;
import java.util.logging.Logger;

public class SwitchClass {
    public boolean switchMethod(String fileType, String fileName, Connection con){
        Logger logger = Logger.getLogger(SwitchClass.class.getName());
        boolean valid = true;
        // use switch statement to call the required method based on the file type
        switch (fileType) {
            case "csv":
                CSVFileReader csv = new CSVFileReader();
                csv.reader(fileName, con);
                break;
            case "json":
                JSONFileReader json = new JSONFileReader();
                json.reader(fileName, con);
                break;
            default:
                logger.info("Invalid file type");
                valid = false;
                break;
        }
        return valid;
    }
}
