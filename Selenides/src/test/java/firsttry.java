
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

class frst {

    @BeforeAll
    static void setup(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void demoqaTest1(){
        String name = "Petr";
        String mail = "petr@mail.com";
        String address1 = "street1";
        String address2 = "streestreet";

        open("/text-box");
        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue(mail);
        $("[id=currentAddress]").setValue(address1);
        $("[id=permanentAddress]").setValue(address2);
        $("#submit").click();

        $("[id=output]").shouldHave(text(name),text(mail));
        $("[id=output] [id=currentAddress]").shouldHave(text(address1));
        $("[id=output]").$("[id=permanentAddress]").shouldHave(text(address2));

    }
    @Test
    void kotiki(){
        open("https://google.com/");
        $("[name=q]").setValue("kotiki").pressEnter();

    }


}
