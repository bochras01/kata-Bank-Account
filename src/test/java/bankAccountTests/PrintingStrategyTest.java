package bankAccountTests;

import bankaccount.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrintingStrategyTest {

    @Test
    public void should_return_history_with_descending_order(){
        final AccountHistory accountHistory= new AccountHistory();
        Operation operation1= new Operation(LocalDateTime.now(), Money.usd(new BigDecimal(10)),Money.usd(new BigDecimal(1000)), OperationType.DEPOSIT);
        accountHistory.getOperations().add(operation1);
        Operation operation2= new Operation(LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40), Money.usd(new BigDecimal(10)),Money.usd(new BigDecimal(1000)), OperationType.DEPOSIT);
        accountHistory.getOperations().add(operation2);
        PrintingStrategy descendingPrinting = new PrintingStrategy.DescendingPrinting();
        List<Operation> operations=  descendingPrinting.print(accountHistory);
        assertThat(operations.get(0).getDate()).isAfter(operations.get(1).getDate());

    }

    @Test
    public void should_return_history_with_ascending_order(){
        final AccountHistory accountHistory= new AccountHistory();
        Operation operation1= new Operation(LocalDateTime.now(), Money.usd(new BigDecimal(10)),Money.usd(new BigDecimal(1000)), OperationType.DEPOSIT);
        accountHistory.getOperations().add(operation1);
        Operation operation2= new Operation(LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40), Money.usd(new BigDecimal(10)),Money.usd(new BigDecimal(1000)), OperationType.DEPOSIT);
        accountHistory.getOperations().add(operation2);
        PrintingStrategy ascendingPrinting = new PrintingStrategy.AscendingPrinting();
        List<Operation> operations=  ascendingPrinting.print(accountHistory);
        assertThat(operations.get(0).getDate()).isBefore(operations.get(1).getDate());

    }
}
