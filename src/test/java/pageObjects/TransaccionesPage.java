package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TransaccionesPage extends BasePage {

    public TransaccionesPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(how = How.XPATH, using = "//a[@id='zk_comp_80']")
    WebElement btnTransacciones;

/*
    @FindBy(how = How.XPATH, using = "//input[@id='zk_comp_1199-real']") //  cuenta
    WebElement dropCuenta;*/

    @FindBy(how = How.XPATH, using = "//i[@id='zk_comp_1199-btn']")
    WebElement btndropCuenta;

    @FindBy(how = How.XPATH, using = "//input[@id='zk_comp_1199-real']")//  cuenta
     WebElement dropCuenta;

    @FindBy(how = How.XPATH, using = "//input[@id='zk_comp_1205-real']")  // fechainicial
    WebElement fechaInicial;

    @FindBy(how = How.XPATH, using = "//input[@id='zk_comp_1211-real']") // fechaFinal
    WebElement fechaFinal;

    @FindBy(how = How.XPATH, using = "//input[@id='zk_comp_1767-real']") //formato
    WebElement formatoArchivo;

    @FindBy(how = How.XPATH, using = "//i[@id='zk_comp_1767-btn']")
    WebElement dropFormato;

    @FindBy(how = How.XPATH, using = "//button[@id='zk_comp_1822']")
    WebElement btnEnviar;

    @FindBy(how = How.XPATH, using = "//a[@id='zk_comp_34']")
    WebElement btnSalir;

    public void salir(){
        btnSalir.click();
    }

    public Boolean dropCuentaIsDisplayed()
    {
        return driver.findElement(By.xpath("//input[@id='zk_comp_1199-real']")).isDisplayed();
    }

    public Boolean fechaInicialIsDisplayed()
    {
        return driver.findElement(By.xpath("//input[@id='zk_comp_1205-real']")).isDisplayed();
    }

    public Boolean fechaFinalIsDisplayed()
    {
        return driver.findElement(By.xpath("//input[@id='zk_comp_1211-real']")).isDisplayed();
    }

    public Boolean formatoIsDisplayed()
    {
        return driver.findElement(By.xpath("//i[@id='zk_comp_1767-btn']")).isDisplayed();
    }

    public Boolean btnEnviarIsDisplayed()
    {
        return driver.findElement(By.xpath("//button[@id='zk_comp_1822']")).isDisplayed();
    }



    public void enviarDescarga(String cuenta,String fechaAyer) throws InterruptedException {

        btndropCuenta.click();

        //  Select selectAccount = new Select(dropCuenta);
        //  selectAccount.selectByValue(cuenta);

        //td[contains(text(),'Colombia - 518083')]

//      cuentaCO = "Colombia - 518083";    //tr[@id='zk_comp_2449']
//      cuentaAR = "Argentina - 518031";      //tr[@id='zk_comp_2448']


        dropCuenta.sendKeys(cuenta);

        fechaInicial.clear();
        fechaInicial.sendKeys(fechaAyer);


        formatoArchivo.clear();
        dropFormato.click();
        formatoArchivo.sendKeys("EXCEL");

        btnEnviar.click();

        Thread.sleep(3000); // esto hay que sacarlo y buscarle la vuelta.

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='zk_proc']"))));

        wait.until(ExpectedConditions.elementToBeClickable(btndropCuenta));

        System.out.println("baja archivo para cuenta: "+ cuenta);
        dropCuenta.clear();



    }


}
