package org.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Data
@Component
public class App {
    @Autowired
    private BankClientsApp bankClientsApp;
    @Autowired
    private DataBase dataBase;
    @Autowired
    private TransferByPhoneApp transferByPhoneApp;

    boolean checkClient() throws NoClientsException {
        if (!bankClientsApp.isClient()){
            throw new NoClientsException("Данный пользователь не явлеяется клиетом этого банка");
        }
        return true;
    }

    void transfer(String number, int sum){
        transferByPhoneApp.setSum(sum);
        transferByPhoneApp.setNumber(number);
    }

    void recordBaseDataLastTransfer(){
        dataBase.add(transferByPhoneApp.getNumber(), transferByPhoneApp.getSum());
    }
}
