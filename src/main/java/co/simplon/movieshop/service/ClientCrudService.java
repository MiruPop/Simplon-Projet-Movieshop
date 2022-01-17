package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientCrudService {
    List<Client> getAllClients();

    Client selectClientParId(Long id);

    void addClient(Client client);

    void updateClient(Client client);

    void deleteClient(Client client);
}
