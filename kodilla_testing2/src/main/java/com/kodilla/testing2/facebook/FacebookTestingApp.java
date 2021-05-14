package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_COOKIE_BUTTON = "//*[@title=\"Akceptuj wszystkie\"]";
    public static final String XPATH_NEW_ACCOUNT_BUTTON = "//*[@data-testid=\"open-registration-form-button\"]";
    public static final String FIRSTNAME_FIELD = "firstname";
    public static final String LASTNAME_FIELD = "lastname";
    public static final String REG_EMAIL_FIELD = "reg_email__";
    public static final String REG_EMAIL_CONFIRM_FIELD = "reg_email_confirmation__";
    private static final String REG_PASSWORD_FIELD = "reg_passwd__";
    public static final String FIRSTNAME = "Tom";
    public static final String LASTNAME  = "Hardy";
    public static final String EMAIL = "tom@example.com";
    public static final String PASSWORD = "123abc";
    public static final String XPATH_BIRTHDAY_SELECT = "//div[@class=\"_5k_5\"]/span/span/select[1]";
    public static final String XPATH_BIRTHMONTH_SELECT = "//div[@class=\"_5k_5\"]/span/span/select[2]";
    public static final String XPATH_BIRTHYEAR_SELECT = "//div[@class=\"_5k_5\"]/span/span/select[3]";
    public static final String GENDER_MALE_BUTTON = "*//span[@data-name=\"gender_wrapper\"]/span[2]/input";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com");

        WebElement cookies = driver.findElement(By.xpath(XPATH_COOKIE_BUTTON));
        cookies.click();

        while (!driver.findElement(By.xpath(XPATH_NEW_ACCOUNT_BUTTON)).isDisplayed());

        WebElement newAccount = driver.findElement(By.xpath(XPATH_NEW_ACCOUNT_BUTTON));
        newAccount.click();


        Thread.sleep(1500);


        WebElement firstnameField = driver.findElement(By.name(FIRSTNAME_FIELD));
        firstnameField.sendKeys(FIRSTNAME);

        WebElement lastnameField = driver.findElement(By.name(LASTNAME_FIELD));
        lastnameField.sendKeys(LASTNAME);

        WebElement email = driver.findElement(By.name(REG_EMAIL_FIELD));
        email.sendKeys(EMAIL);

        WebElement emailConfirm = driver.findElement(By.name(REG_EMAIL_CONFIRM_FIELD));
        emailConfirm.sendKeys(EMAIL);

        WebElement password = driver.findElement(By.name(REG_PASSWORD_FIELD));
        password.sendKeys(PASSWORD);


        WebElement selectDayCombo = driver.findElement(By.xpath(XPATH_BIRTHDAY_SELECT));
        Select selectDay = new Select(selectDayCombo);
        selectDay.selectByIndex(17);

        WebElement selectMonthCombo = driver.findElement(By.xpath(XPATH_BIRTHMONTH_SELECT));
        Select selectMonth = new Select(selectMonthCombo);
        selectMonth.selectByIndex(5);

        WebElement selectYearCombo = driver.findElement(By.xpath(XPATH_BIRTHYEAR_SELECT));
        Select selectYear = new Select(selectYearCombo);
        selectYear.selectByValue("1990");

        WebElement selectGenderRadioButton = driver.findElement(By.xpath(GENDER_MALE_BUTTON));
        selectGenderRadioButton.click();
    }
}
