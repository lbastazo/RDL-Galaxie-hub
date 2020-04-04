package fr.inti.rdlgalaxie.repository;

import fr.inti.rdlgalaxie.domain.Customer;
import fr.inti.rdlgalaxie.domain.User;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the Customer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	Optional<Customer> findByUser(User user);

}
