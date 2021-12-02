package com.example.demo.repository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {
    List<Shop> findByAddressContains(String address);

    // Need to always return shop. In case the price of the products are higher than 200 then also show products
    @Query("select s from Shop s inner join s.products p  where p.price > 200 and s.id = ?1")
    List<Shop> getSpecificShop(int id);

    @Query("select s.products from Shop s where s.id=?1")
    List<Product> getAllProductsByShopId(int id);

    @Query("select s.customers from Shop s where s.id=?1")
    List<Customer> getAllCustomersByShopId(int id);

    @Modifying
    @Transactional
    @Query("delete from Shop s where s.id=?1")
    void deleteByShopId(int id);
}
