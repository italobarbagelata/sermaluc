package cl.ibarbagelata.sermaluc.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ibarbagelata.sermaluc.dto.UserResponseDTO;
import cl.ibarbagelata.sermaluc.exception.EmailAlreadyExistsException;
import cl.ibarbagelata.sermaluc.model.User;
import cl.ibarbagelata.sermaluc.repository.UserRepository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO register(User user) {
        Optional<User> existingUserOptional = userRepository.findByEmail(user.getEmail());
        if (existingUserOptional.isPresent()) {
            throw new EmailAlreadyExistsException("El Email ya fue registrado");
        }

        user.setCreated(new Date());
        user.setModified(new Date());
        user.setLastLogin(new Date());
        user.setActive(true);

        user.setToken(UUID.randomUUID().toString());

        userRepository.save(user);

        UserResponseDTO userResponseDTO = modelMapper.map(user, UserResponseDTO.class);

        return userResponseDTO;
    }
}