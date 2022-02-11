package org.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Auditing {

    // До перевода средств
    @Before("execution(public boolean Account.check(String, String))")
    public void validate(){
        System.out.println("Банк проверяет ваши учетные данные до перевода средств");
    }

    // До перевода средств
    @Before("execution(public boolean Service.createService())")
    public void transferInstantiate(){
        System.out.println("Банк создает экземпляр сервиса перевода средств");
    }

    // После перевода средств
    @Before("execution(public void Service.success())")
    public void success(){
        System.out.println("Банк успешно выполнил перевод средств");
    }

    // После неудачного перевода средств
    @Before("execution(public void Service.fail())")
    public void rollback() {
        System.out.println("Банк откатил операцию перевода средств");
    }

}
