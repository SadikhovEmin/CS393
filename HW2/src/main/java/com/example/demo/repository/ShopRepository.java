package com.example.demo.repository;

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

//    @Query("select s from Shop s where s.id = ?1")
//    Shop pullById(Integer id);

    @Modifying
    @Transactional
    @Query("delete from Shop s where s.id = ?1")
    void deletebyId(int id);


    @Query("select s from Shop s inner join s.products p  where p.price > 10 and s.id = ?1")
    List<Shop> getSpecificShop(int id);
}
