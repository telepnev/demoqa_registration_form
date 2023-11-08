package data;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FormPageHelper {
    private Faker faker = new Faker();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String email = faker.internet().emailAddress();
    private String incorrectEmails = faker.internet().emailAddress().replace(".", "");
    private String mobilePhone = faker.phoneNumber().subscriberNumber(10);
    private String currentAddress = faker.address().fullAddress();

    public String getIncorrectEmails() {
        return incorrectEmails;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public Faker getFaker() {
        return faker;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }


    public String getRandomGender() {
        final Random random = new Random();
        List<String> str = new ArrayList<>(List.of("Male", "Female", "Other"));
        int i = random.nextInt(0, 2);
        return str.get(i);
    }

    public String getRandomHobbies() {
        final Random random = new Random();
        List<String> str = new ArrayList<>(List.of("Sports", "Reading", "Music"));
        int i = random.nextInt(0, 2);
        return str.get(i);
    }

    public String setRandomMonth() {
        final Random random = new Random();
        int i = random.nextInt(0, 11);
        String month = Integer.toString(i);
        return month;
    }

    public String getMonth(String indexMonth) {
        List<String> str = new ArrayList<>(List.of("January", "February", "March",
                "April", "May", "June", "July", "August", "September",
                "October", "November", "December"));
        int num = Integer.parseInt(indexMonth);
        return str.get(num);
    }

    public String setRandomYear() {
        final Random random = new Random();
        int i = random.nextInt(1900, 2023);
        String num = Integer.toString(i);
        return num;
    }

    public String setRandomDay() {
        final Random random = new Random();
        int i = random.nextInt(1, 28);
        String num = Integer.toString(i);
        return num;
    }
}
