package cl.ibarbagelata.sermaluc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import cl.ibarbagelata.sermaluc.dto.UserResponseDTO;
import cl.ibarbagelata.sermaluc.model.User;
import cl.ibarbagelata.sermaluc.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Test
    public void testRegisterUser() {
        // Crear mocks
        UserService userService = mock(UserService.class);
        BindingResult bindingResult = mock(BindingResult.class);

        // Crear una instancia de UserController
        UserController userController = new UserController(userService);

        // Crear un usuario de prueba
        User user = new User();
        user.setEmail("test@example.com");

        // Configurar el mock de userService
        when(userService.register(user)).thenReturn(new UserResponseDTO());

        // Llamar al método registerUser
        ResponseEntity<?> response = userController.registerUser(user, bindingResult);

        // Verificar que el estado de la respuesta es CREATED
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        // Verificar que userService.register fue llamado una vez
        verify(userService, times(1)).register(user);
    }
}