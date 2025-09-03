package com.gcu.topic2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.topic2.model.LoginModel;
import com.gcu.topic2.model.OrderModel;

@Controller
@RequestMapping("/login")
public class LoginController {

    // GET /login/  -> show login form
    @GetMapping({"", "/"})
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    // POST /login/doLogin -> validate, then show orders
    @PostMapping("/doLogin")
    public String doLogin(@jakarta.validation.Valid @ModelAttribute("loginModel") LoginModel loginModel,
                          org.springframework.validation.BindingResult bindingResult,
                          Model model) {

        // If validation fails, stay on the form and show errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Form");
            return "login";
        }

        // ----- random sample orders -----
        Random rnd = new Random();
        String[] products = {
            "USB-C Cable", "Wireless Mouse", "HDMI Adapter", "Laptop Stand",
            "Bluetooth Speaker", "Webcam 1080p", "Mechanical Keyboard",
            "Portable SSD 1TB", "Noise-Canceling Headphones", "USB Hub 7-Port"
        };

        List<OrderModel> orders = new ArrayList<>();
        int count = 4 + rnd.nextInt(4); // 4–7 rows
        for (int i = 1; i <= count; i++) {
            String orderNo = "A" + (100 + rnd.nextInt(900));           // A100–A999
            String product = products[rnd.nextInt(products.length)];
            float price = Math.round((5 + rnd.nextDouble() * 195) * 100) / 100f; // $5–$200
            int qty = 1 + rnd.nextInt(5);                                 // 1–5
            orders.add(new OrderModel((long) i, orderNo, product, price, qty));
        }
        // --------------------------------

        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);
        return "orders"; // looks for src/main/resources/templates/orders.html
    }
}