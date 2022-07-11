import java.text.ParseException;
import java.time.ZoneId;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class Main {
    //Calculate difference and format miliseconds into days
    public static void calculateDiff(Date dateToday,Date birthdayFormat) {
        long diff = dateToday.getTime() - birthdayFormat.getTime();
        TimeUnit time = TimeUnit.DAYS;
        long diffFormatted = time.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("You've been living " + diffFormatted + " days!");
    }
    //Handle the strings/dates
    public static void datesHandler(String birthday) throws ParseException {
        LocalDate today = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
        Date birthdayFormatted = sdf.parse(birthday);
        Date dateToday = Date.from(today.atStartOfDay(defaultZoneId).toInstant());
        calculateDiff(dateToday, birthdayFormatted);
    }
    //Read date, get today's date and format variables
    public static String getBDAY() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your birthday yyyy/mm/dd:");
        String birthday = input.nextLine();
        return birthday;
    }
    public static void main(String[] args) throws ParseException {
        String userBirthday = getBDAY();
        datesHandler(userBirthday);
    }
}