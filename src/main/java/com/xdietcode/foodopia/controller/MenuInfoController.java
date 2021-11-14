package com.xdietcode.foodopia.controller;

import com.xdietcode.foodopia.entity.MenuItem;
import com.xdietcode.foodopia.entity.Restaurant;
import com.xdietcode.foodopia.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody // convert return obj to json, default status=200
    // @ResponseStatus(HttpStatus.OK)
    public List<MenuItem> getAllMenuItems(@PathVariable("restaurantId") int restaurantId) {
        return menuInfoService.getAllMenuItems(restaurantId);
    }

    @RequestMapping(value = "/restaurant", method = RequestMethod.GET)
    @ResponseBody
    public List<Restaurant> getRestaurants() {
        return menuInfoService.getRestaurants();
    }

}
