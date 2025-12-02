package nike.demo.service;

import nike.demo.model.Cart;
import nike.demo.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // Buscar carrinho pelo ID do usuário (já que cada usuário tem apenas 1 carrinho)
    public Cart getCartByUserId(Long userId) {
        return cartRepository.findAll().stream()
                .filter(cart -> cart.getUser().getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Carrinho não encontrado para o usuário: " + userId));
    }

    // Salvar ou atualizar o carrinho
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }
}