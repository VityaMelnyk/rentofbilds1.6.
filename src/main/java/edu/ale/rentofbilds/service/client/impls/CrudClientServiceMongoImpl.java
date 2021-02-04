package edu.ale.rentofbilds.service.client.impls;

import edu.ale.rentofbilds.Repository.ClientRepository;
import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.client.interfaces.ICrudClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CrudClientServiceMongoImpl implements ICrudClientService {

//    @Autowired
//    FakeData trash;

    @Autowired
    ClientRepository repository;

    private List<Client> list = new ArrayList<>();

    //    @Override
//    public Client create(Client client) {
//        client.setCreated_at(LocalDateTime.now());
//        client.setModified_at(LocalDateTime.now());
//        return repository.save(client);
//    }

    @PostConstruct
    void init() {
        System.out.println(this.getGroupedByGender());
    }
//        repository.deleteAll();
//        list = trash.getClients();
//        list.size();
//        repository.saveAll(list);
//    }

    @Override
    public Client create(Client client) {
        client.setId(client.getId());
//        client.setName(client.getName());
//        client.setAdress(client.getAdress());
//        client.setPhone(client.getPhone());
//        client.setDateOfBirthday(client.getDateOfBirthday());
//        client.setDescription(client.getDescription());
        client.setCreated_at(LocalDateTime.now());
        client.setModified_at(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Client update(Client client) {
//        client.setId(client.getId());
//        client.setName(client.getName());
//        client.setAdress(client.getAdress());
//        client.setPhone(client.getPhone());
//        client.setDateOfBirthday(client.getDateOfBirthday());
//        client.setDescription(client.getDescription());
        client.setModified_at(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client delete(String id) {
        Client client = this.get(id);
        repository.deleteById(id);
        return client;
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }

    public List<Client> getAllSortedByName() {
        List<Client> list = repository.findAll();
        List<Client> sortedByName = list.stream()
                .sorted(Comparator.comparing(Client::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());

        return sortedByName;
    }

    public Object getAllSortedByBirthday() {
        List<Client> list = repository.findAll();
        List<Client> sortedByBirthday = list.stream()
                .sorted(Comparator.comparing(Client::getDateOfBirthday))
                .collect(Collectors.toList());

        return sortedByBirthday;
    }

    public Object getAllSortedById() {
        List<Client> list = repository.findAll();
        List<Client> sortedById = list.stream()
                .sorted(Comparator.comparing(Client::getId))
                .collect(Collectors.toList());

        return sortedById;
    }

    public Object getAllSortedByPhone() {
        List<Client> list = repository.findAll();
        List<Client> sortedByPhone = list.stream()
                .sorted(Comparator.comparing(Client::getPhone))
                .collect(Collectors.toList());

        return sortedByPhone;
    }

    public List<Client> getByName(String name) {
        if (name.equals("")) return this.getAll();
        return this.getAll().stream().filter(client -> client.getName().contains(name))
                .collect(Collectors.toList());
    }

    public Map<String, Long> getGroupedByGender() {

        return this.getAll().stream()
                .collect(Collectors.groupingBy(Client::getGender, Collectors.counting()));

    }

}

