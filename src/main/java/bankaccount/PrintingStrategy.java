package bankaccount;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public interface PrintingStrategy {
    List<Operation> print(AccountHistory accountHistory);

    class DescendingPrinting implements PrintingStrategy {
        @Override
        public List<Operation> print(AccountHistory accountHistory) {
            return accountHistory.getOperations()
                    .stream()
                    .sorted(Comparator.comparing(Operation::getDate).reversed())
                    .collect(toList());
        }
    }

    class AscendingPrinting implements PrintingStrategy {
        @Override
        public List<Operation> print(AccountHistory accountHistory) {
            return accountHistory.getOperations()
                    .stream()
                    .sorted(Comparator.comparing(Operation::getDate))
                    .collect(toList());
        }
    }
}
