package nike.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    private String function;
    private String cart;
    private String wishList;
    private String viewedProducts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> wishlist = new ArrayList<>();

    public List<Product> getListaDesejos() {
        return wishlist;
    }

    public void setListaDesejos(List<Product> wishlist) {
        this.wishlist = wishlist;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> viewedproducts = new ArrayList<>();

    public List<Product> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Product> wishlist) {
        this.wishlist = wishlist;
    }

    public List<Product> getViewedproducts() {
        return viewedproducts;
    }

    public void setViewedproducts(List<Product> viewedproducts) {
        this.viewedproducts = viewedproducts;
    }

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

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public String getWishList() {
        return wishList;
    }

    public void setWishList(String wishList) {
        this.wishList = wishList;
    }

    public String getViewedProducts() {
        return viewedProducts;
    }

    public void setViewedProducts(String viewedProducts) {
        this.viewedProducts = viewedProducts;
    }
}
