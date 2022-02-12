package org.example;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Account {

    @Value("Alaken")
    private String email;

    @Value("12345")
    private String password;

    public boolean check(String email, String password){
        try{
            if (this.email.equals(email) && this.password.equals(password)){
                System.out.println("Авторизация выполнена успешно");
                return true;
            } else{
                throw new Exception("Неправильный пароль");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

}
