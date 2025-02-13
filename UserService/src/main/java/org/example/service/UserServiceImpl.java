package org.example.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.transaction.Transactional;
import org.example.Repositories.UserRepo;
import org.example.dto.UserDtoRequest;
import org.example.dto.UserDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    // Le nom "userService" est un identifiant pour le circuit breaker
    // Vous pouvez aussi ajouter un `fallbackMethod` qui sera utilisé en cas de panne.
    @CircuitBreaker(name = "userService", fallbackMethod = "fallbackAddUser")
    @Override
    public UserDtoResponse addUser(UserDtoRequest userDtoRequest) {
        try {
            // Simuler une erreur pour tester le circuit breaker
            if (Math.random() > 0.5) {
                throw new RuntimeException("Erreur forcée lors de l'ajout de l'utilisateur !");
            }

            // Logique d'ajout d'utilisateur (remplacez par la logique réelle d'ajout dans la base de données)
            // userRepo.save(new User(...));

            // Retourner une réponse simulée
            UserDtoResponse user = new UserDtoResponse();
            user.setEmail(userDtoRequest.getEmail());
            user.setName(userDtoRequest.getName());
            return user;

        } catch (RuntimeException e) {
            // Si une exception est levée, cela déclenche le CircuitBreaker
            throw new RuntimeException("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage(), e);
        }
    }

    // Méthode de secours en cas de panne
    public UserDtoResponse fallbackAddUser(UserDtoRequest userDtoRequest, Throwable t) {
        // Log de l'erreur pour avoir plus de détails dans les logs
        System.err.println("Méthode de secours activée. Détails de l'erreur : " + t.getMessage());

        // Retourner une réponse d'erreur avec les détails de l'exception
        String errorMessage = "Echec de l'ajout de l'utilisateur. Méthode de secours activée.";
        if (t != null) {
            errorMessage += " Détails de l'erreur : " + t.getMessage();
        }

        return new UserDtoResponse(errorMessage);
    }
}
