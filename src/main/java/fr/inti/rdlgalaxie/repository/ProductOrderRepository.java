package fr.inti.rdlgalaxie.repository;

import fr.inti.rdlgalaxie.domain.Customer;
import fr.inti.rdlgalaxie.domain.ProductOrder;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the ProductOrder entity.
 */
@Repository
public interface ProductOrderRepository extends MongoRepository<ProductOrder, String> {
	
	List<ProductOrder> findByCustomer(Customer customer);

}
