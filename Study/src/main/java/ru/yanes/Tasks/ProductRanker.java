package ru.yanes.Tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductRanker {
	public static void main(String[] args) {
		Product product1 = new Product("Potato", "Food", 12);
		Product product2 = new Product("Tomato", "Food", 100);
		Product product3 = new Product("Strawberry", "Food", 400);
		Product product4 = new Product("Nike", "Shoes", 1500);
		Product product5 = new Product("Adidas", "Shoes", 1300);
		Product product6 = new Product("Puma", "Shoes", 1350);

		Product product7 = new Product("Demix", "Shoes", 650);
		Product product8 = new Product("Cheese", "Food", 650);

		List<Product> products = Arrays.asList(product1, product2, product3, product4, product5, product6,  product7,  product8);

		Map<String, List<Product>> productsMap = products.parallelStream()
				.collect(
						Collectors.groupingBy(Product::category,
								Collectors.collectingAndThen(Collectors.toList(),
										list -> list.stream()
												.sorted(Comparator.comparingDouble(Product::price).reversed())
												.limit(3)
												.toList())
				));

		System.out.println(productsMap);
	}
	record Product(String name, String category, double price) {}
}

