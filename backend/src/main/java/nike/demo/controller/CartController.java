package nike.demo.controller;

import nike.demo.model.Cart;
import nike.demo.repository.CartRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartRepository cartRepository;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCartByUser(@PathVariable Long userId) {
        Cart cart = cartRepository.findAll().stream()
                .filter(c -> c.getUser().getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Carrinho não encontrado para o usuário: " + userId));
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }
}