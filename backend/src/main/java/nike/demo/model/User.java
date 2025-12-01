package nike.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String function; // ou "role" se preferir

    // ======================
    // RELACIONAMENTO COM CARRINHO (CORRIGIDO!)
    // ======================
    @OneToOne(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Cart cart;  // ← Agora é Cart, não String!

    // ======================
    // LISTA DE DESEJOS
    // ======================
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Product> wishlist = new ArrayList<>();

    // ======================
    // PRODUTOS VISUALIZADOS
    // ======================
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Product> viewedProducts = new ArrayList<>();

    // ======================
    // CONSTRUTORES
    // ======================
    public User() {}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    // Carrinho
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    // Lista de desejos
    public List<Product> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Product> wishlist) {
        this.wishlist = wishlist;
    }

    // Produtos visualizados
    public List<Product> getViewedProducts() {
        return viewedProducts;
    }

    public void setViewedProducts(List<Product> viewedProducts) {
        this.viewedProducts = viewedProducts;
    }

    // Método auxiliar (opcional, mas muito útil)
    public void addToWishlist(Product product) {
        wishlist.add(product);
        product.setUser(this); // se você tiver o @ManyToOne no Product
    }

    public void removeFromWishlist(Product product) {
        wishlist.remove(product);
        product.setUser(null);
    }

    // toString (opcional, mas ajuda no debug)
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", function='" + function + '\'' +
                '}';
    }
}