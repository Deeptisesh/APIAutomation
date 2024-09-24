package Examples.Examples21092024.TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test007 {
    //Parameters
    @Parameters("browser")
    @Test(alwaysRun = true)
    void demo1(String value){
        System.out.println("Browser is " +value);

        // Open the Browser and select dadadada

    }
}
