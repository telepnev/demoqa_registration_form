package tests;

import data.FormPageHelper;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    FormPageHelper helper = new FormPageHelper();

    @Test
    public void fullPositivePracticeFormTest() {
        String firstName = helper.getFirstName();
        String lastName = helper.getLastName();
        String email = helper.getEmail();
        String gender = helper.getRandomGender();
        String mobile = helper.getMobilePhone();
        String month = helper.setRandomMonth();
        String year = helper.setRandomYear();
        String day = helper.setRandomDay();
        String hobbies = helper.getRandomHobbies();
        String picture = "img/Locators.pdf";
        String address = helper.getCurrentAddress();

        practiceFormPage.openPracticeFormPage().

        setFirstName(firstName).
        setLastName(lastName).
        setUserEmail(email).
        setGender(gender).
        setMobilePhone(mobile).
        setCalendar(day, month, year).
        setSubject("Arts").
        setHobbies(hobbies).
        setPicture(picture).
        setCurrentAddress(address).
        setState("Uttar Pradesh").
        setCity("Agra").
        submitButton();

        $(".modal-content").shouldBe(appear);
        checkStudentName(firstName, lastName);

//        $(".table-responsive")
//                .shouldHave(text(firstName))
//                .shouldHave(text(lastName))
//                .shouldHave(text(email))
//                .shouldHave(text(gender))
//                .shouldHave(text(mobile))
//                .shouldHave(text(month))
//                .shouldHave(text(year))
//                .shouldHave(text(day))
//                .shouldHave(text("Uttar Pradesh"))
//                .shouldHave(text("Agra"));

    }

    private static void checkStudentName(String firstName, String lastName) {
        $x("//div[@class='table-responsive']//tbody/tr[1]")
                .shouldHave(text(firstName), text(lastName));
    }
}
