package nike.demo.dto;

public class ProductUniqueDTO {
    private Long id;
    private String name;
    private int price;
    private String image;
    private String description;
    private String category;

    public ProductUniqueDTO(Long id,String name, int price, String image,String description,String category){
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}
