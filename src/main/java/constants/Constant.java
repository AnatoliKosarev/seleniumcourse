package constants;

public class Constant {
    public static final String PAYMENT_DETAILS_TEXT = "Mobile payment. Phone number ";

    public static class TimeVariables {
        public static final int IMPLICIT_WAIT = 5;
        public static final int EXPLICIT_WAIT = 10;
    }

    public static class Urls {
        public static final String TELECOM_URL = "https://next.privat24.ua/mobile/?lang=en";
        public static final String CAR_LOANS_URL = "https://next.privat24.ua/auto-credit/order/?lang=en";
    }

    public static class UserTestData {
        public static final String UKR_PHONE_NUMBER = "686979712";
        public static final String RUS_PHONE_NUMBER = "000000000000";
        public static final String CARD_NUMBER_HIDDEN = "4506 **** **** 4797";
        public static final String CARD_NUMBER = "4506909324274797";
        public static final String CARD_EXP_DATE = "0622";
        public static final String CARD_CVV_CODE = "327";
    }

    public class CURRENCY {
        public static final String CURRENCY_UAH = "UAH";
        public static final String CURRENCY_USD = "USD";
        public static final String CURRENCY_EUR = "EUR";
    }
}
