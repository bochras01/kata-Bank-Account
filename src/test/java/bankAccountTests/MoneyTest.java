package bankAccountTests;

import bankaccount.Money;
import bankaccount.UnmatchedCurrencyException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    public void creat_money_with_USD_currency(){
        assertThat(Money.usd(BigDecimal.TEN).getCurrency()).isEqualTo("USD");
    }
    @Test
    public void should_add_too_money_amount(){
        final Money money1 = Money.usd(new BigDecimal(1000));
        final Money money2 = Money.usd(new BigDecimal(2000));
        final Money expectedMoney= Money.usd(new BigDecimal(3000));

        assertThat(money1.add(money2)).isEqualTo(expectedMoney);
    }
    @Test
    public void should_throw_exception_when_add_too_money_amount(){
        final Money money1 = Money.usd(new BigDecimal(1000));
        final Money money2 = new Money(new BigDecimal(2000), "EUR");

        assertThatThrownBy(() -> money1.add(money2)).isInstanceOf(UnmatchedCurrencyException.class)
                .withFailMessage("unmatched currencies when adding money");
    }

    @Test
    public void should_substarct_too_money_amount(){
        final Money money1 = Money.usd(new BigDecimal(2000));
        final Money money2 = Money.usd(new BigDecimal(1000));
        final Money expectedMoney= Money.usd(new BigDecimal(1000));

        assertThat(money1.sub(money2)).isEqualTo(expectedMoney);
    }
}
