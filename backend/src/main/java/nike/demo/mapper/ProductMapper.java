package nike.demo.mapper;

import nike.demo.dto.ProductDTO;
import nike.demo.dto.ProductUniqueDTO;
import nike.demo.model.Product;

public class ProductMapper {
    public static ProductDTO toListDTO (Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImage(),
                product.getCategory()
        );
    }

    public static ProductUniqueDTO toUniqueDTO(Product product){
        return  new ProductUniqueDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImage(),
                product.getDescription(),
                product.getCategory()
        );
    }



}
