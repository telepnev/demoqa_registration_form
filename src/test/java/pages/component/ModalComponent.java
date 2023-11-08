package pages.component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalComponent {
    private SelenideElement
            table = $(".table-responsive"),
            mobile = $("#userNumber"),
            userEmail = $("#userEmail");

    public ModalComponent checkTableValue(String key, String value) {
        table.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
    public ModalComponent isModalAppear() {
        $(".modal-content").shouldBe(appear);
        return this;
    }
    public ModalComponent checkIncorrectMobilePhone(String mobilePhone) {
        mobile.setValue(mobilePhone);
        mobile.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }
    public ModalComponent checkIncorrectUserEmail(String mail) {
        userEmail.setValue(mail);
        userEmail.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }
    public ModalComponent isNotModalAppear() {
        $(".modal-content").shouldNot(appear);
        return this;
    }
}
