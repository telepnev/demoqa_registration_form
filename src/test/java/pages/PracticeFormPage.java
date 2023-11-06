package pages;

import com.codeborne.selenide.SelenideElement;
import pages.component.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class PracticeFormPage {
    CalendarComponent component = new CalendarComponent();
    private SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
    //---Gender
    genderWrapper = $("#genterWrapper"),
    // --Mobile
    mobile = $("#userNumber"),
    // --Date of Birth
    initCreateDateOfBirth = $("#dateOfBirthInput"),
    // ---Subjects
    subjects = $("#subjectsInput"),
    //----Hobbies
    hobbiesWrapper = $("#hobbiesWrapper"),
    // --Picture
    picture = $("#uploadPicture"),
    // --CurrentAddress
    currentAddress = $("#currentAddress"),
    // --State and City
    state = $("#state"),
    city = $("#city"),
    // --Submit
    submit = $("#submit");


    public PracticeFormPage openPracticeFormPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String setFirstName) {
        firstName.setValue(setFirstName);
        return this;
    }

    public PracticeFormPage setLastName(String setLastName) {
        lastName.setValue(setLastName);
        return this;
    }

    public PracticeFormPage setUserEmail(String setUserEmail) {
        userEmail.setValue(setUserEmail);
        return this;
    }

    public PracticeFormPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public PracticeFormPage setHobbies(String hobbies) {
        hobbiesWrapper.$(byText(hobbies)).click();
        return this;
    }

    public PracticeFormPage setCalendar(String day, String month, String year) {
        initCreateDateOfBirth.click();
        component.setCalendar(day, month, year);
        return this;
    }

    public PracticeFormPage setMobilePhone(String mobilePhone) {
        mobile.setValue(mobilePhone);
        return this;
    }

    public PracticeFormPage setPicture(String strPicture) {
        picture.uploadFromClasspath(strPicture);
        return this;
    }

    public PracticeFormPage setSubject(String subject) {
        subjects.setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public PracticeFormPage setState(String setState) {
        state.click();
        state.$(byText(setState)).click();
        return this;
    }

    public PracticeFormPage setCity(String setCity) {
        city.click();
        city.$(byText(setCity)).click();
        return this;
    }

    public PracticeFormPage submitButton() {
        submit.click();
        return this;
    }
}
