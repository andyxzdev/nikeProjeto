package nike.demo.service;

import nike.demo.model.Category;
import nike.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Listar todas as categorias
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    // Buscar categoria por ID
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada com o id: " + id));
    }
}