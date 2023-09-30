package orderAPI.comtroller;

import orderAPI.models.Cart;
import orderAPI.service.OrderService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Cart> createOrder(@RequestBody Cart cart) {
        Cart response = orderService.createOrder(cart);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<Cart>> getOrdersByEmail(@PathVariable String email) {
        List<Cart> orders = orderService.getOrdersByEmail(email);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{start}/{end}")
    public ResponseEntity<List<Cart>> getOrdersWithinPeroid(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                                                            @PathVariable("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        List<Cart> orders = orderService.getOrdersWithinPeriod(start, end);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
