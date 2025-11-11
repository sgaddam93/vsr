package abc.bankproject.vsr;

import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/seed")
    public Transaction seed(@RequestParam String accountId,
                            @RequestParam BigDecimal amount,
                            @RequestParam(defaultValue = "DEBIT") String type) {
        return service.seedOne(accountId, amount, type);
    }

    @GetMapping("/all")
    public List<Transaction> all() {
        return service.all();
    }

    @GetMapping("/high-value")
    public List<Transaction> highValue(@RequestParam(defaultValue = "12000") BigDecimal threshold) {
        return service.highValue(threshold);
    }
}

