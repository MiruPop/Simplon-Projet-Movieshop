package co.simplon.movieshop.repository;

import co.simplon.movieshop.Fixtures;
import co.simplon.movieshop.model.Client;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static co.simplon.movieshop.Fixtures.client1;
import static co.simplon.movieshop.Fixtures.client2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@DataJpaTest
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    Client unClient1 = client1().build();

    /*
    * créer une classe TestClient exprès pour les besoins du test
    */

    @BeforeEach
    void setUp() {
        this.clientRepository.save(unClient1);
    }
    @AfterEach
    void tearDown() {
        this.clientRepository.deleteAll();
    }

//    @Test
//    void save_success() {
//        Client testClient = client1().build();
//
//        verify(clientRepository).save(testClient);
//    }
    @Test
    void findById_when_valid_id_should_return_expected() {
        //given
        String adresse = "adresse 1";
        //when
        Client actual = clientRepository.findById(1L).get();
        //then
        assertThat(actual.getAdresse()).isEqualTo(adresse);
    }

    @Test
    void findAll_should_return_all() {
        List<Client> listeClients = clientRepository.findAll();
        assertThat(listeClients.size()).isGreaterThanOrEqualTo(1);
    }
}