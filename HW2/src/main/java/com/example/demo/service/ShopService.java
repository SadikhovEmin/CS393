package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.entity.Shop;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShopService {

    private final ShopRepository shopRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public ShopService(
            ShopRepository shopRepository,
            ProductRepository productRepository,
            CustomerRepository customerRepository
    ) {
        this.shopRepository = shopRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    @Transactional
    public void deleteById(int id) {
        // Need to find id of the products that are on shop
        List<Product> products = shopRepository.getAllProductsByShopId(id);
        List<Customer> customers = shopRepository.getAllCustomersByShopId(id);

        for (Product product : products)
            productRepository.deleteByProductId(product.getId());

        for (Customer customer : customers)
            customerRepository.deleteByCustomerId(customer.getId());

        shopRepository.deleteByShopId(id);
    }

    public List<Product> findShopsProductGreaterThan200(int id) {
        return shopRepository.findShopsProductGreaterThan200(id);
    }

    public Shop getSpecificShop(int id) {
        return shopRepository.getSpecificShop(id);
    }

    public void addShop(Shop shop) {
        shopRepository.save(shop);
    }
}
