package edu.ale.rentofbilds.service.client.impls;

import edu.ale.rentofbilds.Repository.ClientRepository;
import edu.ale.rentofbilds.data.FakeData;
import edu.ale.rentofbilds.model.Client;
import edu.ale.rentofbilds.model.Item;
import edu.ale.rentofbilds.service.client.interfaces.ICrudClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//@Service
public class CrudClientServiceFakeImpl implements ICrudClientService {

    @Autowired
    FakeData trash;

    @Override
    public Client create(Client client) {
        UUID id = UUID.randomUUID();
        client.setId(id.toString());
        client.setCreated_at(LocalDateTime.now());
        client.setModified_at(LocalDateTime.now());
        trash.getClients().add(client);
        return client;
    }

    @Override
    public Client get(String id) {
        return null;
    }

    @Override
    public Client update(Client client) {
        String id = client.getId();
        Client clientToUpdate = this.getAll().stream().filter(el -> el.getId().equals(id))
                .findFirst().orElse(null);
        int index = this.getAll().indexOf(clientToUpdate);
        client.setModified_at(LocalDateTime.now());
        this.getAll().set(index, client);
        return client;
    }

    @Override
    public Client delete(String id) {
        Client client = this.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
        this.getAll().remove(client);
        return client;
    }

    @Override
    public List<Client> getAll() {
        return trash.getClients();
    }


}
