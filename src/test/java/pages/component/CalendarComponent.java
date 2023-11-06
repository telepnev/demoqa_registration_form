package pages.component;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    private SelenideElement
        initCreateDate = $("#dateOfBirthInput"),
        month = $(".react-datepicker__month-select"),
        year = $(".react-datepicker__year-select");

        public void setCalendar(String setDay, String setMonth, String setYear) {
        initCreateDate.click();
            month.selectOptionByValue(setMonth);
            year.selectOptionByValue(setYear);
        String datepickerDayXpath = String.format(("//div[not(contains(@class,'day--outside-month'))][text()='%s']"), setDay);
        $x(datepickerDayXpath).click();

    }
}
