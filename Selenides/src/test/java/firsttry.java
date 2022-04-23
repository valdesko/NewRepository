
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

class frst {

    @BeforeAll
    static void initDB(){
        System.out.println("base loaded");
    }

    @BeforeEach
    void openings(){
        open("https://www.google.com/");
    }

    @AfterEach
    void endings(){
        WebDriverRunner.closeWindow();
    }

    @Test
    void selenideSearch(){
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("selenide.org"));

    }
    @Test
    void kotiki(){
        $("[name=q]").setValue("kotiki").pressEnter();

    }


}
