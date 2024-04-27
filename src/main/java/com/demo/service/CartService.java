package com.sundar.service;

import com.sundar.model.Cart;
import com.sundar.model.CartItem;

import com.sundar.request.AddCartItemRequest;

public interface CartService {

    public CartItem addItemCart(AddCartItemRequest req , String jwt) throws Exception;

    public CartItem updateCartQuantity(Long cartItemId , int quantity) throws Exception;

    public Cart removeItemFromCart(Long cartItemId,String jwt) throws Exception;

    public Long calculateCartTotals(Cart cart) throws  Exception;

    public  Cart findCartById(Long id) throws  Exception;

    public Cart findCartByUserId(Long userId) throws Exception;

    public Cart clearCart(Long userId) throws Exception;



}
