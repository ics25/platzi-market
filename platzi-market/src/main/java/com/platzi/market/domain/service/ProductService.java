package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productID) {
        return productRepository.getProduct(productID);
    }

    public Optional<List<Product>> getByCategory(int categoryID) {
        return productRepository.getByCategory(categoryID);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    //Devuelve true si el producto fue eliminado correctamente
    //Devuelve false si no lo pudo eliminar
    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);

        //Una alternativa del método anterior
        //if (getProduct(productId).isPresent()){
        //    productRepository.delete(productId);
        //    return true;
        //}else {
        //    return false;
        //}
    }


}
