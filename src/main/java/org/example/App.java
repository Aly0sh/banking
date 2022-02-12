package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Service service = context.getBean(Service.class);

        Account account = context.getBean(Account.class);
        if (account.check("Alaken", "12345")){
            if (service.createService(true)){
                service.success();
            }
            else {
                service.fail();
            }
        }

    }
}