package de.schulz.exercise.timeformatter.model;

public class TextualTimeEN {

    public static String asTime(int hours, int minutes, int accuracy, String timeOfDay) {
        // runden und neu zuweisen
        int rest = minutes / accuracy;
        minutes = rest * accuracy;

        String minutesText = minutesAsText(minutes);
        String hoursText = hoursAsText(hours, minutes, timeOfDay);


        if (minutesText == null || hoursText == null) {
            return "wrong format!";
        }

        String timeAsString = "It is " + minutesText + " " + hoursText;

        return timeAsString;
    }

    static String minutesAsText(int minutes) {
        switch (minutes) {
            case 0:
                return "o'clock";
            case 5:
                return "five past";
            case 10:
                return "ten past";
            case 15:
                return "quarter past";
            case 20:
                return "twenty past";
            case 25:
                return "five to half past";
            case 30:
                return "half past";
            case 35:
                return "five past half";
            case 40:
                return "twenty to";
            case 45:
                return "quarter to";
            case 50:
                return "ten to";
            case 55:
                return "five to";
            default:
                return null;
        }
    }

    static String hoursAsText(int hours, int minutes, String timeOfDay) {
        // ab 20 nach (minuten) nennt man die neue stunde
        if (minutes > 20) {
            hours = hours + 1;
            if (24 == hours) {
                hours = 0;
            }
        }

        // auf 0-12 Stundenformat "kürzen"
        if (hours > 12) {
            hours = hours - 12;
        }

        switch (hours) {
            case 0:
                return "twelve " + timeOfDay;
            case 1:
                return "one " + timeOfDay;
            case 2:
                return "two " + timeOfDay;
            case 3:
                return "three " + timeOfDay;
            case 4:
                return "four " + timeOfDay;
            case 5:
                return "five " + timeOfDay;
            case 6:
                return "six " + timeOfDay;
            case 7:
                return "seven " + timeOfDay;
            case 8:
                return "eight " + timeOfDay;
            case 9:
                return "nine " + timeOfDay;
            case 10:
                return "ten " + timeOfDay;
            case 11:
                return "eleven " + timeOfDay;
            case 12:
                return "twelve " + timeOfDay;
            default:
                return null;
        }
    }
}
