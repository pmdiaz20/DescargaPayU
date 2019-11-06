package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TransaccionesPage extends BasePage {

    public TransaccionesPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(how = How.XPATH, using = "//a[@id='zk_comp_80']")
    WebElement btnTransacciones;


    @FindBy(how = How.XPATH, using = "//input[@id='zk_comp_1199-real']") //  cuenta
    WebElement dropCuenta;


/*
    @FindBy(how = How.CSS, using = "#zk_comp_1199-cave")
    WebElement dropCuenta; */

    @FindBy(how = How.XPATH, using = "//input[@id='zk_comp_1205-real']")  // fechainicial
    WebElement fechaInicial;

    @FindBy(how = How.XPATH, using = "//input[@id='zk_comp_1211-real']") // fechaFinal
    WebElement fechaFinal;

    @FindBy(how = How.XPATH, using = "//input[@id='zk_comp_1767-real']") //formato
    WebElement formatoArchivo;

    @FindBy(how = How.XPATH, using = "//button[@id='zk_comp_1822']")
    WebElement btnEnviar;



    public void enviarDescarga(String cuenta,String fechaAyer){

        dropCuenta.sendKeys(cuenta);
        fechaInicial.clear();
        fechaInicial.sendKeys(fechaAyer);

        formatoArchivo.clear();
        formatoArchivo.sendKeys("EXCEL");

        btnEnviar.click();
        //Select selectAccount = new Select(dropCuenta);
        //selectAccount.selectByVisibleText(cuenta);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


}
