package nike.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item_carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento com o produto (muitos itens do carrinho -> um produto)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    // Removido unique = true → vários itens podem ter o mesmo produto!
    private Product product;

    @Column(nullable = false)
    private int size;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private int quantity;

    // Um usuário tem apenas UM carrinho (ou nenhum)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    // Construtor vazio (exigido pelo JPA)
    public Cart() {
    }

    // ======================
    // GETTERS E SETTERS
    // ======================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Opcional: toString, equals e hashCode (útil para debug e testes)
    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", product=" + (product != null ? product.getId() : null) +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", quantity=" + quantity +
                ", user=" + (user != null ? user.getId() : null) +
                '}';
    }
}