package junit;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Ivan";
    String lastName = "Petrov";
    String userEmail = "demotest@test.ru";
    String userNumber = "7912345678";
    String currentAddress = "Test address!!";
    String gender = "Other";
    String state = "Haryana";
    String city = "Karnal";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void simpleTest () {
        registrationPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setUserEmail(userEmail)
                        .setUserNumber(userNumber)
                        .setCurrentAddress(currentAddress)
                        .setGender(gender)
                        .setBirthDay("13", "June", "1950")
                        .setSubjects("Maths")
                        .setSubjects("Arts")
                        .setHobbies("Music")
                        .setHobbies("Sports")
                        .downloadPicture()
                        .setStates(state)
                        .setCity(city)
                        .setSubmitClick();

        registrationPage.checkForm("Student Name",  firstName + " "+lastName)
                        .checkForm("Student Email", userEmail)
                        .checkForm("Gender", "Other")
                        .checkForm("Mobile", userNumber)
                        .checkForm("Date of Birth", "13 June,1950")
                        .checkForm("Subjects", "Maths, Arts")
                        .checkForm("Hobbies", "Music, Sports")
                        .checkForm("Picture", "Dwarf.jpg")
                        .checkForm("Address", currentAddress)
                        .checkForm("State and City", "Haryana Karnal");


    }



}
