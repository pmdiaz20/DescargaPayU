import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.DataProviderClass;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDescarga extends BaseTest{

    @Test(dataProvider = "SearchProviderToLogin",dataProviderClass = DataProviderClass.class)
    public void testDescargaDatos(String mail, String password, Method method){

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


        extentTest = extentReports.createTest(method.getName());
        reportsPage= loginPage.login(mail,password);


        transaccionesPage = reportsPage.clickInTransacciones();
        transaccionesPage.enviarDescarga(cuentaCO,fechaAyer);

        // baja el archivo transactions.csv en C:\Users\pablo.diaz\Downloads

        // \\10.59.120.30\Share_Uy\Temporal\QA\Reportes_PayU

        //>move transactions.csv \\10.59.120.30\Share_Uy\Temporal\QA\Reportes_PayU

        //transaccionesPage.enviarDescarga(cuentaAR,fechaAyer);



    }

}
