package utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "SearchProviderToLogin")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]
                {
                        {"mercury", "Mercury15."}
                };
    }
}

