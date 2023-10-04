package com.example.jwt.New.controller;


import com.example.jwt.New.entity.Cart;
import com.example.jwt.New.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins= "http://localhost:4200")
public class CartController {

    @Autowired
    private CartService cartService;


    @PreAuthorize("hasRole('User')")
    @GetMapping({"/addToCart/{productId}"})
    public Cart addToCart (@PathVariable (name = "productId") Integer productId ) {

        return cartService.addToCart(productId);
    }

    @PreAuthorize("hasRole('User')")
    @DeleteMapping({"/deleteCartItem/{cartId}"})
    public void deleteCartItem(@PathVariable(name = "cartId") Integer cartId) {
          cartService.deleteCartItem(cartId);
    }


    @PreAuthorize("hasRole('User')")
    @GetMapping({"/getCartDetails"})
    public List<Cart>  getCartDetails () {
      return cartService.getCartDetails();
    }


}
