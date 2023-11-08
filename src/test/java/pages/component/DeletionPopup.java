package pages.component;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DeletionPopup {
    public DeletionPopup removingPopup() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
}
