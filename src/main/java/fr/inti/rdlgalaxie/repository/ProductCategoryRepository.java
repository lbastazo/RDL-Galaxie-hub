package fr.inti.rdlgalaxie.repository;

import fr.inti.rdlgalaxie.domain.ProductCategory;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the ProductCategory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {

}
