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

    public static class MobileReplenishmentTestData {
        public static final String PHONE_NUMBER = "686979712";
        public static final String CARD_NUMBER = "4506909324274797";
        public static final String CARD_EXP_DATE = "0622";
        public static final String CARD_CVV_CODE = "327";
    }
}
