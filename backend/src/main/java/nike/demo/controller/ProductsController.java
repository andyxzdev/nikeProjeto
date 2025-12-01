package nike.demo.controller;

import nike.demo.dto.ProductDTO;
import nike.demo.dto.ProductUniqueDTO;
import nike.demo.model.Product;
import nike.demo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService){
        this.productService = productService;
    };

   @GetMapping
    public ResponseEntity<List<ProductDTO>> listAll(){
       List<ProductDTO> products = productService.listAll();
       return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    // List<ClasseDTO> é usada quando precisamos receber uma lista sem id especifico

    @GetMapping("/{id}")
    public ResponseEntity<ProductUniqueDTO> findOne(@PathVariable Long id){
       ProductUniqueDTO productUnique = productService.findById(id);
       return ResponseEntity.status(HttpStatus.OK).body(productUnique);
    }

    // Usamos @PathVariable + Long id quando precisamos receber um unico id especifico
    // mas o metodo e logica é o msm
}
