package pages.loans;

import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CarLoansPage extends BasePage {

    private final SelenideElement agreementsTabLocator = $x("//div[contains(text(), 'Agreements')]");
    private final SelenideElement carPriceInputFieldLocator = $x("//input[@data-qa-node='amount']");
    private final SelenideElement prepaymentInputFieldLocator = $x("//input[@data-qa-node='prepaid']");
    private final SelenideElement countryCodeButtonLocator = $x("//button[@data-qa-node='phone-code']");
    private final SelenideElement countryCodeSearchFieldLocator = $x("//input[@placeholder='Search' and .//ancestor::div[@data-qa-node = 'phone-code-list']]");
    private final SelenideElement phoneNumberInputFieldLocator = $x("//input[@data-qa-node='phone-number']");
    private final SelenideElement submitApplicationButtonLocator = $x("//button[@type='button' and contains(text(), 'Submit an application')]");
    private final SelenideElement selectedUsedCarSwitcherLocator = $x("//div[@data-qa-node='type' and contains(text(), 'With mileage')]");
    private final SelenideElement loginFormWidgetLocator = $x("//iframe[@src='https://login-widget.privat24.ua/']");
    private final SelenideElement ukrainePhoneCodeButtonLocator = $x("//button[@data-qa-value='Ukraine']");

    /**
     * Select "Agreements" tab
     * @return CarLoansPage object
     */
    public CarLoansPage selectAgreementsTab() {
        agreementsTabLocator.shouldBe(visible).click();
        return this;
    }

    /**
     * Check that "With mileage" switcher is shown selected
     * @return CarLoansPage object
     */
    public CarLoansPage checkThatWithMileageSwitcherSelected() {
        selectedUsedCarSwitcherLocator.shouldBe(visible);
        return this;
    }

    /**
     * Enter car cost value into "Car price" input field
     * @param carCost car price
     * @return CarLoansPage object
     */
    public CarLoansPage enterCarCostValueIntoCarCostInputField(String carCost) {
        clearAndType(carPriceInputFieldLocator, carCost);
        return this;
    }

    /**
     * Enter prepayment value into "Your prepayment" input field
     * @param prepayValue prepayment value
     * @return CarLoansPage object
     */
    public CarLoansPage enterPrepaymentIntoPrepaymentInputField(String prepayValue) {
        clearAndType(prepaymentInputFieldLocator, prepayValue);
        return this;
    }

    /**
     * Enter phone number into "Phone number" input field excluding country code
     * @param phoneNumber user's phone number
     * @return CarLoansPage object
     */
    public CarLoansPage enterPhoneNumberIntoPhoneNumberInputField(String phoneNumber) {
        clearAndType(phoneNumberInputFieldLocator, phoneNumber);
        return this;
    }

    /**
     * Expand country code list for "Phone number" input field
     * @return CarLoansPage object
     */
    public CarLoansPage expandCountryCodeList() {
        countryCodeButtonLocator.shouldBe(visible).click();
        return this;
    }

    /**
     * Search for country code from country code list
     * @param countryCode user's country code
     * @return CarLoansPage object
     */
    public CarLoansPage searchForCountryCode(String countryCode) {
        clearAndType(countryCodeSearchFieldLocator, countryCode);
        return this;
    }

    /**
     * Select Ukraine country code from country code list
     * @return CarLoansPage object
     */
    public CarLoansPage selectUkraineCountryCodeFromList() {
        ukrainePhoneCodeButtonLocator.shouldBe(visible).click();
        return this;
    }

    /**
     * Submit car loan application form
     * @return CarLoansPage object
     */
    public CarLoansPage submitCarLoanApplication() {
        submitApplicationButtonLocator.shouldBe(visible).click();
        return this;
    }

    /**
     * Check that login form is displayed
     * @return CarLoansPage object
     */
    public CarLoansPage checkLoginFormIsDisplayed() {
        loginFormWidgetLocator.shouldBe(visible);
        return this;
    }
}
