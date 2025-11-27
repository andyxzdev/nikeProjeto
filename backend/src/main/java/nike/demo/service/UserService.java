package nike.demo.service;

import nike.demo.model.User;
import nike.demo.repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    // o metodo de criar não é void pq depois que vc cria ele, vc ve ele completo, depois de criado
    public User saveUser(User user){
        return userRepository.save(user);
    }

    // o metodo de deletar é void pq ele deleta e nao precisa retornar mais nada, ele só faz e acabou
    public void deleteUser(Long id){
       try {
           userRepository.deleteById(id);
       } catch (EmptyResultDataAccessException e){
           throw new IllegalArgumentException("Usuario nao encontrado com esse id:" + id);
       }

       // try catch aqui é usado com o msm intuito do findById, só que o try catch a gente nao precisa
        // fazer essa busca manualmente pq o try e catch ja faz isso sozinho
        // se usasse o find e o throw, o codigo ia ficar maior e mais complexo
    }

    // aqui usa find ao inves de try catch pq nao tem necessidade. apenas buscamos
    // e retornamos caso nao ache, nada mais alem, ou seja, aqui fazemos uma coisa só (encontrar)
    // o id e no delete sao duas (encontrar (com find) e dps deletar (com delete)entap p try ja faz essa parte do codigo do find)
    public User findTheUser(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este Usuário não existe"));
    }
}
