package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //component
    private CalendarComponent calendarComponent = new CalendarComponent();
    //locators

    private SelenideElement
            headerTitle = $(".main-header"),
            firstNameInput = $("#firstName") ,
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            dayOfBirh = $("#dateOfBirthInput"),
            genderInput = $("#genterWrapper"),
            subjectsInput = $("#subjectsInput"),
            hobbyInput = $(".practice-form-wrapper"),
            picture = $("#uploadPicture"),
            stateInput = $(byText("Select State")),
            cityInput = $(byText("Select City")),
            submitClick = $("#submit"),
            resultsTable = $(".table-responsive");


    //actions
    //.setValue("Ivan");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));
        return  this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }
    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }
    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        dayOfBirh.click();
        calendarComponent.setDay(day, month, year);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderInput.$(byText (gender)).click();
        return this;
    }
    public RegistrationPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String hobby) {
        hobbyInput.$(byText (hobby)).click();
        return this;
    }
    public RegistrationPage downloadPicture() {
        picture.uploadFile(new File("src/test/resources/Dwarf.jpg"));
        return this;
    }
    public RegistrationPage setStates(String state) {
        $("#stateCity-label").scrollTo();
        stateInput.click();
        $(byText(state)).click();
        return this;
    }
    public RegistrationPage setCity(String city) {
        cityInput.click();
        $(byText(city)).click();
        return this;
    }
    public RegistrationPage setSubmitClick() {
        submitClick.click();
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName)).parent().shouldHave(text(value));
        return this;
    }
}

