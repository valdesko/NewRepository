package practice.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLog;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice.pages.RegFormPgObj;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

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
        SelenideLogger.addListener("allure", new AllureSelenide());

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



    @Test
    @DisplayName("RegForm")
    @Owner("me")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("DemoQA")
    @Story("Форма регистрации")
    @Link(value="Test", url = "https://demoqa.com")
    void demoqaForm(){
        SelenideLogger.addListener("allure", new AllureSelenide());
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
        step("Открываем яндекс", () -> {
            open("https://ya.ru/");
        });
        step("Вставляем текст в поле поиска", () -> {
            $("#text").setValue(tstData);
        });
        step("Жмем Найти", ()->{
            $("button[type='submit']").click();
        });
        step("Проверки", ()->{
            $$(".serp-item")
                    .find(Condition.text(tstData))
                    .shouldBe(visible);
        });




    }




}