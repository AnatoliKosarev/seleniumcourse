package pages.telecommunications;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import static constants.Constant.PAYMENT_DETAILS_TEXT;
import static constants.Constant.TimeVariables.EXPLICIT_WAIT;


public class MobileReplenishmentPage extends BasePage {
    private final By walletButtonLocator = By.xpath("//div[contains(text(), 'My wallet')]");
    private final By phoneInputFieldLocator = By.xpath("//input[@data-qa-node = 'phone-number']");
    private final By amountInputFiledLocator = By.xpath("//input[@data-qa-node = 'amount']");
    private final By cardNumberInputFiledLocator = By.xpath("//input[@data-qa-node = 'numberdebitSource']");
    private final By cardExpDateInputFieldLocator = By.xpath("//input[@data-qa-node = 'expiredebitSource']");
    private final By cardCvvInputFieldLocator = By.xpath("//input[@data-qa-node = 'cvvdebitSource']");
    private final By toTheCartButtonLocator = By.xpath("//button[@data-qa-node = 'submit']");
    private final By paymentDetailsLocator = By.xpath("//span[@data-qa-node = 'details']");

    public MobileReplenishmentPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Press Wallet button
     * @return current object
     */
    public MobileReplenishmentPage clickWalletButton() {
        driver.findElement(walletButtonLocator).click();
        return this;
    }

    /**
     * Enter phone number excluding country code
     * @param phoneNumber phone number
     * @return current object
     */
    public MobileReplenishmentPage enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneInputFieldLocator).sendKeys(phoneNumber);
        return this;
    }

    /**
     * Enter payment amount
     * @param paymentAmount payment amount
     * @return current object
     */
    public MobileReplenishmentPage enterPaymentAmount(String paymentAmount) {
        driver.findElement(amountInputFiledLocator).sendKeys(paymentAmount);
        return this;
    }

    /**
     * Enter debit card number
     * @param cardNumber debit card number
     * @return current object
     */
    public MobileReplenishmentPage enterCardNumber(String cardNumber) {
        driver.findElement(cardNumberInputFiledLocator).sendKeys(cardNumber);
        return this;
    }

    /**
     * Enter debit card expiry date
     * @param cardExpDate debit card expiry date
     * @return current object
     */
    public MobileReplenishmentPage enterCardExpDate(String cardExpDate) {
        driver.findElement(cardExpDateInputFieldLocator).sendKeys(cardExpDate);
        return this;
    }

    /**
     * Enter debit card CVV code
     * @param cardCvv debit card CVV code
     * @return current object
     */
    public MobileReplenishmentPage enterCardCvv(String cardCvv) {
        driver.findElement(cardCvvInputFieldLocator).sendKeys(cardCvv);
        return this;
    }

    /**
     * Press "To the cart" button
     * @return current object
     */
    public MobileReplenishmentPage pressToTheCartButton() {
        WebElement toTheCartButton = waitForElementToBeVisible(driver.findElement(toTheCartButtonLocator));
        toTheCartButton.click();
        return this;
    }

    /**
     * Check that payment details text is present on the page and user is on cart modal
     * @param phoneNumber user phone number with the country code
     * @return current object
     */
    public MobileReplenishmentPage paymentDetailsPresentInCartCheck(String phoneNumber) {
        WebElement paymentDetails  = waitForElementToBeVisible(driver.findElement(paymentDetailsLocator));
        Assertions.assertEquals(PAYMENT_DETAILS_TEXT + phoneNumber, paymentDetails.getText());
        return this;
    }
}
