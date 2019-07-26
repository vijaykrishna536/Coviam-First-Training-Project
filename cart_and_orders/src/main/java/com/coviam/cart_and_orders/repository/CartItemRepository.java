package com.coviam.cart_and_orders.repository;

import com.coviam.cart_and_orders.entity.CartItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem,Long> {

    @Query(value = "INSERT INTO cartitem (merchant_id, product_id, quantity, cart_id_id) VALUES (?1, ?2, ?3, ?4)",nativeQuery = true)
    void insertCartItem(String merchantId, String productId, Integer quantity, Long cartId);

    @Query(value = "SELECT count(1) from cartitem where product_id =?1 and cart_id_id = ?2 and merchant_id=?3 ",nativeQuery = true)
    Integer findExist(String productId, Long cartId,String merchantId);

    @Query(value = "DELETE FROM cartitem WHERE product_id =?1 and cart_id_id = ?2 and merchant_id=?3",nativeQuery = true)
    void deleteCartItem(String productId, Long cartId,String merchantId);

}
