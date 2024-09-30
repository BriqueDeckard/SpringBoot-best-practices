package exp.deqart.bestpractices.billing.domain;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Bill {
    @Id
    private Integer id;
    private String name;
    private Double ht;
    private Double ttc;
}
