package practice.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice.pages.RegFormPgObj;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

class firsttry {

    RegFormPgObj regFormPgObj = new RegFormPgObj();
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            mail = faker.internet().emailAddress(),
            currentAddress = faker.address().fullAddress();



    @BeforeAll
    static void setup(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @DisplayName("Проверка формы TextBox")
    @Test
    void demoqaTextBox(){
        String address2 = "streestreet";

        open("/text-box");
        $x("//*[@id='userName']").setValue(firstName);
        $("[id=userEmail]").setValue(mail);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=permanentAddress]").setValue(address2);
        $("#submit").click();

        $("[id=output]").shouldHave(text(firstName),text(mail));
        $("[id=output] [id=currentAddress]").shouldHave(text(currentAddress));
        $("[id=output]").$("[id=permanentAddress]").shouldHave(text(address2));

    }

    @DisplayName("Работа в формой регистрации студентов")
    @Test
    void demoqaForm(){
        String phone = "8800555353",
                subject = "Chemisrty",
                gender = "Male",
                hobby = "Reading",
                state = "Rajasthan",
                city = "Jaipur",
                imgPath = "123.png";
        SelenideElement place = $("#stateCity-wrapper");


        regFormPgObj.openPage()
                .setPhone(phone)
                .uploadPic(imgPath);
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(mail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#hobbiesWrapper").$(byText(hobby)).click();

        $("#currentAddress").setValue(currentAddress);
        regFormPgObj.setBirthDate("01", "March", "1995");
        place.$(byText("Select State")).click();
        place.$(byText(state)).click();
        place.$(byText("Select City")).click();
        place.$(byText(city)).click();
        $("#subjectsInput").setValue(subject);
        // проверка
        $(".table-responsive").shouldNot(exist);

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(mail),
                text(gender),
                text(phone),
                text ("01 March,1995"),
                text(hobby),
                text("123.png"),
                text(currentAddress),
                text(state + " " + city));


    }

    @ValueSource(strings = {"Selenide", "JUnit"})
    @ParameterizedTest(name = "Проверка поиска через яндекс слова {0}")
    void SrchTest(String tstData){
        open("https://ya.ru/");

        $("#text").setValue(tstData);
        $("button[type='submit']").click();

        $$(".serp-item")
                .find(Condition.text(tstData))
                .shouldBe(visible);

    }




}