package bankaccount;

public enum OperationType {
    DEPOSIT("deposit"),
    WITHDRAWAL("withdrawal");

    String operation;

    OperationType(String operation){
        this.operation=operation;
    }
}
