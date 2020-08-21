package tests.loans.positive;

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

import static constants.Constant.Urls.CAR_LOANS_URL;
import static constants.Constant.UserTestData.RUS_PHONE_NUMBER;


@Link(name = "check-list", url = "https://docs.google.com/spreadsheets/d/1Pva7hvXgpTNAWbeqj4J-dOSf24dVdgVMR0oX3k2cvV0/edit?usp=sharing")
@Feature("Tests to check Car Loan functionality")
@Story("Positive test scenario")
@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
public class CarLoansPositiveTest extends BaseTest {

    @Test
    @DisplayName("Public session, non-client applying for a loan for a car with a mileage")
    public void applyForUsedCarLoanPublicSession() {
        basePage.goToUrl(CAR_LOANS_URL);
        carLoans
                .checkThatWithMileageSwitcherSelected()
                .enterCarCostValueIntoCarCostInputField("1500000")
                .enterPrepaymentIntoPrepaymentInputField("800000")
                .expandCountryCodeList()
                .searchForCountryCode("Russi")
                .selectRussianCountryCodeFromList()
                .enterPhoneNumberIntoPhoneNumberInputField(RUS_PHONE_NUMBER)
                .submitCarLoanApplication()
                .checkPassConfirmFormDisplayed();
    }

    @Test
    @DisplayName("Public session, non-client, reviewing the contract")
    void selectAgreementsTabInPublicSession() {
        basePage.goToUrl(CAR_LOANS_URL);
        carLoans
                .selectAgreementsTab()
                .checkAuthWidgetIsPresent();
    }
}
