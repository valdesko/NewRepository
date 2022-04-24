
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;



import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

class frst {

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

//    @Test
//    void demoqaTextBox(){
//        String address2 = "streestreet";
//
//        open("/text-box");
//        $x("//*[@id='userName']").setValue(firstName);
//        $("[id=userEmail]").setValue(mail);
//        $("[id=currentAddress]").setValue(currentAddress);
//        $("[id=permanentAddress]").setValue(address2);
//        $("#submit").click();
//
//        $("[id=output]").shouldHave(text(name),text(mail));
//        $("[id=output] [id=currentAddress]").shouldHave(text(address1));
//        $("[id=output]").$("[id=permanentAddress]").shouldHave(text(address2));
//
//    }

    @Test
    void demoqaForm(){
        String phone = "8800555353",
                subject = "Chemisrty",
                gender = "Male",
                hobby = "Reading",
                state = "Rajasthan",
                city = "Jaipur",
                img = "123.png";
        SelenideElement place = $("#stateCity-wrapper");


        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(mail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#userNumber").setValue(phone);
        $("#currentAddress").setValue(currentAddress);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--001").click();
        place.$(byText("Select State")).click();
        place.$(byText(state)).click();
        place.$(byText("Select City")).click();
        place.$(byText(city)).click();
        $("#uploadPicture").uploadFromClasspath(img);
        $("#subjectsInput").setValue(subject);

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(mail),
                text(gender),
                text(phone),
                text ("01 Murch,1995"),
                text(hobby),
                text("123.png"),
                text(currentAddress),
                text(state + " " + city));


    }



//    @Test
//    void kotiki(){
//        open("https://google.com/");
//        $("[name=q]").setValue("kotiki").pressEnter();
//
//    }


}