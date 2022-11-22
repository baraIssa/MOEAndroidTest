package utils.Reading_Helper;


import utils.PropReader;
import utils.error_handlers.Logger;

public class implicitTimeReader {

    public static final String TIME = "time";

    public static long readTime()  {

        try{

            return Long.parseLong( PropReader.readConfig(TIME));
        }
        catch( NumberFormatException | IllegalStateException e)
        {
            Logger.info(e.getMessage());
            throw new RuntimeException();

        }
    }
}
