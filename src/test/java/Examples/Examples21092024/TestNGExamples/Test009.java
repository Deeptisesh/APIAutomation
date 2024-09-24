package Examples.Examples21092024.TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test009 {
    @Test
    public  void test01(){
        Assert.assertTrue(true);

    }
    @Test(alwaysRun = true)
    public  void test02(){
        Assert.assertTrue(false);

    }
    @Test(enabled = false)
    public  void test03(){
        Assert.assertTrue(true);

    }
}
