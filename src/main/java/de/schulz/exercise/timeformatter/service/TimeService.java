package de.schulz.exercise.timeformatter.service;

import de.schulz.exercise.timeformatter.model.TextualTimeDE;
import de.schulz.exercise.timeformatter.model.TextualTimeEN;
import de.schulz.exercise.timeformatter.model.Time;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    public String convertTimeIntoLanguage(Time time) {
        String tageszeit = "";

        String timeString = time.getTime();
        int accuracy = time.getAccuracy();

        // check if string contains english format (am/pm) then change locale to "EN" and remove am/pm
        if (timeString.contains("am")) {
            time.setLocale("EN");
            timeString = timeString.replace("am", "");
            tageszeit = "am";
        }
        if (timeString.contains("pm")) {
            time.setLocale("EN");
            timeString = timeString.replace("pm", "");
            tageszeit = "pm";
        }

        // extract hours and minutes
        String[] timeElements = timeString.split(":");
        int hh = Integer.parseInt(timeElements[0]);
        int mm = Integer.parseInt(timeElements[1]);

        if (time.getLocale().equals("DE")) {
            return TextualTimeDE.asTime(hh, mm, accuracy);
        } else {
            return TextualTimeEN.asTime(hh, mm, accuracy, tageszeit);
        }
    }

}
