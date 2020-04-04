package fr.inti.rdlgalaxie.service;

import fr.inti.rdlgalaxie.domain.Customer;
import fr.inti.rdlgalaxie.domain.OrderItem;
import fr.inti.rdlgalaxie.domain.Product;
import fr.inti.rdlgalaxie.domain.ProductOrder;
import fr.inti.rdlgalaxie.domain.User;
import fr.inti.rdlgalaxie.domain.enumeration.OrderItemStatus;
import fr.inti.rdlgalaxie.domain.enumeration.OrderStatus;
import fr.inti.rdlgalaxie.repository.CustomerRepository;
import fr.inti.rdlgalaxie.repository.OrderItemRepository;
import fr.inti.rdlgalaxie.repository.ProductOrderRepository;
import fr.inti.rdlgalaxie.repository.UserRepository;
import fr.inti.rdlgalaxie.security.SecurityUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link ProductOrder}.
 */
@Service
public class ProductOrderService {

	private final Logger log = LoggerFactory.getLogger(ProductOrderService.class);

	private final ProductOrderRepository productOrderRepository;
	private final UserRepository userRepository;
	private final CustomerRepository customerRepository;
	private final OrderItemRepository orderItemRepository;



	public ProductOrderService(CustomerRepository customerRepository, ProductOrderRepository productOrderRepository,
			OrderItemRepository orderItemRepository, UserRepository userRepository) {
		this.customerRepository = customerRepository;
		this.productOrderRepository = productOrderRepository;
		this.orderItemRepository = orderItemRepository;
		this.userRepository = userRepository;
	}

	/**
	 * Save a productOrder.
	 *
	 * @param productOrder the entity to save.
	 * @return the persisted entity.
	 */
	public ProductOrder save(ProductOrder productOrder) {
		log.debug("Request to save ProductOrder : {}", productOrder);
		return productOrderRepository.save(productOrder);
	}

	/**
	 * Get all the productOrders.
	 *
	 * @param pageable the pagination information.
	 * @return the list of entities.
	 */
	public Page<ProductOrder> findAll(Pageable pageable) {
		log.debug("Request to get all ProductOrders");
		return productOrderRepository.findAll(pageable);
	}


	/**
	 * Get one productOrder by id.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	public Optional<ProductOrder> findOne(String id) {
		log.debug("Request to get ProductOrder : {}", id);
		return productOrderRepository.findById(id);
	}

	/**
	 * Delete the productOrder by id.
	 *
	 * @param id the id of the entity.
	 */
	public void delete(String id) {
		log.debug("Request to delete ProductOrder : {}", id);
		productOrderRepository.deleteById(id);
	}

	/*
	 * Ajout d'un objet au panier, création panier si panier non existant.
	 */

	public OrderItem ajoutPanier(Product product) {    	
		String username = SecurityUtils.getCurrentUserLogin().orElse(null);
		User userActuel = userRepository.findOneByLogin(username).orElse(null);
		Customer customerActuel = customerRepository.findByUser(userActuel).orElse(null);

		List<ProductOrder> paniers = productOrderRepository.findByCustomer(customerActuel);
		ProductOrder panier = new ProductOrder();
		Iterator<ProductOrder> it = paniers.iterator();
		ProductOrder pO = new ProductOrder();
		while (it.hasNext()) {
			pO = it.next();
			if (pO.getStatus()==OrderStatus.PENDING) {
				panier = pO;
			}
		}



		// If user does not have a cart firstly generate cart for him/her
		if (panier.getId() == null) {
			panier.setCustomer(customerActuel);
			panier.setStatus(OrderStatus.PENDING);
			panier.setCode(userActuel.getId());
			panier.setPlacedDate(Instant.now());
			panier = this.save(panier);

		} else {
			OrderItem orderItemProduct = orderItemRepository.findByOrderAndProduct(panier, product).orElse(null);

			if (orderItemProduct != null) {
				orderItemProduct.setQuantity(orderItemProduct.getQuantity() + 1);
				orderItemProduct.setTotalPrice(product.getPrice().multiply(new BigDecimal(orderItemProduct.getQuantity())));
				orderItemRepository.save(orderItemProduct); 
				return orderItemProduct;
			} 
		} 

		// Product added to CartProduct entity
		OrderItem orderItem = new OrderItem();
		orderItem.setOrder(panier);
		orderItem.setStatus(OrderItemStatus.AVAILABLE);
		orderItem.setProduct(product);
		orderItem.setQuantity(1);
		orderItem.setTotalPrice(product.getPrice());
		orderItemRepository.save(orderItem);
		return orderItem;
	}

}
