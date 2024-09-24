package Examples.Examples21092024.TestNGExamples;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test001 {
@Description  ("Verify if the assert passes if er have true Condition")
@Severity(SeverityLevel.BLOCKER)
@Test
public void TC1(){
    Assert.assertEquals(true,true);
}

    @Description  ("Verify if the assert passes if er have False Condition")
    @Test
    public void TC2(){
    Assert.assertTrue(false);

    }



}
