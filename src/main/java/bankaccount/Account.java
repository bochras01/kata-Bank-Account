package bankaccount;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static java.math.BigDecimal.*;

interface AccountUseCase {
    Money deposit(Money amount);
    Money withdraw(Money amount);
    List<Operation> printStatement(PrintingStrategy printingStrategy);
}


public class Account implements AccountUseCase {
    private final String iban;
    private Money balance;
    private AccountHistory accountHistory;

    public Money getBalance() {
        return balance;
    }

    private Account(String iban, Money balance) {
        this.iban = iban;
        this.balance = balance;
        this.accountHistory = new AccountHistory();
    }

    public static Account create(String iban) {
        return new Account(iban,  Money.usd(ZERO));
    }

    @Override
    public Money deposit(Money amount) {
        this.balance = this.balance.add(amount);
        Operation operation = Operation.depositOperation(LocalDateTime.now(), amount, this.balance);
        this.accountHistory = accountHistory.add(operation);
        return this.balance ;
    }

    public AccountHistory getAccountHistory() {
        return accountHistory;
    }

    @Override
    public Money withdraw(Money amount) {
        this.balance = this.balance.sub(amount);
        Operation operation = Operation.withdrawOperation(LocalDateTime.now(), amount, this.balance);
        this.accountHistory=accountHistory.add(operation);
        return this.balance ;
    }


    @Override
    public List<Operation> printStatement(PrintingStrategy printingStrategy) {
       return  printingStrategy.print(accountHistory);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return iban.equals(account.iban);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban);
    }
}
