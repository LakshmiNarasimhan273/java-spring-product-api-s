package com.product_backend.productApi.Controller;

import com.product_backend.productApi.Exception.ResourceNotFound;
import com.product_backend.productApi.Model.Product;
import com.product_backend.productApi.Repository.Product_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class Product_Controller {
    @Autowired
    private Product_Repository productRepo;

    @PostMapping("/addProduct")
    public Product newProduct(@RequestBody Product addProduct){

        return productRepo.save(addProduct);
    }

    @GetMapping("/allProducts")
    public List<Product> allProducts(){
        return productRepo.findAll();
    }
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable Long id){
        return productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Resource Not Found with the id of :- " + id));
    }
    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@RequestBody Product updateProduct, @PathVariable Long id){
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Requested product Not found with the id of " + id));
                product.setProduct_name(updateProduct.getProduct_name());
                product.setProduct_price(updateProduct.getProduct_price());
                product.setProduct_description(updateProduct.getProduct_description());

                return productRepo.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        Product product = productRepo.findById(id)

                .orElseThrow(() -> new ResourceNotFound("Requested Product for Deleting with this id " + id + " was not found in our Database"));
        productRepo.delete(product);

    }

}
