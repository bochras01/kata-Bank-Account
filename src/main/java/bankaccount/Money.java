package bankaccount;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private final BigDecimal amount;
    private final String currency;

    public Money(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money usd(BigDecimal amount) {
        return new Money(amount, "USD");
    }

    public Money add(Money money){
        if(!this.currency.equals(money.getCurrency()))
            throw new UnmatchedCurrencyException("unmatched currencies when adding money");
        return new Money(this.amount.add(money.getAmount()), this.currency);
    }

    public Money sub(Money money){
        if(!this.currency.equals(money.getCurrency()))
            throw new UnmatchedCurrencyException("unmatched currencies when substracting money");
        return new Money(this.amount.subtract(money.getAmount()), this.currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money balance = (Money) o;
        return Objects.equals(amount, balance.amount) &&
                Objects.equals(currency, balance.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    private BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

}
