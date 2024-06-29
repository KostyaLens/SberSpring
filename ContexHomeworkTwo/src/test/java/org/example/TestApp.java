package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApp {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    App app = context.getBean(App.class);
    @Test
    public void testBankClientsApp() throws NoClientsException {
        app.getBankClientsApp().setClient(true);
        Assert.assertEquals(true, app.checkClient());
    }
    @Test(expected = NoClientsException.class)
    public void testBankClientsApp1() throws NoClientsException {
        app.getBankClientsApp().setClient(false);
        boolean clients = app.checkClient();
    }


}
