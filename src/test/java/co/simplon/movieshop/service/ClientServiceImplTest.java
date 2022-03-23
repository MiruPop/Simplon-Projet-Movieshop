package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Client;
import co.simplon.movieshop.repository.ClientRepository;
import co.simplon.movieshop.repository.CommandeProduitRepository;
import co.simplon.movieshop.repository.CommandeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static co.simplon.movieshop.Fixtures.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;
    Client unClient1 = client1().build();
    Client unClient2 = client2().build();
    List<Client> liste = clientStream().collect(Collectors.toList());

    @BeforeEach
    void setUp() {
        clientRepository.saveAll(liste);
    }

    @AfterEach
    public void tearDown(){
        clientRepository.deleteAll();
    }


    @Test
    void getAllClients() {
        //given
        Client expectedClient = new Client();
        expectedClient.setAdresse("adresse 1");
        when(clientRepository.findAll()).thenReturn(liste);
        //when
        List<Client> listeClients = clientService.getAllClients();

        //then
        assertThat(listeClients.size()).isEqualTo(2);
        assertThat(listeClients.get(0).getAdresse()).isEqualTo(expectedClient.getAdresse());
    }

    @Test
    void selectClientParId() {
        //given
        Long clientId = 1L;
        when(clientRepository.findById(1L)).thenReturn(Optional.ofNullable(unClient1));

        //when
        final Client actualClient = this.clientService.selectClientParId(clientId);

        //then
        assert (actualClient).getNrClient().equals(clientId);
    }

    @Test
    void updateClient() {
//        //given
//        Client underTest = new Client();
//        underTest.setNrClient(1L);
////        Mockito.when(clientRepository.save(ArgumentMatchers.any(Client.class)))
////                .thenReturn(underTest);
//        doNothing().when(clientService).addClient(underTest);
//
//        //when
////        Client actualClient = clientService.updateClient(underTest);
//
//        //then
//        verify(clientService, times(1)).addClient(underTest);
    }

    @Test
    void deleteClient() {
        //given

        //when

        //then
    }

    @Test
    void addClient() {
        //given

        //when

        //then

    }
}