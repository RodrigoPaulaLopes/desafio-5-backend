package br.com.banco.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertDate {

    public static LocalDate convert(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate newDate = LocalDate.parse(date, formatter);

        return newDate;
    }

}
