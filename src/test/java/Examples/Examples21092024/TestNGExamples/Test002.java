package Examples.Examples21092024.TestNGExamples;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test002 {

    //PUT request
    String token;
    Integer bookingID;

    @BeforeTest
    public String getToken() {
        token = "123";
        return token;
    }

    @BeforeTest
    public void getBookingID() {
        // POST Req -
        // POST code
        bookingID = 123;
    }

    @Description("Verify if the assert passes if Token is printing")
    @Test
    public void testPUTReq() {
        System.out.println(token);
        System.out.println(bookingID);
    }
    @Description("Verify if the assert passes if Token is printing1")
    @Test
    public void testPUTReq2() {
        System.out.println(token);
        System.out.println(bookingID);
    }
    @Description("Verify if the assert passes if Token is printing2")
    @Test
    public void testPUTReq3() {
        System.out.println(token);
        System.out.println(bookingID);
    }
}
