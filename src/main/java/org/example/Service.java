package org.example;

import org.springframework.stereotype.Component;

@Component
public class Service {

    public boolean createService(boolean a){
        if (a){
            System.out.println("Банк создал экземпляр сервиса перевода средств");
            return true;
        } else {
            System.out.println("Не удалось создать экземпляр сервиса для перевода средств");
        }
        return false;
    }

    public void success(){
        System.out.println("Банк выдал вам деньги и чек");
    }

    public void fail(){
        System.out.println("Произошла ошибка при переводе денежных средств");
    }
}
