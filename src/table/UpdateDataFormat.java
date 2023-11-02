package table;

import java.util.ArrayList;

public class UpdateDataFormat {
    final String FULL_DATE_AND_TIME1 = "dd/MM/yyyy HH:mm:ss";
    final String FULL_DATE_AND_TIME2 = "yyyy-MM-dd H";
    final String FULL_DATE_AND_TIME3 = "yyyy|MM|dd HH-mm";
    private String formatInMoment = FULL_DATE_AND_TIME1;

    public String getFormatInMoment() {
        return formatInMoment;
    }

    private final ArrayList<String> dateFormats = new ArrayList<>() {{
        add(FULL_DATE_AND_TIME1);
        add(FULL_DATE_AND_TIME2);
        add(FULL_DATE_AND_TIME3);
    }};

    public ArrayList<String> getDateFormats() {
        return dateFormats;
    }

    public void addNewFormat(String newFormat) {
        dateFormats.add(newFormat);
        formatInMoment = newFormat;
    }

    public void setFormatInMoment(int number) {
        if (number - 1 > dateFormats.size()) {
            formatInMoment = FULL_DATE_AND_TIME1;
        } else {
            formatInMoment = dateFormats.get(number - 1);
        }
    }

}
