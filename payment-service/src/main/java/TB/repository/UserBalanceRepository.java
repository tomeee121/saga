package TB.repository;

import TB.entity.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBalanceRepository extends JpaRepository<UserBalance, Integer> {
}
