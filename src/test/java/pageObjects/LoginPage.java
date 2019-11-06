package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(how = How.XPATH, using = "//input[@id='zk_comp_53']")
    WebElement inputUser;


    @FindBy(how = How.XPATH, using = "//input[@id='zk_comp_57']")
    WebElement inputPassword;

    @FindBy(how = How.XPATH, using = "//input[@id='btnenviar']")
    WebElement btnIngresar;


    public ReportsPage login(String valid_user,String valid_password){

        inputUser.sendKeys(valid_user);
        inputPassword.sendKeys(valid_password);
        btnIngresar.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='zk_comp_107']")));

        return new ReportsPage(driver);
    }

}
