package by.eugenekulik.taco.controller;


import by.eugenekulik.taco.dao.JPAImpl.JpaOrderRepository;
import by.eugenekulik.taco.dao.JPAImpl.JpaUserRepository;
import by.eugenekulik.taco.domain.Order;
import by.eugenekulik.taco.domain.Taco;
import by.eugenekulik.taco.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;


@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes(value = {"order","tacoList"})
public class OrderController {

    private JpaOrderRepository orderRepository;
    private JpaUserRepository userRepository;

    @Autowired
    public OrderController(JpaOrderRepository jpaOrderRepository, JpaUserRepository userRepository){
        this.userRepository = userRepository;
        this.orderRepository = jpaOrderRepository;
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public  String processOrder(@Valid Order order, Errors errors, @SessionAttribute ArrayList<Taco> tacoList,
                                SessionStatus sessionStatus,@AuthenticationPrincipal User user){
        if(errors.hasErrors()){
            return "orderForm";
        }
        for(Taco taco: tacoList){
            order.addDesign(taco);
        }
        user = userRepository.findByUsername(user.getUsername());
        order.setUser(user);
        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
