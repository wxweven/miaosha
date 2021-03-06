package com.todorex.miaosha.controller;

import com.todorex.miaosha.domain.MiaoShaUser;
import com.todorex.miaosha.domain.OrderInfo;
import com.todorex.miaosha.domain.Product;
import com.todorex.miaosha.redis.RedisService;
import com.todorex.miaosha.result.CodeMsg;
import com.todorex.miaosha.result.Result;
import com.todorex.miaosha.service.MiaoShaUserService;
import com.todorex.miaosha.service.OrderService;
import com.todorex.miaosha.service.ProductService;
import com.todorex.miaosha.vo.OrderDetailVo;
import com.todorex.miaosha.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author rex
 * 2018/10/27
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    MiaoShaUserService userService;

    @Autowired
    RedisService redisService;

    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productServicel;

    @RequestMapping("/detail")
    public String info(Model model, MiaoShaUser user,
                       @RequestParam("orderId") long orderId) {

        OrderInfo order = orderService.getOrderById(orderId);
        long productId = order.getProductId();
        ProductVo product = productServicel.getProductVoByProductId(productId);
        model.addAttribute("orderInfo", order);
        model.addAttribute("product", product);
        return "order_detail";
    }
}
