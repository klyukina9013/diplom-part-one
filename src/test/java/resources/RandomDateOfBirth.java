package resources;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomDateOfBirth {

    public static String randomBirthday() {
        LocalDate currentDate = LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 10))));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedCurrentDate = currentDate.format(formatter);
        return formattedCurrentDate;
    }

    public static void main(String[] args) {
        System.out.println("randomDate: " + randomBirthday());
    }

}
