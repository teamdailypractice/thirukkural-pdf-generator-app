package info.dailypractice.dao;

import info.dailypractice.dto.ThirukkuralLabelDto;
import info.dailypractice.entity.Thirukkural;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ThirukkuralRepository extends CrudRepository<Thirukkural, Long> {

//    @Query("SELECT new com.example.CustomerOrderDTO(c.name, o.orderNumber, oli.productName, oli.quantity, oli.price) " +
//            "FROM Customer c " +
//            "JOIN c.orders o " +
//            "JOIN o.orderLineItems oli " +
//            "WHERE c.id = :customerId")
//    List<CustomerOrderDTO> findCustomerOrders(@org.springframework.data.repository.query.Param("customerId") Long customerId);

}
