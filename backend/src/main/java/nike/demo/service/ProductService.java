package nike.demo.service;

import nike.demo.dto.ProductDTO;
import nike.demo.dto.ProductUniqueDTO;
import nike.demo.mapper.ProductMapper;
import nike.demo.model.Product;
import nike.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository ){
        this.productRepository = productRepository;
    }

    public List<ProductDTO> listAll(){
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toListDTO).toList();
    }

    public ProductUniqueDTO findById(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado" + id));
        return ProductMapper.toUniqueDTO(product);
    }
}
