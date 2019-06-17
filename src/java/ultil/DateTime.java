
package ultil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    public static String getDateTimeNow()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
        Date d = new Date();
        return sdf.format(d);
    }
}
