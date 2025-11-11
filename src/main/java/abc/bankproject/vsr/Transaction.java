package abc.bankproject.vsr;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "\"transaction\"") // keep current table; it's quoted in DB
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // <— auto-increment
    private Integer transactionId;

    @Column(name = "account_id", nullable = false)
    private Integer accountId;

    @Column(nullable = false)
    private double amount;

    private String description;

    @Column(name = "target_account")
    private Integer targetAccount;

    private String type;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public Transaction() {}

    // getters & setters …
    public Integer getTransactionId() { return transactionId; }
    public Integer getAccountId() { return accountId; }
    public void setAccountId(Integer v) { this.accountId = v; }
    public double getAmount() { return amount; }
    public void setAmount(double v) { this.amount = v; }
    public String getDescription() { return description; }
    public void setDescription(String v) { this.description = v; }
    public Integer getTargetAccount() { return targetAccount; }
    public void setTargetAccount(Integer v) { this.targetAccount = v; }
    public String getType() { return type; }
    public void setType(String v) { this.type = v; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime v) { this.timestamp = v; }
}
