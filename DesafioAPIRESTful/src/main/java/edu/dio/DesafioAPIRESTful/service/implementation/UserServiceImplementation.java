package edu.dio.DesafioAPIRESTful.service.implementation;

import edu.dio.DesafioAPIRESTful.domain.model.User;
import edu.dio.DesafioAPIRESTful.domain.repository.UserRepository;
import edu.dio.DesafioAPIRESTful.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if(user.getId() != null && userRepository.existsById(user.getId())) {
            throw new IllegalArgumentException("This user ID already exists!");
        }
        return userRepository.save(user);
    }
}
