package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.SelenuimDriver;

public class Hooks {

    @Before
    public static void setUp(){
        SelenuimDriver.setUpDriver();
    }

    @After
    public static void tearDown(){
        SelenuimDriver.tearDown();
    }
}
