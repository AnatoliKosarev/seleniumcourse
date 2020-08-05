package tests.loans.positive;

import constants.Constant;
import org.junit.jupiter.api.Test;
import tests.base.BaseTest;

public class CarLoansPositiveTest extends BaseTest {

    @Test
    public void selectAgreementTabInPublicSession() {
        basePage.goToUrl(Constant.Urls.CAR_LOANS_URL);
        carLoans.selectAgreementsTab();
        basePage.authWidgetIsPresentCheck();
    }
}
