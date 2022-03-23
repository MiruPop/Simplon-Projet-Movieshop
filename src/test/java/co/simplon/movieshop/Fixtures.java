package co.simplon.movieshop;

import co.simplon.movieshop.model.Client;
import co.simplon.movieshop.model.Utilisateur;

import java.util.stream.Stream;

public final class Fixtures {

    public static Utilisateur.UtilisateurBuilder user1() {
        return Utilisateur.builder()
                .idUtilisateur(1L)
                .email("email")
                .password("pwd");
    };
    public static Utilisateur.UtilisateurBuilder user2() {
        return Utilisateur.builder()
                .idUtilisateur(2L)
                .email("email")
                .password("pwd");
    };

    public static Client.ClientBuilder client1() {
        return Client.builder()
                .nrClient(1L)
                .adresse("adresse 1")
                .telephone("tel1")
                .user(user1().build());
    }
    public static Client.ClientBuilder client2() {
        return Client.builder()
                .nrClient(2L)
                .adresse("adresse 2")
                .telephone("tel2")
                .user(user2().build());
    }

    //streams
    public static Stream<Client> clientStream() {
        return Stream.of(client1().build(),client2().build());
    }
}
