package AppointmentSystem.Utilities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.*;

/**
 * @author josealvarezpulido
 * A utility class used to convert and create ZonedDateTime Objects. Usually used when extracting dates and times from SQL database.
 */
public class TimeUtil
{
    /**
     * it merges LocalDate and LocalTime or converts localDateTime into ZonedDateTime using the Zoned ID of eastern time, that is where the appointment times are based on.
     * This method with 2 params is used to merge.
     * @param date
     * @param time
     * @return dateTimeZone local variable result from merging the LocalDate and LocalTime with the Zone ID of America New York.
     */
    public static ZonedDateTime mergeDateTime(LocalDate date, LocalTime time){
    LocalDateTime dateTime= LocalDateTime.of(date,time);
    ZoneId zoneId = ZoneId.of("America/New_York");
    ZonedDateTime dateTimeZone = ZonedDateTime.of(dateTime,zoneId);
    return dateTimeZone;
    }
    /**
     * it merges LocalDate and LocalTime or converts localDateTime into ZonedDateTime using the Zoned ID of eastern time, that is where the appointment times are based on.
     * This method with 1 params is used to convert.
     * @param localDateTime
     * @return dateTimeZone local variable result from Converting the LocalDateTime with the Zone ID of America New York.
     */
    public static ZonedDateTime mergeDateTime(LocalDateTime localDateTime)
    {
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime dateTimeZone = ZonedDateTime.of(localDateTime,zoneId);
        return dateTimeZone;
    }

    /**
     * returns an observable list of LocalTime(s) incrementing by user selected increment in minutes from the start to end time, the end time must be one increment over the intended end time.
     * @param start
     * @param end
     * @param increment
     * @return
     */
    public static ObservableList<LocalTime> getTimes(LocalTime start, LocalTime end, int increment){
        ObservableList<LocalTime>  openHours = FXCollections.observableArrayList();
        if(start.isBefore(end)){
            while(start.isBefore(end)){
                openHours.add(start);
                start = start.plusMinutes(increment);
            }
            return openHours;
        }
        else return null;
    }

}
