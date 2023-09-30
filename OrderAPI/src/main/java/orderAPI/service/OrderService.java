package orderAPI.service;

import orderAPI.dto.ItemDto;
import orderAPI.dto.mapper.ItemMapper;
import orderAPI.models.Cart;
import orderAPI.repository.OrderRepositry;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;




@Service
public class OrderService {

    private final AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String EXCHANGE_NAME;
    @Value("${rabbitmq.routing.key}")
    private String ROUTING_KEY;

    @Autowired
    private OrderRepositry orderRepositry;
    @Autowired
    private RestTemplate restTemplate;

    public OrderService(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public Cart createOrder(Cart cart) {
        Boolean ch = orderValidation(cart); // orderValidation methos valided productQuantity, Couponcode, BankBalance
        if (!ch)
            return null;

        Cart cart1 = orderRepositry.save(cart);

        //orderExecution(cart);

        amqpTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, cart);
        return cart1;
    }

    private void orderExecution(Cart cart) {

        //  productQuantity,


        // Couponcode,


        // BankBalance
    }

    private Boolean orderValidation(Cart cart) {

        // validate productQuantity

 /*      Boolean ProductValidation;
       ItemDto itemDto = ItemMapper.INSTANCE.itemToItemDTO(cart.getItems().get(0));

        ProductValidation = restTemplate.getForObject("http://localhost:8081/stockItems/products/quantity/"
                + itemDto.getProductId()+"/" + itemDto.getQuantity() ,Boolean.class);
*/
        // validate couponCode


        // validate BankBalance


        return true;
    }

    public List<Cart> getOrdersByEmail(String email) {
        return null;
    }

    public List<Cart> getOrdersWithinPeriod(Date start, Date end) {
        return null;
    }
}
