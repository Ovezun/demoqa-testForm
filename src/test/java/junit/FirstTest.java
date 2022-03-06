package junit;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void simpleTest () {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("demotest@test.ru");
        $("#userNumber").setValue("7912345678");
        $("#currentAddress").setValue("Test address!!");
        $(byText ("Other")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1950");
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $(byText ("Music")).click();
        $(byText ("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Dwarf.jpg"));
        $("#stateCity-label").scrollTo();
        $(byText("Select State")).click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Karnal")).click();
        $("#submit").click();
        //sleep(500);

        $(".table-responsive").shouldHave(text("Ivan Petrov"));
        $(".table-responsive").shouldHave(text("demotest@test.ru"));
        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("7912345678"));
        $(".table-responsive").shouldHave(text("13 June,1950"));
        $(".table-responsive").shouldHave(text("Maths, Arts"));
        $(".table-responsive").shouldHave(text("Music, Sports"));
        $(".table-responsive").shouldHave(text("Dwarf.jpg"));
        $(".table-responsive").shouldHave(text("Test address!!"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));


    }



}
