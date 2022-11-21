package by.eugenekulik.taco.controller;


import by.eugenekulik.taco.dao.JpaOrderRepository;
import by.eugenekulik.taco.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "order", produces = "application/json")
public class OrderController {

    @Autowired
    private JpaOrderRepository orderRepository;


    @GetMapping
    public @ResponseBody Iterable<Order> getsAllOrders(){
        return orderRepository.findAll();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteOrder(@PathVariable long id){
        orderRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        if((order = orderRepository.save(order))!=null){
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else return new ResponseEntity<>(order, HttpStatus.BAD_REQUEST);
    }
}
