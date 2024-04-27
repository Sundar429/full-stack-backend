package com.sundar.controller;


import com.sundar.model.CartItem;
import com.sundar.model.Order;
import com.sundar.model.User;
import com.sundar.request.AddCartItemRequest;
import com.sundar.request.OrderRequest;
import com.sundar.response.PaymentResponse;
import com.sundar.service.OrderService;
import com.sundar.service.PaymentService;
import com.sundar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public ResponseEntity<PaymentResponse> createOrder(@RequestBody OrderRequest req,

                                                       @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Order order=orderService.createOrder(req,user);
        PaymentResponse res=paymentService.createPaymentLink(order);
        return new ResponseEntity<>(res, HttpStatus.OK);


    }

    @GetMapping("/order/user")
    public ResponseEntity< List<Order>> getOrderHistory(

                                             @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        List<Order> orders=orderService.getUsersOrder(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.OK);


    }
}
