package com.firstproject.controller;

import com.firstproject.controller.utils.Result;
import com.firstproject.pojo.Dish;
import com.firstproject.service.DishService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.firstproject.controller.utils.Code.*;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Resource
    private DishService dishService;

    @PostMapping
    public Result insert(@RequestBody Dish dish){
        boolean flag = dishService.insert(dish);
        return new Result(flag ? POST_OK:POST_ERR, flag);
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = dishService.deleteById(id);
        return new Result(flag ? DELETE_OK:DELETE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Dish dish){
        boolean flag = dishService.updateById(dish);
        return new Result(flag ? UPDATE_OK:UPDATE_ERR, flag);
    }

    @GetMapping("{id}")
    public Result selectById(@PathVariable Integer id){
        Dish dish = dishService.selectById(id);
        Integer code  = dish != null ? GET_OK:GET_ERR;
        return new Result(code, dish);
    }

    @GetMapping
    public Result selectAll(){
        List<Dish> dishList = dishService.selectAll();
        Integer code = dishList != null ? GET_OK:GET_ERR;
        return new Result(code, dishList);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result selectByLimit(@PathVariable int currentPage,@PathVariable int pageSize, Dish dish){
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", (currentPage - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("dishName", dish.getDishName());
        map.put("price", dish.getPrice());
        map.put("name", dish.getName());
        List<Dish> dishList = dishService.selectByLimit(map);
        Integer code = dishList != null ? GET_OK:GET_ERR;
        int total = dishService.selectNum();
        if (total <= (currentPage - 1) * pageSize){
            map.put("startIndex", (currentPage - 2) * pageSize);
            dishList = dishService.selectByLimit(map);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("dishList", dishList);
        data.put("total", total);
        return new Result(code, data);
    }
}
