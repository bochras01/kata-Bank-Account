package bankaccount;

import java.util.ArrayList;
import java.util.List;

public class AccountHistory {

    private  List<Operation> operations;

    public AccountHistory() {
        this.operations = new ArrayList<>();
    }
    public AccountHistory(List<Operation> operations) {
        this.operations = operations;
    }
    public AccountHistory add(Operation operation) {
       List<Operation> newOperation = new ArrayList<>(this.operations);
        newOperation.add(operation);
        return new AccountHistory(newOperation);
    }


    public List<Operation> getOperations() {
        return operations;
    }
}
