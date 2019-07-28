package com.coviam.cart_and_orders.repository;

import com.coviam.cart_and_orders.entity.Cart;
import com.coviam.cart_and_orders.entity.CartItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, String> {

    @Query(value = "INSERT INTO cartitem (merchant_id, product_id, quantity, cart_id_id) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void insertCartItem(String merchantId, String productId, Integer quantity, Long cartId);

    @Query(value = "SELECT count(1) from cartitem WHERE product_id=  :productId  AND merchant_id= :merchantId", nativeQuery = true)
    Integer findExist(String productId, String merchantId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM cartitem WHERE customer_id=  :customerId", nativeQuery = true)
    Integer deleteByCustomerId(@Param(value = "customerId") Long customerId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE cartitem SET quantity= :quantity WHERE product_id= :productId AND merchant_id= :merchantId AND customer_id= :customerId", nativeQuery = true)
    Integer updateCartItem(@Param(value = "quantity") Integer quantity, @Param(value = "productId") String productId, @Param(value = "merchantId") String merchantId,@Param(value = "customerId") Long customerId);

    List<CartItem> findByCustomerId(Long customerId);

    @Query(value = "Select * FROM cartitem WHERE customer_id= :customerId AND product_id= :productId AND merchant_id= :merchantId",nativeQuery=true)
    CartItem findByCustomerProductMerchantId(@Param(value = "customerId") Long customerId,@Param(value = "productId")String productId, @Param(value = "merchantId")String merchantId);

}
