package examples.java.with.ravi.springdatasample.service;

import examples.java.with.ravi.springdatasample.client.CarsClient;
import examples.java.with.ravi.springdatasample.dto.CarDTO;
import examples.java.with.ravi.springdatasample.entity.Customer;
import examples.java.with.ravi.springdatasample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CarsClient carsClient;
    private final TestDataGenerator testDataGenerator;

    @Autowired
    public CustomerService(
            final CustomerRepository customerRepository,
            final CarsClient carsClient,
            final TestDataGenerator testDataGenerator
    ) {

        this.customerRepository = customerRepository;
        this.carsClient = carsClient;
        this.testDataGenerator = testDataGenerator;
    }

    public Flux<Customer> getAllCustomers(int page, int size) {

        int offset = ( page - 1 ) * size;
        return customerRepository.getAll(offset, size);
    }

    public Flux<Customer> findTop10Customers(final int topN) {

        return customerRepository.findTopN(topN);
    }

    public Flux<Customer> generateCustomers(final int numberOfCustomers) {

        final List<Customer> customers = testDataGenerator.createCustomer(numberOfCustomers);
        return customerRepository.saveAll(customers);
    }

    public List<CarDTO> getCarsThatCustomerLikes(final int customerId) {

        return carsClient.getAllCars(customerId);
    }
}
