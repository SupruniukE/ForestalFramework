package util;

import org.apache.commons.lang3.RandomStringUtils;

public class StringUtils {
    public static String getRandomEmail()
    {
        return RandomStringUtils.randomAlphabetic(10).toLowerCase() + "@mail.com";
    }
}
