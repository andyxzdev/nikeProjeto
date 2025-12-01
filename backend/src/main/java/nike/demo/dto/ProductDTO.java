package nike.demo.dto;

public class ProductDTO {
    private Long id;
    private String name;
    private int price;
    private String image;
    private String category;

    public ProductDTO(Long id,String name,int price,String image, String category){
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
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

    public String getCategory() {
        return category;
    }
}
