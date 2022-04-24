package practice.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import practice.pages.components.CalendarComp;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegFormPgObj {

    SelenideElement phoneNumber = $("#userNumber");
    SelenideElement picLocator = $("#uploadPicture");
    CalendarComp calendar = new CalendarComp();

    public RegFormPgObj openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;

    }
    public RegFormPgObj setPhone(String value){
        phoneNumber.setValue(value);
        return this;
    }
    public RegFormPgObj uploadPic(String value){
        picLocator.uploadFromClasspath(value);
        return this;
    }
    public RegFormPgObj setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }


}
