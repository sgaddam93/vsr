package abc.bankproject.vsr;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repo;

    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    public List<Transaction> all() {
        return repo.findAll();
    }

    public List<Transaction> highValue(BigDecimal min) {
        // repository expects double
        return repo.findHighValue(min.doubleValue());
    }

    public Transaction seedOne(String accountId, BigDecimal amount, String type) {
        Transaction t = new Transaction();           // use no-arg constructor

        // account_id is integer in your table; extract digits if ACC101 etc.
        int accId = parseAccountId(accountId);
        t.setAccountId(accId);

        // amount is double in your entity
        t.setAmount(amount.doubleValue());

        t.setType(type);
        t.setTimestamp(LocalDateTime.now());        // matches your entity’s LocalDateTime
        // optional fields, set if you have them:
        // t.setDescription("seeded via API");
        // t.setTargetAccount(null);

        return repo.save(t);
    }

    private int parseAccountId(String raw) {
        String digits = raw.replaceAll("\\D+", "");
        if (digits.isEmpty()) return 0;
        return Integer.parseInt(digits);
    }
}
