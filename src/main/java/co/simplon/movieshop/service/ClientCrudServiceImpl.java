package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Client;
import co.simplon.movieshop.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Component
public class ClientCrudServiceImpl implements ClientCrudService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client selectClientParId(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);

        return optionalClient.orElseThrow(() -> new NoSuchElementException("Pas d'élément avec l'id "+ id));
    }

    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

}
