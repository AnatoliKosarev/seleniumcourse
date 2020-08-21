package tests.telecommunications.positive;

import common.Listener;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import tests.base.BaseTest;

import static constants.Constant.CURRENCY.*;
import static constants.Constant.UserTestData.*;
import static constants.Constant.Urls.TELECOM_URL;


@Link(name = "check-list", url = "https://docs.google.com/spreadsheets/d/1Pva7hvXgpTNAWbeqj4J-dOSf24dVdgVMR0oX3k2cvV0/edit?usp=sharing")
@Feature("Tests to check mobile phone account replenishment functionality")
@Story("Positive test scenario")
@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
public class MobileReplenishmentPositiveTest extends BaseTest {
    @Test
    @DisplayName("Public session, non-client mobile phone account replenishment with the minimum amount")
    public void checkMinAmountReplenishment() {
        basePage.goToUrl(TELECOM_URL);
        mobileReplenishmentPage
                .enterPhoneNumber(UKR_PHONE_NUMBER)
                .enterPaymentAmount("1")
                .enterCardNumber(CARD_NUMBER)
                .enterCardExpDate(CARD_EXP_DATE)
                .enterCardCvv(CARD_CVV_CODE)
                .waitForButtonLoader()
                .pressToTheCartButton()
                .checkPaymentDetailsPresentInCart("+380" + UKR_PHONE_NUMBER)
                .checkPaymentAmountPresentInCart("1")
                .checkCommissionAmountPresentInCart("2")
                .checkPaymentCurrencyPresentInCart(CURRENCY_UAH)
                .checkCommissionCurrencyPresentInCart(CURRENCY_UAH)
                .checkCardNumberPresentInCart(CARD_NUMBER_HIDDEN)
                .checkRecipientNamePresentInCart("Kyivstar Ukraine");
    }

    @Test
    @DisplayName("Public session, non-client check fro redirect to authorisation page after selecting credit card from wallet")
    public void checkRedirectToAuthPage() {
        basePage.goToUrl(TELECOM_URL);
        mobileReplenishmentPage
                .clickWalletButton()
                .checkAuthWidgetIsPresent();
    }
}
