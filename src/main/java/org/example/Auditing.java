package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Auditing {

    @Pointcut("execution(* check(..))")
    private void login(){}

    @Pointcut("execution(* createService(*))")
    private void getService(){}

    @Pointcut("execution(* success())")
    private void succ(){}

    @Pointcut("execution(* fail())")
    private void fail(){}

    // До перевода средств
    @Before("login()")
    public void validate(JoinPoint joinPoint){
        System.out.println("Банк проверяет ваши учетные данные до перевода средств");
        Object[] account = joinPoint.getArgs();
        System.out.println("Введенные данные");
        System.out.println("----------------");
        System.out.println("Email: " + account[0]);
        System.out.println("Password: " + account[1]);
        System.out.println("----------------");
    }

    // До перевода средств
    @Before("getService()")
    public void transferInstantiate(){
        System.out.println("Банк создает экземпляр сервиса перевода средств");
    }

    // После перевода средств
    @Before("succ()")
    public void success(){
        System.out.println("Банк успешно выполнил перевод средств");
    }

    // После неудачного перевода средств
    @Before("fail()")
    public void rollback() {
        System.out.println("Банк откатил операцию перевода средств");
    }

}
