package com.example.demo;

import com.example.demo.Models.*;
import com.example.demo.Repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseInit implements CommandLineRunner{
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private ProduceRepository produceRepository;
	
	@Autowired
	private SellerProduceRepository sellerProduceRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderedItemRepository orderedItemRepository;
	
	@Override
	 public void run(String... args) throws Exception {
		userRepository.deleteAll();
		produceRepository.deleteAll();
		sellerProduceRepository.deleteAll();
		orderRepository.deleteAll();
		orderedItemRepository.deleteAll();
		
		// Step 1: Create and save users
		User bob = new User("Bob", "bob@sample.com", "bob_pass", UserType.BUYER);
		User prapanch = new User("Prapanch", "prapanch@sample.com", "prapanch_pass", UserType.SELLER);
		User ademola = new User("Ademola", "ademola@sample.com", "ademola_pass", UserType.BOTH);
		User zhixian = new User("Zhixian", "zhixian@sample.com", "zhixian_pass", UserType.BUYER);
		
		userRepository.save(bob);
		userRepository.save(prapanch);
		userRepository.save(ademola);
		userRepository.save(zhixian);
		
		// Step 2: Create and save produce types
		Produce apple = new Produce("Apple");
		Produce lettuce = new Produce("Lettuce");
		Produce potatoes = new Produce("Potatoes");
		
		produceRepository.save(apple);
		produceRepository.save(lettuce);
		produceRepository.save(potatoes);
		
		// Step 3: Add selling/stock information (Seller Produce)
		// Prapanch sells apples for £0.15 (stock 100) and lettuce for £0.25 (stock 20)
		SellerProduce prapanchApple = new SellerProduce(prapanch, apple, 100, 0.15f);
		SellerProduce prapanchLettuce = new SellerProduce(prapanch, lettuce, 20, 0.25f);
		
		// Ademola sells apples for £0.30 (stock 50) and potatoes for £0.05 (stock 30)
		SellerProduce ademolaApple = new SellerProduce(ademola, apple, 50, 0.30f);
		SellerProduce ademolaPotatoe = new SellerProduce(ademola, potatoes, 30, 0.05f);
		
		sellerProduceRepository.save(prapanchApple);
		sellerProduceRepository.save(prapanchLettuce);
		sellerProduceRepository.save(ademolaApple);
		sellerProduceRepository.save(ademolaPotatoe);
		
		// Step 4: Create and save orders
		// Bob places an order for 2 apples from Ademola and 1 lettuce from Prapanch
		Order bobOrder = new Order(bob);
		orderRepository.save(bobOrder);
		
		OrderedItem bobOrderItem1 = new OrderedItem(bobOrder, ademolaApple, 2, 0.30f);
		OrderedItem bobOrderItem2 = new OrderedItem(bobOrder, prapanchLettuce, 1, 0.25f);
		
		orderedItemRepository.save(bobOrderItem1);
		orderedItemRepository.save(bobOrderItem2);
		
		// Zhixian places an order for 10 apples from Prapanch and 15 potatoes from Ademola
		Order zhixianOrder = new Order(zhixian);
		orderRepository.save(zhixianOrder);
		
		OrderedItem zhixianOrderItem1 = new OrderedItem(zhixianOrder, prapanchApple, 10, 0.15f);
		OrderedItem zhixianOrderItem2 = new OrderedItem(zhixianOrder, ademolaPotatoe, 15, 0.05f);
		
		orderedItemRepository.save(zhixianOrderItem1);
		orderedItemRepository.save(zhixianOrderItem2);
	}
}
