package com.firstproject.controller;

import com.firstproject.controller.utils.Result;
import com.firstproject.pojo.Order;
import com.firstproject.pojo.ShopCart;
import com.firstproject.service.OrderService;
import com.firstproject.service.StaffService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

import static com.firstproject.controller.utils.Code.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    StaffService staffService;
    @Resource
    OrderService orderService;

    @PostMapping
    public Result addOrder(@RequestBody Map<String, Object> dishes) {
        String orderId = orderService.addOrder(dishes);
        return new Result(orderId.equals("false") ? POST_ERR : POST_OK, orderId);
    }

    @PutMapping
    public Result judgeBalance(@RequestBody Order order) {
        boolean flag = orderService.judgeBalance(order.getUserId(), order.getTotal()) > 0;
        return new Result(flag ? UPDATE_OK : UPDATE_ERR, flag);
    }

    @PutMapping("/end")
    public Result endOrder(@RequestBody Order order) {
        boolean flag1 = orderService.endOrder(order.getOrderId());
        boolean flag2 = staffService.plusSalary(order.getStaffAccount());
        return new Result(flag1 && flag2 ? UPDATE_OK : UPDATE_ERR, flag1 && flag2);
    }

    @GetMapping("/wait/{orderId}")
    public Result getWaitPosition(@PathVariable String orderId) {
        Integer position = orderService.getWaitPosition(orderId);
        return new Result(position == null ? GET_ERR : GET_OK, position);
    }

    @GetMapping
    public Result selectAll() {
        List<Order> orderList = orderService.selectAll();
        return new Result(orderList == null ? GET_ERR : GET_OK, orderList);
    }

    @GetMapping("/{orderId}")
    public Result selectByOrderId(@PathVariable String orderId) {
        List<ShopCart> shopCarts = orderService.selectByOrderId(orderId);
        return new Result(shopCarts == null ? GET_ERR : GET_OK, shopCarts);
    }

    @GetMapping("/mttr")
    public Result getAvgOrderTime() {
        Double second = orderService.getAvgOrderTime();
        return new Result(second == null ? GET_ERR : GET_OK, second);
    }

}
