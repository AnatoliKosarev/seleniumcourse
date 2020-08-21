package pages.telecommunications;

import com.codeborne.selenide.SelenideElement;
import pages.base.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static constants.Constant.PAYMENT_DETAILS_TEXT;

public class MobileReplenishmentPage extends BasePage {
    private final SelenideElement walletButtonLocator = $x("//div[@data-qa-node = 'debitSourceSource']");
    private final SelenideElement phoneInputFieldLocator = $x("//input[@data-qa-node = 'phone-number']");
    private final SelenideElement amountInputFiledLocator = $x("//input[@data-qa-node = 'amount']");
    private final SelenideElement cardNumberInputFiledLocator = $x("//input[@data-qa-node = 'numberdebitSource']");
    private final SelenideElement cardExpDateInputFieldLocator = $x("//input[@data-qa-node = 'expiredebitSource']");
    private final SelenideElement cardCvvInputFieldLocator = $x("//input[@data-qa-node = 'cvvdebitSource']");
    private final SelenideElement toTheCartButtonLocator = $x("//button[@data-qa-node = 'submit']");
    private final SelenideElement toTheCartButtonLoaderLocator = $x("//div[@data-qa-node = 'preloader']");
    private final SelenideElement paymentDetailsLocator = $x("//span[@data-qa-node = 'details']");
    private final SelenideElement cardNumberInCartLocator = $x("//td[@data-qa-node = 'card']");
    private final SelenideElement recipientNameInCartLocator = $x("//span[@data-qa-node = 'nameB']");
    private final SelenideElement paymentAmountInCartLocator = $x("//span[@data-qa-node = 'amount']");
    private final SelenideElement commissionInCartLocator = $x("//span[@data-qa-node = 'commission']");
    private final SelenideElement paymentCurrencyInCartLocator = $x("//small[@data-qa-node = 'currency']");
    private final SelenideElement commissionCurrencyInCartLocator = $x("//small[@data-qa-node = 'commission-currency']");

    /**
     * Press Wallet button
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage clickWalletButton() {
        walletButtonLocator.shouldBe(visible).click();
        return this;
    }

    /**
     * Enter phone number into "Number" input field excluding country code
     * @param phoneNumber phone number into "Number" input field
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage enterPhoneNumber(String phoneNumber) {
        clearAndType(phoneInputFieldLocator, phoneNumber);
        return this;
    }

    /**
     * Enter payment amount
     * @param paymentAmount payment amount into "Amount" input field
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage enterPaymentAmount(String paymentAmount) {
        clearAndType(amountInputFiledLocator, paymentAmount);
        return this;
    }

    /**
     * Enter debit card number into "Card for payment" input field
     * @param cardNumber debit card number
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage enterCardNumber(String cardNumber) {
        clearAndType(cardNumberInputFiledLocator, cardNumber);
        return this;
    }

    /**
     * Enter debit card expiry date into "Validation term" input field
     * @param cardExpDate debit card expiry date
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage enterCardExpDate(String cardExpDate) {
        clearAndType(cardExpDateInputFieldLocator, cardExpDate);
        return this;
    }

    /**
     * Enter debit card CVV code into "CVV-code" input field
     * @param cardCvv debit card CVV code
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage enterCardCvv(String cardCvv) {
        clearAndType(cardCvvInputFieldLocator, cardCvv);
        return this;
    }

    /**
     * Wait until loader is displayed on "To the cart" button
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage waitForButtonLoader() {
        toTheCartButtonLoaderLocator.shouldBe(visible);
        return this;
    }

    /**
     * Press "To the cart" button
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage pressToTheCartButton() {
        toTheCartButtonLocator.shouldHave(text("To the cart"));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        toTheCartButtonLocator.click();
        return this;
    }

    /**
     * Check that payment details text is present in Cart widget
     * @param phoneNumber user phone number with the country code
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage checkPaymentDetailsPresentInCart(String phoneNumber) {
        paymentDetailsLocator.shouldHave(text(PAYMENT_DETAILS_TEXT + phoneNumber));
        return this;
    }

    /**
     * Check that card number is present in Cart widget
     * @param cardNumber user card number in <dddd **** ***** dddd> format
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage checkCardNumberPresentInCart(String cardNumber) {
        cardNumberInCartLocator.shouldHave(text(cardNumber));
        return this;
    }

    /**
     * Check that recipient name is present in Cart widget
     * @param recipientName recipient name
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage checkRecipientNamePresentInCart(String recipientName) {
        recipientNameInCartLocator.shouldHave(text(recipientName));
        return this;
    }

    /**
     * Check that payment amount is present in Cart widget
     * @param paymentAmount payment amount
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage checkPaymentAmountPresentInCart(String paymentAmount) {
        paymentAmountInCartLocator.shouldHave(text(paymentAmount));
        return this;
    }

    /**
     * Check that commission amount is present in Cart widget
     * @param commissionAmount commission amount
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage checkCommissionAmountPresentInCart(String commissionAmount) {
        commissionInCartLocator.shouldHave(text(commissionAmount));
        return this;
    }

    /**
     * Check that payment currency is present in Cart widget
     * @param paymentCurrency payment currency
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage checkPaymentCurrencyPresentInCart(String paymentCurrency) {
        paymentCurrencyInCartLocator.shouldHave(text(paymentCurrency));
        return this;
    }

    /**
     * Check that commission currency is present in Cart widget
     * @param commissionCurrency commission currency
     * @return MobileReplenishmentPage object
     */
    public MobileReplenishmentPage checkCommissionCurrencyPresentInCart(String commissionCurrency) {
        commissionCurrencyInCartLocator.shouldHave(text(commissionCurrency));
        return this;
    }
}
