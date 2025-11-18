package nike.demo.model;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String function;
    private Arrays cart;
    private Arrays wishList;
    private Arrays viewedProducts;

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

    public Arrays getCart() {
        return cart;
    }

    public void setCart(Arrays cart) {
        this.cart = cart;
    }

    public Arrays getWishList() {
        return wishList;
    }

    public void setWishList(Arrays wishList) {
        this.wishList = wishList;
    }

    public Arrays getViewedProducts() {
        return viewedProducts;
    }

    public void setViewedProducts(Arrays viewedProducts) {
        this.viewedProducts = viewedProducts;
    }
}
