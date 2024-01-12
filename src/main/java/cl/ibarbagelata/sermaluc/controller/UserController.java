package cl.ibarbagelata.sermaluc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import cl.ibarbagelata.sermaluc.dto.UserResponseDTO;
import cl.ibarbagelata.sermaluc.model.User;
import cl.ibarbagelata.sermaluc.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Manejo de errores de validación
            String errorMessage = bindingResult.getFieldError().getDefaultMessage();
            ErrorDetails errorDetails = new ErrorDetails(errorMessage);
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }
    
        try {
            UserResponseDTO registeredUser = userService.register(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            ErrorDetails errorDetails = new ErrorDetails(e.getMessage());
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }
    }
}
