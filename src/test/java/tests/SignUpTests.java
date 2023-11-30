package tests;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashPage;
import utils.RandomUtils;

public class SignUpTests extends AppiumConfig {
    RandomUtils randomUtils = new RandomUtils();
    @Test
    public void positiveReg(){
    String email = randomUtils.generateEmail(7);
        Assert.assertTrue(new SplashPage(driver).goToAuthPage()
                .reg(UserDTO.builder()
                        .email(email)
                        .password("123456Aa$")
                        .build())
                .validateReg());
    }
    @Test
    public void negativeRegWrongPassword() {
        String email = randomUtils.generateEmail(7);
        Assert.assertTrue(new SplashPage(driver)
                .goToAuthPage()
                .reg(UserDTO
                        .builder()
                        .email(email)
                        .password("123456Aa")
                        .build())
                .clickRegBtnNegative().validateErrorTitleAlertCorrect());
    }

    @Test
    public void negativeRegWrongEmail() {
        Assert.assertTrue(new SplashPage(driver)
                .goToAuthPage()
                .reg(UserDTO
                        .builder()
                        .email("1A")
                        .password("123456Aa")
                        .build())
                .clickRegBtnNegative().validateErrorTitleAlertCorrect());
    }

    @Test
    public void negativeRegWrongPasswordNoDigits() {
        String email = randomUtils.generateEmail(7);
        Assert.assertTrue(new SplashPage(driver)
                .goToAuthPage()
                .reg(UserDTO
                        .builder()
                        .email(email)
                        .password("qwertyAa")
                        .build())
                .clickRegBtnNegative().validateErrorTitleAlertCorrect());
    }
}
