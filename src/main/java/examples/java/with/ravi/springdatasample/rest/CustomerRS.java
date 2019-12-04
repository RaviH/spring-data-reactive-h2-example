package examples.java.with.ravi.springdatasample.rest;

import examples.java.with.ravi.springdatasample.command.CommandOrchestrator;
import examples.java.with.ravi.springdatasample.dto.CarDTO;
import examples.java.with.ravi.springdatasample.entity.Customer;
import examples.java.with.ravi.springdatasample.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
@Validated
public class CustomerRS {

    private CustomerService customerService;
    private CommandOrchestrator commandOrchestrator;

    @Autowired
    public CustomerRS(
            final CustomerService customerService,
            final CommandOrchestrator commandOrchestrator
    ) {

        this.customerService = customerService;
        this.commandOrchestrator = commandOrchestrator;
    }

    @GetMapping(produces = "application/json")
    public Flux<Customer> getAllCustomers(
            @Min(1)
            @Max(Integer.MAX_VALUE)
            @RequestParam(value = "page", defaultValue = "1")
                    int page,
            @Min(1)
            @Max(Integer.MAX_VALUE)
            @RequestParam(value = "size", defaultValue = "10")
                    int size
    ) {

        int offset = ( page - 1 ) * size;
        return customerService.getAllCustomers(offset, size);
    }

    @GetMapping(value = "top/{number}", produces = "application/json")
    public Flux<Customer> findTop10Customers(
            @Min(10)
            @Max(Integer.MAX_VALUE)
            @PathVariable(value = "number")
            final int topN
    ) {

        return customerService.findTop10Customers(topN);
    }

    @PostMapping(path = "/generate", produces = "application/json")
    public Flux<Customer> generateCustomers(
            @RequestParam(value = "numberOfCustomers", defaultValue = "10")
            final int numberOfCustomers
    ) {

        return customerService.generateCustomers(numberOfCustomers);
    }

    @GetMapping(value = "{id}/cars", produces = "application/json")
    public List<CarDTO> getCarsThatCustomerLikes(
            @Min(1)
            @Max(Integer.MAX_VALUE)
            @PathVariable(value = "id")
            final int customerId
    ) {

        return customerService.getCarsThatCustomerLikes(customerId);
    }

    @PostMapping(value = "/execute")
    public void execute() {
        commandOrchestrator.orchestrate();
    }
}
