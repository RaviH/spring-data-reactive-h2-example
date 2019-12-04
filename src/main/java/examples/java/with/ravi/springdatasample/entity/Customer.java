package examples.java.with.ravi.springdatasample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Customer {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
}
