package nike.demo.controller;

import nike.demo.model.Product;
import nike.demo.model.User;
import nike.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final UserRepository userRepository;

    public WishlistController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Product>> getWishlist(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com id: " + userId));

        List<Product> wishlist = user.getWishlist();
        return ResponseEntity.status(HttpStatus.OK).body(wishlist);
    }
}