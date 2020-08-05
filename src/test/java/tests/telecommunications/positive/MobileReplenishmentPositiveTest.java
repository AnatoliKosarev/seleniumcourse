package tests.telecommunications.positive;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

import static constants.Constant.MobileReplenishmentTestData.*;
import static constants.Constant.TimeVariables.IMPLICIT_WAIT;
import static constants.Constant.Urls.TELECOM_URL;

public class MobileReplenishmentPositiveTest extends BaseTest {

    @Test
    public void selectWalletInPublicSession() {
        basePage.goToUrl(TELECOM_URL);
        mobileReplenishmentPage.clickWalletButton();
        basePage.authWidgetIsPresentCheck();
    }

    @Test
    public void minAmountReplenishmentCheck() {
        basePage.goToUrl(TELECOM_URL);
        mobileReplenishmentPage.enterPhoneNumber(PHONE_NUMBER)
                .enterPaymentAmount("1")
                .enterCardNumber(CARD_NUMBER)
                .enterCardExpDate(CARD_EXP_DATE)
                .enterCardCvv(CARD_CVV_CODE)
                .pressToTheCartButton()
                .paymentDetailsPresentInCartCheck("+380" + PHONE_NUMBER);
    }
}
