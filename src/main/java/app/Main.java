package app;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 600.0),
                new Product("Blender", "Appliances", 40.0)
        );

        Map<String, Double> averagePriceByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.averagingDouble(Product::getPrice)));
        System.out.println("Средняя цена по категориям: " + averagePriceByCategory);

        Optional<Map.Entry<String, Double>> highestAveragePriceCategory = averagePriceByCategory.entrySet().stream().max(Map.Entry.comparingByValue());

        highestAveragePriceCategory.ifPresent(category ->
                System.out.println("Категория с наивысшей средней ценой: " +
                        category.getKey() +
                        ". Средняя цена: " + category.getValue()));
    }
}