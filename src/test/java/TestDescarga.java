import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.DataProviderClass;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestDescarga extends BaseTest{

    @Test(dataProvider = "SearchProviderToLogin",dataProviderClass = DataProviderClass.class)
    public void testDescargaDatos(String mail, String password, Method method) throws InterruptedException {

        extentTest = extentReports.createTest(method.getName());

        String cuentaCO = "Colombia - 518083";
        String cuentaAR = "Argentina - 518031";

        //////////////////////////////////////////////////////
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-1); // resto un dia
        date=calendar.getTime();
        SimpleDateFormat s;
        s=new SimpleDateFormat("dd/MM/yyyy");

        String fechaAyer = s.format(date);

        //////////////////////////////////////////////////////

        SA.assertTrue(loginPage.btnIngresarIsDisplayed(),"Falla en mostrar btnIngresar");
        SA.assertTrue(loginPage.userTextBoxIsDisplayed(),"Falla en mostrar campo Usuario");
        SA.assertTrue(loginPage.passwordTextBoxIsDisplayed(),"Falla en mostrar campo password");


        reportsPage= loginPage.login(mail,password);
        SA.assertTrue(reportsPage.btnTransaccionesIsDisplayed(),"Falla en mostrar btnTransacciones");
        extentTest.log(Status.INFO, "Login ok con usuario"+mail);


        transaccionesPage = reportsPage.goToTransaccionesPage();
        SA.assertTrue(transaccionesPage.dropCuentaIsDisplayed(),"Falla en mostrar drop de Cuentas");
        SA.assertTrue(transaccionesPage.fechaInicialIsDisplayed(),"Falla en mostrar Fecha Inicial");
        SA.assertTrue(transaccionesPage.fechaFinalIsDisplayed(),"Falla en mostrar Fecha Final");
        SA.assertTrue(transaccionesPage.formatoIsDisplayed(),"Falla en mostrar drop Formato");
        SA.assertTrue(transaccionesPage.btnEnviarIsDisplayed(),"Falla en mostrar btnEnviar");
        extentTest.log(Status.INFO, "Carga OK TransaccionesPage");


        transaccionesPage.enviarDescarga(cuentaCO,fechaAyer);
        extentTest.log(Status.INFO, "Descargo transacciones para cuenta "+cuentaCO);

        transaccionesPage.enviarDescarga(cuentaAR,fechaAyer);

        extentTest.log(Status.INFO, "Descargo transacciones para cuenta "+cuentaAR);

        transaccionesPage.salir();

        extentTest.log(Status.INFO, "Log out de PayU");


        /*
        Opcion 1
        baja el archivo transactions.csv en C:\Users\pablo.diaz\Downloads
        crear un .bat que lo mueva a la carpeta compartida \\10.59.120.30\Share_Uy\Temporal\QA\Reportes_PayU
        y que el equipo de calidad lo suba a Atalaya
         */

        /*
        Opcion 2
        baja el archivo transactions.csv en C:\Users\pablo.diaz\Downloads
        crear algo que lo mueva al ftp de 10.1.1.40:21/payu_co/upload
           */






        // baja el archivo transactions.csv en C:\Users\pablo.diaz\Downloads

        // \\10.59.120.30\Share_Uy\Temporal\QA\Reportes_PayU

        //>move transactions.csv \\10.59.120.30\Share_Uy\Temporal\QA\Reportes_PayU

        //mover al ftp de 10.1.1.40:21/payu_co/upload

        //transaccionesPage.enviarDescarga(cuentaAR,fechaAyer);



    }

}
