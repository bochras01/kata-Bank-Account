package bankaccount;

public class UnmatchedCurrencyException extends IllegalArgumentException {
    public UnmatchedCurrencyException(String message) {super(message);}
}
