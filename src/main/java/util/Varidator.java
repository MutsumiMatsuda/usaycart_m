package util;

import java.util.regex.Pattern;

public class Varidator {

    static final String MAIL_REGEX = "^[a-z0-9-._]+@([a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]*\\.)+[a-zA-Z]{2,}$";
    static final String POSTAL_CODE_REGEX = "^[0-9]{3}-[0-9]{4}$";
    static final String MOBILE_PHONE_REGEX = "^(070|080|090)[0-9]{4}[0-9]{4}$";
    static final String FILLED_REGEX = "[^\\s　]";

    public static boolean isMail(String mail) {
        return Pattern.matches(MAIL_REGEX, mail);
    }

    public static boolean isPostalCode(String postalCode) {
        return Pattern.matches(POSTAL_CODE_REGEX, postalCode);
    }

    public static boolean isMobilePhone(String mobilePhone) {
        return Pattern.matches(MOBILE_PHONE_REGEX, mobilePhone);
    }

    public static boolean isFilled(String str) {
        return !str.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(Varidator.isMail("aa@saycon.co.jp"));
        System.out.println(Varidator.isPostalCode("460-0001"));
        System.out.println(Varidator.isMobilePhone("09092361275"));
        System.out.println(Varidator.isFilled(" "));
    }

}
