package orderAPI.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String couponCode;
    private String customerEmail;
    private Date orderDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    List<Item> items = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipment_id")
    Shipment shipment;

    public Cart()
    {
        orderDate = new Date();
    }
}
