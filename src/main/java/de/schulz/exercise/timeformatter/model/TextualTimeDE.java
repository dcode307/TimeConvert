package de.schulz.exercise.timeformatter.model;

public class TextualTimeDE {

    public static String asTime(int hours, int minutes, int accuracy) {
        // runden und neu zuweisen
        int rest = minutes / accuracy;
        minutes = rest * accuracy;

        String minutesText = minutesAsText(minutes);
        String hoursText = hoursAsText(hours, minutes);

        if (minutesText == null || hoursText == null) {
            return "falsches format!";
        }

        String timeAsString = "Es ist " + minutesText + " " + hoursText;
        return timeAsString;
    }

    static String minutesAsText(int minutes) {
        switch (minutes) {
            case 0:
                return "";
            case 5:
                return "fünf nach";
            case 10:
                return "zehn nach";
            case 15:
                return "viertel nach";
            case 20:
                return "zwanzig nach";
            case 25:
                return "fünf vor halb";
            case 30:
                return "halb";
            case 35:
                return "fünf nach halb";
            case 40:
                return "zwanzig vor";
            case 45:
                return "viertel vor";
            case 50:
                return "zehn vor";
            case 55:
                return "fünf vor";
            default:
                return null;
        }
    }

    static String hoursAsText(int hours, int minutes) {
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
                return "zwölf";
            case 1:
                return "eins";
            case 2:
                return "zwei";
            case 3:
                return "drei";
            case 4:
                return "vier";
            case 5:
                return "fünf";
            case 6:
                return "sechs";
            case 7:
                return "sieben";
            case 8:
                return "acht";
            case 9:
                return "neun";
            case 10:
                return "zehn";
            case 11:
                return "elf";
            case 12:
                return "zwölf";
            default:
                return null;
        }
    }
}
