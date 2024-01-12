package cl.ibarbagelata.sermaluc.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cl.ibarbagelata.sermaluc.dto.UserResponseDTO;
import cl.ibarbagelata.sermaluc.exception.EmailAlreadyExistsException;
import cl.ibarbagelata.sermaluc.model.User;
import cl.ibarbagelata.sermaluc.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testRegisterUser() {
        // Crear una instancia de UserService
        UserService userService = new UserService(userRepository);

        // Crear un usuario de prueba
        User user = new User();
        user.setEmail("test@example.com");

        // Configurar el mock de userRepository
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());

        // Llamar al método register
        UserResponseDTO response = userService.register(user);

        // Verificar que userRepository.save fue llamado una vez
        verify(userRepository, times(1)).save(user);

        // Verificar que el email en la respuesta es el mismo que el del usuario de prueba
        assertEquals(user.getId(), response.getId());
    }

    @Test
    public void testRegisterUserEmailAlreadyExists() {
        // Crear una instancia de UserService
        UserService userService = new UserService(userRepository);

        // Crear un usuario de prueba
        User user = new User();
        user.setEmail("test@example.com");

        // Configurar el mock de userRepository
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

        // Llamar al método register y verificar que se lanza EmailAlreadyExistsException
        assertThrows(EmailAlreadyExistsException.class, () -> userService.register(user));
    }
}