package examples.java.with.ravi.springdatasample.repository;

import examples.java.with.ravi.springdatasample.entity.Customer;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {

    @Query("select * from customer order by id OFFSET :1 ROWS FETCH NEXT :2 ROWS ONLY")
    Flux<Customer> getAll(int offset, int count);

    @Query("select * from customer order by id OFFSET 0 ROWS FETCH NEXT :1 ROWS ONLY")
    Flux<Customer> findTopN(int number);
}