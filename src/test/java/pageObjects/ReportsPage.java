package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReportsPage extends BasePage{

    public ReportsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//a[@id='zk_comp_80']")
    WebElement btnTransacciones;


    public TransaccionesPage goToTransaccionesPage(){

        btnTransacciones.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='zk_comp_107']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='zk_comp_1764']")));

        return new TransaccionesPage(driver);
    }

    public Boolean btnTransaccionesIsDisplayed()
    {
        return driver.findElement(By.xpath("//a[@id='zk_comp_80']")).isDisplayed();
    }


}
