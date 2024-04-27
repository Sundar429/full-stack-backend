package com.sundar.controller;


import com.sundar.model.Food;
import com.sundar.model.Restaurant;
import com.sundar.model.User;
import com.sundar.request.CreateFoodRequest;

import com.sundar.service.FoodService;
import com.sundar.service.RestaurantService;
import com.sundar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String name,
                                           @RequestHeader("Authorization") String jwt) throws Exception {

        User user=userService.findUserByJwtToken(jwt);

       List<Food> foods=foodService.searchFood(name);

        return new ResponseEntity<>(foods, HttpStatus.CREATED);


    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantFood(
            @RequestParam (required = false) boolean vegetarian,
            @RequestParam (required = false) boolean seasonal,
            @RequestParam (required = false) boolean nonVeg,
            @RequestParam (required = false) String foodCategory,
            @PathVariable Long restaurantId,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user=userService.findUserByJwtToken(jwt);

        List<Food> foods=foodService.getRestaurantsFood(restaurantId,vegetarian,nonVeg,seasonal,foodCategory);
//        // Log the parameters received
//        System.out.println("Restaurant ID: " + restaurantId);
//        System.out.println("Vegetarian: " + isVegetarian);
//        System.out.println("Non-Veg: " + isNonVeg);
//        System.out.println("Seasonal: " + isSeasonal);
//        System.out.println("Food Category: " + foodCategory);
//
//        // Your existing code to fetch food items
//
//        // Log the results
//        System.out.println("Fetched Food Items: " + foods);


       return new ResponseEntity<>(foods, HttpStatus.OK);


    }

}
