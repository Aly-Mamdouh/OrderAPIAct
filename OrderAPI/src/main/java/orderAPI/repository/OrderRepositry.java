package orderAPI.repository;

import jakarta.persistence.criteria.Order;
import orderAPI.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface  OrderRepositry extends JpaRepository<Cart,Integer> {
    List<Cart> findByCustomerEmail(String customerEmail);

    List<Cart> findByOrderDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
