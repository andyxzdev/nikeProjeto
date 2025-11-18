package nike.demo.service;

import nike.demo.model.User;
import nike.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User criar(User user){
        return userRepository.save(user);
    }


}
