package edu.ale.rentofbilds.service.client.interfaces;

import edu.ale.rentofbilds.model.Client;

import java.util.List;

public interface ICrudClientService {
    Client create(Client client);
    Client get(String id);
    Client update(Client client);
    Client delete(String id);
    List<Client> getAll();

}

