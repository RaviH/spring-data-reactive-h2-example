package examples.java.with.ravi.springdatasample.client;

import examples.java.with.ravi.springdatasample.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "carsClient", url = "http://localhost:8089")
public interface CarsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/cars")
    List<CarDTO> getAllCars(
            @PathVariable("customerId")
                    int customerId
    );
}
