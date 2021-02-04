package edu.ale.rentofbilds.controllers.rest;

import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.client.impls.CrudClientServiceFakeImpl;
import edu.ale.rentofbilds.service.client.impls.CrudClientServiceMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

    @Autowired
    CrudClientServiceMongoImpl service;

    @RequestMapping("/list")
    List<Client> getClients() {
        System.out.println(service.getAll());
        return service.getAll();
    }

    @RequestMapping("/delete/{id}")
    Client deleteById(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping("/get/{id}")
    Client getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @PostMapping("/create")
    Client create(@RequestBody Client client) {

        return service.create(client);
    }

    @PutMapping("/update")
    Client update(@RequestBody Client client) {
        System.out.println("Hellods sds");
        return service.update(client);
    }
}

