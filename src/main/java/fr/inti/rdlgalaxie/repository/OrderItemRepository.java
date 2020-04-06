package fr.inti.rdlgalaxie.repository;

import fr.inti.rdlgalaxie.domain.OrderItem;
import fr.inti.rdlgalaxie.domain.Product;
import fr.inti.rdlgalaxie.domain.ProductOrder;

import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the OrderItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderItemRepository extends MongoRepository<OrderItem, String> {
	
	Optional<OrderItem> findByOrderAndProduct(ProductOrder order, Product product);
}
