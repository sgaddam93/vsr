package abc.bankproject.vsr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("select t from Transaction t where t.amount >= :min")
    List<Transaction> findHighValue(double min);
}
