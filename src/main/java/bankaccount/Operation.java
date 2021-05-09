package bankaccount;

import java.time.LocalDateTime;
import java.util.Objects;

public class Operation {
    private final LocalDateTime date;
    private final Money amount;
    private final Money balance;
    private final OperationType operationType;

    public Operation(LocalDateTime date, Money balance, Money amount, OperationType operationType) {
        this.date = date;
        this.balance= balance;
        this.amount= amount;
        this.operationType= operationType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public static Operation depositOperation(LocalDateTime date, Money balance, Money amount) {
        return new Operation(date, balance,amount,OperationType.DEPOSIT);
    }

    public static Operation withdrawOperation(LocalDateTime date, Money balance, Money amount) {
        return new Operation(date, balance,amount,OperationType.WITHDRAWAL);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(date, operation.date) &&
                Objects.equals(amount, operation.amount) &&
                Objects.equals(balance, operation.balance) &&
                operationType == operation.operationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, balance, operationType);
    }

}
