package tests;

import data.FormPageHelper;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.component.ModalComponent;


public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    FormPageHelper helper = new FormPageHelper();
    ModalComponent table = new ModalComponent();
    @Test
    public void fullPositivePracticeFormTest() {
        String firstName = helper.getFirstName();
        String lastName = helper.getLastName();
        String fio = firstName + " " + lastName;
        String email = helper.getEmail();
        String gender = helper.getRandomGender();
        String mobile = helper.getMobilePhone();
        String month = helper.setRandomMonth();
        String year = helper.setRandomYear();
        String day = helper.setRandomDay();
        String dateOfBirth = day + " " + helper.getMonth(month) + "," + year;
        String hobbies = helper.getRandomHobbies();
        String picture = "img/Locators.pdf";
        String address = helper.getCurrentAddress();
        String subject = "Arts";
        String state = "Uttar Pradesh";
        String city = "Agra";

        practiceFormPage.openPracticeFormPage().
                setFirstName(firstName).
                setLastName(lastName).
                setUserEmail(email).
                setGender(gender).
                setMobilePhone(mobile).
                setCalendar(day, month, year).
                setSubject(subject).
                setHobbies(hobbies).
                setPicture(picture).
                setCurrentAddress(address).
                setState(state).
                setCity(city).
                submitButton();

        table.isModalAppear();
        table.checkTableValue("Student Name", fio);
        table.checkTableValue("Student Email", email);
        table.checkTableValue("Gender", gender);
        table.checkTableValue("Mobile", mobile);
        table.checkTableValue("Date of Birth", dateOfBirth);
        table.checkTableValue("Subjects", "Arts");
        table.checkTableValue("Hobbies", hobbies);
        table.checkTableValue("Picture", "Locators.pdf");
        table.checkTableValue("Address", address);
        table.checkTableValue("State and City", state + " " + city);
    }

    @Test
    public void minimumFormFillingTest() {
        String firstName = helper.getFirstName();
        String lastName = helper.getLastName();
        String fio = firstName + " " + lastName;
        String gender = helper.getRandomGender();
        String mobile = helper.getMobilePhone();

        practiceFormPage.openPracticeFormPage().
                setFirstName(firstName).
                setLastName(lastName).
                setGender(gender).
                setMobilePhone(mobile).
                submitButton();

        table.isModalAppear().
        checkTableValue("Student Name", fio).
        checkTableValue("Gender", gender).
        checkTableValue("Mobile", mobile);
    }

    @Test
    public void incorrectFormFilling() {
        String firstName = helper.getFirstName();
        String lastName = helper.getLastName();
        String fio = firstName + " " + lastName;
        String gender = helper.getRandomGender();
        String mobile = "123456";
        String email = helper.getIncorrectEmails();

        practiceFormPage.openPracticeFormPage().
                setFirstName(firstName).
                setLastName(lastName).
                setGender(gender).
                setMobilePhone(mobile).
                submitButton();

        table.checkIncorrectMobilePhone(mobile);
        table.checkIncorrectUserEmail(email);
        table.isNotModalAppear();
    }
}
