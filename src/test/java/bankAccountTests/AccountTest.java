package bankAccountTests;

import bankaccount.Account;
import bankaccount.Money;
import bankaccount.PrintingStrategy;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AccountTest {

    @Mock
    PrintingStrategy printingStrategyMock;
    @Test
    public void should_increase_account_balance(){
        final Account account= Account.create("3000-2021-SG-FR");
        final Money expectedAmount= Money.usd(new BigDecimal(1000));
        account.deposit(Money.usd(new BigDecimal(1000)));
        assertThat(account.getBalance()).isEqualTo(expectedAmount);
    }

    @Test
    public void should_decrease_account_balance(){
        final Account account= Account.create("3000-2021-SG-FR");
        final Money expectedAmount= Money.usd(new BigDecimal(1000));
        account.withdraw(Money.usd(new BigDecimal(-1000)));
        assertThat(account.getBalance()).isEqualTo(expectedAmount);
    }

    @Test
    public void should_call_print_Strategy(){
        final Account account= Account.create("3000-2021-SG-FR");
        account.printStatement(printingStrategyMock);
        verify(printingStrategyMock, times(1)).print(account.getAccountHistory());
    }

}
