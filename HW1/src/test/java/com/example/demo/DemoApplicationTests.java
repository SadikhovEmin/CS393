package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private ProductRepository productRepository;


	@Test
	void testSaveAll() {
		Address address = new Address();
		address.setText("Genclik");
		address.setCity("Baku");

		Customer customer = new Customer();
		customer.setFirstName("Emin");
		customer.setLastName("Sadikhov");

		Order order = new Order();
		order.setAmount(25.0);
		order.setDate(new Date());

		Product product = new Product();
		product.setName("Milk");
		product.setPrice(14.0);

		Shop shop = new Shop();
		shop.setName("Bravo");
		shop.setAddress("Genclik/Baku");

		product.setShop(shop);
		product.getOrderList().add(order);

		customer.setAddress(address);
		customer.setShop(shop);
		customer.getOrderList().add(order);


		order.setCustomer(customer);
		order.getProductList().add(product);

		shop.getCustomers().add(customer);
		shop.getProducts().add(product);

		shopRepository.save(shop);

		assertEquals(
				1,
				shopRepository.findAll().size()
		);
		assertEquals(
				1,
				productRepository.findAll().size()
		);
		assertEquals(
				1,
				orderRepository.findAll().size()
		);
		assertEquals(
				1,
				customerRepository.findAll().size()
		);

		System.out.println("shopRepository.findAll().size() = 1" +
				shopRepository.findAll().size() + 1);
	}

	@Test
	void testGetAll() {
		List<Address> addressList = addressRepository.findAll();
		List<Customer> customerList = customerRepository.findAll();
		List<Order> orderList = orderRepository.findAll();
		List<Product> productList = productRepository.findAll();
		List<Shop> shopList = shopRepository.findAll();

		for (Address address : addressList)
			System.out.println("address = " + address);

		for (Customer customer : customerList)
			System.out.println("customer = " + customer);

		for (Order order : orderList)
			System.out.println("order = " + order);

		for (Product product : productList)
			System.out.println("product = " + product);

		for (Shop shop : shopList)
			System.out.println("shop = " + shop);

		assertEquals(
				1,
				shopRepository.findAll().size()
		);
		assertEquals(
				1,
				productRepository.findAll().size()
		);
		assertEquals(
				1,
				orderRepository.findAll().size()
		);
		assertEquals(
				1,
				customerRepository.findAll().size()
		);
	}

}
