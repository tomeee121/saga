package TB.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer userId;
    private Integer amount;
}
